package com.example.demo.date_time;


import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {

    //chuyển đổi ngày từ string -> date
    public static Date to_ddMMyyyy_hhmmss(String dateTime) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return df.parse(dateTime);
    }

    //add thêm giờ trong ngày -> cuối ngày
    public static Date forceTimeEndDay(Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.withTime(23, 59, 59, 999);
        return dateTime.toDate();
    }

    public static String dd_MM_yyyy_HH_mm_ss(Date time) {
        try {
            return time == null ? null : (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(time));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }

    public static void main(String[] args) {

        int date = 20230417;
        String date1 = "18-04-2023";
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate myDate = LocalDate.parse(Integer.toString(date), DateTimeFormatter.BASIC_ISO_DATE);

        Date oldDate = Date.from(myDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(dd_MM_yyyy_HH_mm_ss(oldDate));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("date theo javatime: "+ myDate.format(formatter));
        System.out.println("date theo javatime1: "+ LocalDate.parse(date1, formatter).format(formatter));

        System.out.println("date theo javatime2: " + localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println("date theo javatime plus: " + localDateTime.plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

    }
}
