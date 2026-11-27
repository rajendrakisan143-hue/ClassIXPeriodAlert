package com.pmshri.classixalert;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String CHANNEL="class_ix_periods";
    @Override public void onReceive(Context context, Intent intent) {
        String subject=intent.getStringExtra("subject");
        String teacher=intent.getStringExtra("teacher");
        String voice=intent.getStringExtra("voice");
        int period=intent.getIntExtra("period",0);
        String title="Class IX – Period "+period+" started";
        String body=subject+"\nTeacher: "+teacher;
        NotificationManager nm=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=26) nm.createNotificationChannel(new NotificationChannel(CHANNEL,"Class IX Period Alerts",NotificationManager.IMPORTANCE_HIGH));
        Notification.Builder b=Build.VERSION.SDK_INT>=26?new Notification.Builder(context,CHANNEL):new Notification.Builder(context);
        b.setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle(title).setContentText(body).setStyle(new Notification.BigTextStyle().bigText(body)).setAutoCancel(true);
        nm.notify(100+period,b.build());
        AlarmScheduler.scheduleNext(context);
        if(voice!=null && !voice.isEmpty()) {
            final android.content.BroadcastReceiver.PendingResult pending=goAsync();
            final TextToSpeech[] holder=new TextToSpeech[1];
            holder[0]=new TextToSpeech(context, status -> {
                TextToSpeech engine=holder[0];
                if(status==TextToSpeech.SUCCESS && engine!=null) {
                    engine.setLanguage(Locale.UK);
                    engine.setSpeechRate(0.92f);
                    if(Build.VERSION.SDK_INT>=21) engine.speak(voice,TextToSpeech.QUEUE_FLUSH,null,"period_alert");
                    else engine.speak(voice,TextToSpeech.QUEUE_FLUSH,null);
                }
                pending.finish();
            });
        }
    }

}
