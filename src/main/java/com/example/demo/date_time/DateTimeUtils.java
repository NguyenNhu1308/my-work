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
}
