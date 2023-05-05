package com.example.demo.date_time;


import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTimes {

    public static void oldDateToLocalDateTime()
    {
        Date now = Calendar.getInstance().getTime();
        Instant instant = Instant.ofEpochMilli(now.getTime());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(now);
        System.out.println((new Date()));
        System.out.println(localDateTime.toLocalDate());
    }

    public static void oldDateToLocalDateTimeSecondOption()
    {
        Date now = Calendar.getInstance().getTime();
        Instant instant = now.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(now);
        System.out.println(localDateTime);
    }
    public static void oldDateToLocalDate()
    {
        Date now = Calendar.getInstance().getTime();
        LocalDate yesterday = LocalDate.of(2023, 3, 12);
        Instant instant = Instant.ofEpochMilli(now.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        if(localDate.isAfter(yesterday)){
            System.out.println("ok");
        }else
            System.out.println("not ok");
        System.out.println(now);
        System.out.println(localDate);
    }

    public static void oldDateToLocalDateSecond()
    {
        Date now = Calendar.getInstance().getTime();
        Instant instant = now.toInstant();
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        System.out.println(now);
        System.out.println(localDate);
    }

    public static void oldDateToLocalTime()
    {
        Date now = Calendar.getInstance().getTime();
        Instant instant = Instant.ofEpochMilli(now.getTime());
        LocalTime localTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
        System.out.println(now);
        System.out.println(localTime);

    }

    public static void oldDateToLocalTimeSecondOption()
    {
        Date now = Calendar.getInstance().getTime();
        Instant instant = now.toInstant();
        LocalTime localTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
        System.out.println(now);
        System.out.println(localTime);

    }

    public static void localDateTimeToOldDate()
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date oldDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(localDateTime);
        System.out.println(oldDate);
    }

    public static void localDateToOldDate()
    {
        LocalDate localDate = LocalDate.now();
        Date oldDate =
                Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(localDate);
        System.out.println(oldDate);
    }

    public static void localTimeToOldDate()
    {
        LocalTime localTime = LocalTime.now();

        Instant instant = localTime.atDate(LocalDate.of(2015, 11, 11)).
                atZone(ZoneId.systemDefault()).toInstant();
        Date oldDate = Date.from(instant);
        System.out.println(oldDate);
        System.out.println(localTime);

    }

    public static void main(String[] args) {
        LocalDateTimes.oldDateToLocalDateTime();
        LocalDateTimes.oldDateToLocalDate();

        Integer a = null;
        String.valueOf(a);

        System.out.println( String.valueOf(a));
//        LocalDateTimes.oldDateToLocalDateTimeSecondOption();
    }
}
