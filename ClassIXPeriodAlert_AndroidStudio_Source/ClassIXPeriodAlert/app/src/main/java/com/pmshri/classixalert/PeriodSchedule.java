package com.pmshri.classixalert;

import java.util.Calendar;

public final class PeriodSchedule {
    public static class Entry {
        public final int period, hour, minute;
        public final String subject, teacher, voice;
        Entry(int p, int h, int m, String s, String t, String v) {
            period=p; hour=h; minute=m; subject=s; teacher=t; voice=v;
        }
    }
    // Calendar.DAY_OF_WEEK: Sunday=1, Monday=2 ... Saturday=7.
    // Source: uploaded 2026-27 Teacher Wise timetable, Class IX entries.
    private static Entry e(int p,int h,int m,String s,String t) {
        String v = "Attention Class Nine. Period " + p + " has started. " + s + ". Teacher: " + t + ".";
        return new Entry(p,h,m,s,t,v);
    }
    public static Entry[] forDay(int day) {
        switch(day) {
            case Calendar.MONDAY: return new Entry[]{
                e(1,10,15,"English","Minaketan Meher"), e(2,11,0,"Odia","Sukanta Behera"),
                e(3,11,45,"Mathematics","Rajendra Kishan"), e(4,12,30,"SCL","Smrutiranjan Behera"),
                new Entry(5,13,45,"AUTO and BFSI","Pritam Pradhan and Abhisheka Behera", "Attention Class Nine. Period Five has started. Automotive students, Pritam Pradhan. Banking, Financial Services and Insurance students, Abhisheka Behera. Please attend your respective groups."),
                e(6,14,30,"SSC","Lilima Pradhan"), e(7,15,15,"ROB","Kanhu Charan Mahanta")};
            case Calendar.TUESDAY: return new Entry[]{
                e(1,10,15,"English","Minaketan Meher"), e(2,11,0,"Odia","Sukanta Behera"),
                e(3,11,45,"SSC","Lilima Pradhan"), e(4,12,30,"SCP","Punam Horo"),
                new Entry(5,13,45,"AUTO and BFSI","Pritam Pradhan and Abhisheka Behera", "Attention Class Nine. Period Five has started. Automotive students, Pritam Pradhan. Banking, Financial Services and Insurance students, Abhisheka Behera. Please attend your respective groups."),
                e(6,14,30,"Mathematics","Rajendra Kishan"), e(7,15,15,"KRI","Niranjan Sahu")};
            case Calendar.WEDNESDAY: return new Entry[]{
                e(1,10,15,"English","Minaketan Meher"), e(2,11,0,"Odia","Sukanta Behera"),
                e(3,11,45,"Mathematics","Rajendra Kishan"), e(4,12,30,"SCL","Smrutiranjan Behera"),
                new Entry(5,13,45,"AUTO and BFSI","Pritam Pradhan and Abhisheka Behera", "Attention Class Nine. Period Five has started. Automotive students, Pritam Pradhan. Banking, Financial Services and Insurance students, Abhisheka Behera. Please attend your respective groups."),
                e(6,14,30,"SSC","Lilima Pradhan"), e(7,15,15,"ROB","Kanhu Charan Mahanta")};
            case Calendar.THURSDAY: return new Entry[]{
                e(1,10,15,"English","Minaketan Meher"), e(2,11,0,"Odia","Sukanta Behera"),
                e(3,11,45,"Mathematics","Rajendra Kishan"), e(4,12,30,"SCL","Smrutiranjan Behera"),
                e(5,13,45,"SSC","Lilima Pradhan"), e(6,14,30,"SCP","Punam Horo"), e(7,15,15,"KRI","Niranjan Sahu")};
            case Calendar.FRIDAY: return new Entry[]{
                e(1,10,15,"English","Minaketan Meher"), e(2,11,0,"Odia","Sukanta Behera"),
                e(3,11,45,"Mathematics","Rajendra Kishan"),
                new Entry(4,12,30,"AUTO and BFSI","Pritam Pradhan and Abhisheka Behera", "Attention Class Nine. Period Four has started. Automotive students, Pritam Pradhan. Banking, Financial Services and Insurance students, Abhisheka Behera. Please attend your respective groups."),
                e(5,13,45,"SSC","Lilima Pradhan"), e(6,14,30,"SCP","Punam Horo"), e(7,15,15,"SRUJANI","Minaketan Meher")};
            case Calendar.SATURDAY: return new Entry[]{
                e(2,11,0,"English","Minaketan Meher"), e(3,11,45,"SSC","Lilima Pradhan"),
                e(4,12,30,"Mathematics","Rajendra Kishan"), e(5,13,45,"Odia","Sukanta Behera"),
                e(6,14,30,"SCP","Punam Horo"), e(7,15,15,"JIGYANSA","Punam Horo")};
            default: return new Entry[0];
        }
    }
}
