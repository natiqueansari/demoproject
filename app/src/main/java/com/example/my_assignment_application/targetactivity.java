package com.example.my_assignment_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class targetactivity extends AppCompatActivity {
    ListView mylstvww;
    ArrayAdapter addt;
    String [] nm={"posts","messages activity","news activity"};
            String[] clsnames = {"Main2Activity","screen2_messages","screen3_news"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_targetactivity);

        addt = new ArrayAdapter(targetactivity.this, android.R.layout.simple_list_item_1, nm);

        mylstvww = findViewById(R.id.listvieww);
        mylstvww.setAdapter(addt);

       mylstvww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String s = clsnames[position];
               try {
                   Class cls = Class.forName("com.example.my_assignment_application." + s);
                   Intent ij = new Intent(targetactivity.this, cls);
                   startActivity(ij);
               } catch (ClassNotFoundException e) {

                   Toast.makeText(targetactivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
               }
           }


       });
        Intent i=new Intent(targetactivity.this,screen2_messages.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(targetactivity.this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(targetactivity.this,"10001").setContentTitle("MESSAGE RECEIVED")
                .setContentText("click to view the message").setDefaults(Notification.DEFAULT_SOUND)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher).setAutoCancel(true).setContentIntent(pendingIntent);



        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            int impt= NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel=new NotificationChannel("10001","my channel",impt);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);

            mbuilder.setChannelId("10001");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(1,mbuilder.build());
    }
}
