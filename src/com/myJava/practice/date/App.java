package com.myJava.practice.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// Date, Time API
public class App {
    public static void main(String[] args) {
        /**
         * 과거에 사용했던 날짜 포맷
         */
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println("date = " + date);
        long time = date.getTime(); // epoke 타임..?
        System.out.println("time = " + time);


    }
}
