# Activities and Intents

## Project Details:

Design and implement an app with the following functionality. The app starts off with a
main activity containing a welcome text, empty text field and two buttons. Upon pressing
the first button, your app displays a second activity containing a read-only text field and
an edit text field. The read-only text field prompts the device user to enter a person’s
phone number in the edit text field. Some examples of a valid phone number are:

3124568907

(312) 456 8907

For more information on valid phone number formats see this link:

[http://tools.ietf.org/html/rfc](http://tools.ietf.org/html/rfc)

When the user is done entering the phone number, she/he will press the done or return
key in the soft keyboard. The activity must now check whether a legal phone number
was entered by the user. In this case, the activity will set a result code of “RESULT_OK”;
otherwise, the activity sets a result code of “RESULT_CANCELED”. Either way, the
second activity terminates itself, thereby causing the first activity to become visible
again.

Upon returning from the second activity, the first activity will display the number entered
in the second activity and checks whether the result code was “RESULT_OK”. In this
case, the user may press the second button in the first activity causing the device to
display the dialer activity, **without dialing the phone number.** You must use an existing
Phone app pre-installed in your device when displaying the “dialer” activity. (You are not
allowed to specify what app should be used for the “dialer” activity.) However, if the
result code was “RESULT_CANCELED”, when the user presses the second button, the
first activity displays a toast message informing that device user that she/he entered an
incorrect phone number and includes the number in the toast.

Note that the second activity must return automatically to the first
activity after a user enters a name and presses the return or done
key.

### Implementation Details:

Your app has no knowledge of the specific app to be invoked for dialing the phone
number. You are not responsible for coding or downloading additional apps; you may
assume that a suitable phone app is already installed on your device even though you
don’t know what that app is.

Use an intent extra to pass the phone number from the second activity to the first
activity.

Create an instance of the Toast class with the static message makeText(), which takes
as input 3 arguments. You can then display the toast by calling method show() on the
instance. See the online documentation for additional details.

### Android platform:

For this project use a Pixel 3 XL AVD running Pie API 28
