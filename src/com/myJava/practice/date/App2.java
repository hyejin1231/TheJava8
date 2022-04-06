package com.myJava.practice.date;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// Date, Time API
public class App2 {
    public static void main(String[] args) {

        System.out.println("====기계적 시간 표현하기====");
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 (UTC == GMT)
        System.out.println("instant.atZone(ZoneId.systemDefault()) = " + instant.atZone(ZoneId.of("UTC")));

        System.out.println("==== 현재 시스템 기준 시간 표현하기 ====");
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault()); // 시스템 기준 시간
        System.out.println("zonedDateTime = " + zonedDateTime);

        System.out.println("==== 현재 시간 ====");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime birthDay = LocalDateTime.of(1998, Month.DECEMBER, 31, 0, 0, 0);
        System.out.println("birthDay = " + birthDay);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea = " + nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTime1 = " + zonedDateTime1);


        System.out.println("==== 기간 표현하는 방법 ====");
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2022, Month.DECEMBER, 31);

        Period period = Period.between(today, thisYearBirthDay);
        System.out.println("period.getDays() = " + period.getDays());

        Period until = today.until(thisYearBirthDay);
        System.out.println("until.get(ChronoUnit.DAYS) = " + until.get(ChronoUnit.DAYS));


        System.out.println("==== LocalDateTime ==== ");
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("now.format(MMddyyyy) = " + now1.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("12/31/1998", MMddyyyy);
        System.out.println("parse = " + parse);

        LocalDateTime plus = now1.plus(10, ChronoUnit.DAYS);
        System.out.println("plus = " + plus);
    }
}
