package com.pmshri.classixalert;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.Calendar;

public final class AlarmScheduler {
    private static final int REQUEST = 9127;
    public static void scheduleNext(Context context) {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if(am==null) return;
        Calendar now=Calendar.getInstance();
        Calendar best=null; PeriodSchedule.Entry chosen=null;
        for(int add=0; add<=7; add++) {
            Calendar date=(Calendar)now.clone(); date.add(Calendar.DAY_OF_YEAR,add);
            PeriodSchedule.Entry[] entries=PeriodSchedule.forDay(date.get(Calendar.DAY_OF_WEEK));
            for(PeriodSchedule.Entry entry:entries) {
                Calendar candidate=(Calendar)date.clone();
                candidate.set(Calendar.HOUR_OF_DAY,entry.hour); candidate.set(Calendar.MINUTE,entry.minute);
                candidate.set(Calendar.SECOND,0); candidate.set(Calendar.MILLISECOND,0);
                if(candidate.after(now) && (best==null || candidate.before(best))) { best=candidate; chosen=entry; }
            }
            if(best!=null) break;
        }
        if(best==null || chosen==null) return;
        Intent i=new Intent(context,AlarmReceiver.class);
        i.putExtra("period",chosen.period); i.putExtra("subject",chosen.subject);
        i.putExtra("teacher",chosen.teacher); i.putExtra("voice",chosen.voice);
        i.putExtra("when",best.getTimeInMillis());
        PendingIntent pi=PendingIntent.getBroadcast(context,REQUEST,i,PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);
        if(Build.VERSION.SDK_INT>=31 && !am.canScheduleExactAlarms()) {
            am.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,best.getTimeInMillis(),pi);
        } else if(Build.VERSION.SDK_INT>=23) {
            am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,best.getTimeInMillis(),pi);
        } else am.setExact(AlarmManager.RTC_WAKEUP,best.getTimeInMillis(),pi);
    }
}
