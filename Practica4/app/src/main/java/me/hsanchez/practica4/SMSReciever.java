package me.hsanchez.practica4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] smsMessages = null;
        if(bundle != null) {
            String information = "SMS Recibido desde: ";
            Object[] pdus = (Object[]) bundle.get("pdus");
            smsMessages = new SmsMessage[pdus.length];
            for (int i = 0; i < smsMessages.length; i++) {
                SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
                information += message.getOriginatingAddress() + "\n ***** Mensaje ***** \n" + message.getMessageBody().toString();
                smsMessages[i] = message;
            }

            Toast.makeText(context, information, Toast.LENGTH_SHORT).show();
        }
    }
}
