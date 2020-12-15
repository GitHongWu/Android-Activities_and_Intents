package com.example.proj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    TextView phoneDisplay;
    CharSequence phoneNumber;
    Boolean dialable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enter = (Button) findViewById(R.id.enterBtn);
        Button dial = (Button) findViewById(R.id.dialBtn);
        phoneDisplay = (TextView) findViewById((R.id.textView2));

        //press ENTER button
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("debug", "start enter phone number activity");
                enterNext();
            }
        });

        //press DIAL button
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("debug", "dial start");
                try {
                    dialNext();
                } catch (UnsupportedEncodingException e) {
                    Log.i("debug", "dial catch");
                    e.printStackTrace();
                }
            }
        });
    }

    //get to enter phone number activity
    public void enterNext() {
        Intent intent = new Intent(this, EnterNumberActivity.class);
        startActivityForResult(intent, 99);
    }

    //start dial activity
    public void dialNext() throws UnsupportedEncodingException {
        //if phone number is valid
        if (dialable) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        }
        else{
            //display toast message
            Context context = getApplicationContext();
            CharSequence text = "Need Valid Phone Number";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    //get data from enter phone number activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //did the request go through to contact application
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99) {
            if (data != null) {
                phoneNumber = data.getStringExtra("PhoneNumber");
                phoneDisplay.setText(phoneNumber);
                Log.i("debug", "request 99 ok");
                if (resultCode == RESULT_OK) {
                    dialable = true;
                    Log.i("debug", "Valid phone number");
                } else if (resultCode == RESULT_CANCELED) {
                    dialable = false;
                    Log.i("debug", "Invalid phone number");
                }
            }
            else{
                Log.i("debug", "onActivityResult: data is null");
            }
        }
        //in case request never went through
        else {
            Log.i("debug", "request error");
        }
    }
}