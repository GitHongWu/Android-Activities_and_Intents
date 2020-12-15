package com.example.proj1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_number);

        final TextView phoneEditText = (TextView)findViewById(R.id.editTextPhoneNumber);


        //keyboard control, 'DONE' button go back to welcome activity
        phoneEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String phoneNumber = phoneEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("PhoneNumber",phoneNumber);
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    if (phoneVaild(phoneNumber)) {  //phone number vaild
                        setResult(Activity.RESULT_OK, intent);
                        finish();   //back to welcome activity
                        return true;
                    }
                    else{   //phone number NOT vaild
                        setResult(Activity.RESULT_CANCELED, intent);
                        finish();
                        return true;
                    }
                }
                return false;
            }
        });

    }

    //check if phone number valid
    public boolean phoneVaild(String phoneNumber){
        Boolean b;
        Pattern phoneNumberPattern = Pattern.compile("^[0-9]{10}$");    //any number in 10 digites
        Matcher m = phoneNumberPattern.matcher(phoneNumber);
        b = m.matches();
        return b;
    }
}