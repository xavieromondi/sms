package com.okwatch.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.Manifest;
public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSION_REQUEST_SEND_SMS = 0;
    EditText phone,message;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        phone = findViewById(R.id.editTextPhone);
        message = findViewById((R.id.editTextMessage));
        btn = findViewById(R.id.buttonSend);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void sendSMSMessage(){
        String phoneNo = phone.getText().toString();
        String sms = message.getText().toString();
        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS)
                    !=PackageManager.PERMISSION_GRANTED

            //SmsManager smsManager = SmsManager.getDefault();
            //smsManager.sendTextMessage(
                    //phoneNo,null,sms,null,null

            )if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_SEND_SMS);
            }
           // Toast.makeText(getApplicationContext(), "SMS sent", Toast.LENGTH_SHORT).show();

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Sms failed please try again", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }



    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    }