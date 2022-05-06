package com.example.mysendsmsapp;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity
{
private EditText editTextNumber;
private EditText editTextMessage;
@Override
protected void onCreate(Bundle savedInstanceState) 
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
ActivityCompat.requestPermissions(MainActivity.this, new 
String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, 
PackageManager.PERMISSION_GRANTED);
editTextMessage = findViewById(R.id.editText);
editTextNumber = findViewById(R.id.editTextNumber);
}
public void sendSMS(View view){
String message = editTextMessage.getText().toString();
String number = editTextNumber.getText().toString();
SmsManager mySmsManager = SmsManager.getDefault();
mySmsManager.sendTextMessage(number,null, message, null, null);
}
}
<?xml version=”1.0″ encoding=”utf-8″?>
<manifest xmlns:android=”http://schemas.android.com/apk/res/android&#8221;
package=”com.example.mysendsmsapp”>
<uses-permission android:name=”android.permission.SEND_SMS”/>
<uses-permission android:name=”android.permission.RECEIVE_SMS”/>
<uses-permission android:name=”android.permission.READ_SMS”/>
<application
android:allowBackup=”true”
android:icon=”@mipmap/ic_launcher”
android:label=”@string/app_name”
android:roundIcon=”@mipmap/ic_launcher_round”
android:supportsRtl=”true”
android:theme=”@style/AppTheme”>
<activity android:name=”.MainActivity”>
<intent-filter>
<action android:name=”android.intent.action.MAIN” />
<category android:name=”android.intent.category.LAUNCHER” />
</intent-filter>
</activity>
</application>
</manifest>