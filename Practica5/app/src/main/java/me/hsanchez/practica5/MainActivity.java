package me.hsanchez.practica5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText phoneInput;
    private EditText textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkSMSStatePermission();
        setContentView(R.layout.activity_main);

        final EditText phoneInput = (EditText) findViewById(R.id.phoneInput);
        final EditText textInput = (EditText) findViewById(R.id.textInput);
        Button submitBtn = (Button) findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(v -> {
            sendSMS(phoneInput.getText().toString(), textInput.getText().toString());
        });

    }

    private void checkSMSStatePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No tienes permiso para enviar mensajes");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 225);
        } else {
            Log.i("Mensaje", "Tienes permiso para enviar mensajes");
        }
    }

    private void sendSMS(String phone, String msg) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, msg, null, null);
    }
}