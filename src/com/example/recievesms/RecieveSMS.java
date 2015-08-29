package com.example.recievesms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class RecieveSMS extends BroadcastReceiver
{
	 @Override
	    public void onReceive(Context context, Intent intent)
	    {
	 
	        Bundle bundle = intent.getExtras();
	        SmsMessage[] recievedMsgs = null;
	        String str = "";
	        if (bundle != null)
	        {
	 
	            Object[] pdus = (Object[]) bundle.get("pdus");
	            recievedMsgs = new SmsMessage[pdus.length];
	            for (int i=0; i<recievedMsgs.length; i++){
	            	recievedMsgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);                
	                str += "SMS from " + recievedMsgs[i].getOriginatingAddress();                     
	                str += " :";
	                str += recievedMsgs[i].getMessageBody().toString();
	                str += "\n";        
	            }
	            //---display the new SMS message---
	            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	        }
	    }
}
