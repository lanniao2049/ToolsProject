package com.lanniao.java.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

public class Java8TimeApi {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }


    /**
     * java8之前旧的时间api: System.currentTimeMills(),java.util.Date
     */
    public static void test1(){
        long l = System.currentTimeMillis();
        System.out.println("currentTime is : "+l);
        Date dateTime = new Date(l);
        System.out.println("dateTime is "+dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(dateTime);
        System.out.println(format);
        try {
            Date parse = sdf.parse("2022-09-07 12:30:29");
            System.out.println("parse is :" +parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // java.sql.date
        java.sql.Date sqlDate = new java.sql.Date(dateTime.getTime());
        System.out.println("sql Time is :"+sqlDate);

    }

    /**
     * Calendar
     */
    public static void test2(){
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.getTime());
        System.out.println(instance.getTimeZone().getID());
        instance.set(Calendar.YEAR,2089);
        System.out.println(instance.getTime());
        instance.set(2022,10,10,9,18,30);
        System.out.println(instance.getTime());
    }

    /**
     * java8 api LocalDate,LocalTime,LocalDateTime
     */
    public static void test3(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        int dayOfMonth = localDateTime.getDayOfMonth();
        int monthValue = localDateTime.getMonthValue();
        int year = localDateTime.getYear();
        Month month = localDateTime.getMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        int dayOfYear = localDateTime.getDayOfYear();
        int minute = localDateTime.getMinute();
        System.out.println("dayOfMonth:"+dayOfMonth+",monthValue:"+monthValue+",year:"+year+",month:"+month+",dayOfWeek:"+dayOfWeek+",dayOfYear:"+
                dayOfYear+",minute:"+minute);

    }

    /**
     * UTC时区开始
     */
    public static void test4(){
        Instant now = Instant.now();
        System.out.println(now);
        long l = now.toEpochMilli();
        System.out.println(l);
        // 计算中国当前的时间
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM HH:mm:ss");
        String format = offsetDateTime.format(dateTimeFormatter);
        System.out.println(format);
        TemporalAccessor parse = dateTimeFormatter.parse("2022-09 22:54:41");
        System.out.println(parse);
        long second = offsetDateTime.toEpochSecond();
        System.out.println(second);
    }
}
