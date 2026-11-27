package com.pmshri.classixalert;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        LinearLayout layout=new LinearLayout(this); layout.setOrientation(LinearLayout.VERTICAL); layout.setPadding(36,48,36,36); layout.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView title=new TextView(this); title.setText("CLASS IX PERIOD ALERT"); title.setTextSize(25); title.setGravity(Gravity.CENTER); layout.addView(title);
        TextView info=new TextView(this); info.setText("Automatic English notifications and voice announcements\nMonday–Saturday\n10:15 AM–4:00 PM\nLunch: 1:15–1:45 PM\n\nKeep this app installed. Allow notifications and exact alarms for the most reliable alerts."); info.setTextSize(17); info.setPadding(0,32,0,32); layout.addView(info);
        Button enable=new Button(this); enable.setText("ENABLE PERIOD ALERTS"); layout.addView(enable);
        enable.setOnClickListener(v -> {
            if(Build.VERSION.SDK_INT>=33 && checkSelfPermission("android.permission.POST_NOTIFICATIONS")!=android.content.pm.PackageManager.PERMISSION_GRANTED) requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"},44);
            if(Build.VERSION.SDK_INT>=31) {
                AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
                if(am!=null && !am.canScheduleExactAlarms()) startActivity(new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM, Uri.parse("package:"+getPackageName())));
            }
            AlarmScheduler.scheduleNext(this);
        });
        setContentView(layout);
        AlarmScheduler.scheduleNext(this);
    }
    @Override protected void onResume(){ super.onResume(); AlarmScheduler.scheduleNext(this); }
}
