package com.example.my_assignment_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;

public class screen2_messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=new Intent(screen2_messages.this,screen3_news.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(screen2_messages.this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(screen2_messages.this,"10014").setContentTitle("NEWS ALERT")
                .setContentText("Tap to view the news").setDefaults(Notification.DEFAULT_SOUND)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher).setAutoCancel(true).setContentIntent(pendingIntent);



        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            int impt= NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel=new NotificationChannel("10014","my channel",impt);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);

            mbuilder.setChannelId("10014");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(1,mbuilder.build());
    }
}
