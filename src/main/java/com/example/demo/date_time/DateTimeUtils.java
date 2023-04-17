package com.example.demo.date_time;


import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
