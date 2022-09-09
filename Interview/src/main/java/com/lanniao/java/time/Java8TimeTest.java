package com.lanniao.java.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * 经典的java8 time api test
 */
public class Java8TimeTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        LocalDateTime localDateTime = convertDateToLDT(date);
        System.out.println(localDateTime);
        System.out.println(getMilliByTime(localDateTime));
        System.out.println(getSecondsByTime(localDateTime));
        System.out.println(getFormatTime(localDateTime,"yyyy-MM-dd HH:mm:ss SS"));
        System.out.println(getFormatNow("yyyy/MM/dd  HH:mm:ss"));
        System.out.println(getDateStart(localDateTime));
        System.out.println(getDateEnd(localDateTime));

        LocalDateTime plus = plus(localDateTime, 50, ChronoUnit.YEARS);
        System.out.println(plus);
        LocalDateTime minus = minus(localDateTime, 30, ChronoUnit.MINUTES);
        System.out.println(minus);

        Date date1 = convertLDTToDate(localDateTime);
        System.out.println(date1);

        System.out.println("----------------------------");
        LocalDateTime start = LocalDateTime.of(1987, 4, 2, 21, 28, 30);
        LocalDateTime end = LocalDateTime.of(2079, 7, 3, 19, 19, 29);
        System.out.println("时间差 年："+betweenToTime(start,end,ChronoUnit.YEARS));
        System.out.println("时间差 月："+betweenToTime(start,end,ChronoUnit.MONTHS));
        System.out.println("时间差 日："+betweenToTime(start,end,ChronoUnit.DAYS));
        System.out.println("时间差 半日："+betweenToTime(start,end,ChronoUnit.HALF_DAYS));
        System.out.println("时间差 时："+betweenToTime(start,end,ChronoUnit.HOURS));
        System.out.println("时间差 分："+betweenToTime(start,end,ChronoUnit.MINUTES));
        System.out.println("时间差 秒："+betweenToTime(start,end,ChronoUnit.SECONDS));
    }

    /**
     * convert date to localDateTime
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLDT(Date date){
        return LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
    }

    /**
     * convert localDateTime to date
     * @param time
     * @return
     */
    public static Date convertLDTToDate(LocalDateTime time){
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * get localDateTime milli
     * @param time
     * @return
     */
    public static long getMilliByTime(LocalDateTime time){
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * get localDateTime second
     * @param time
     * @return
     */
    public static long getSecondsByTime(LocalDateTime time){
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     *  获取指定日期的格式
     * @param time
     * @param pattern
     * @return
     */
    public static String getFormatTime(LocalDateTime time,String pattern){
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前日期的格式
     * @param pattern
     * @return
     */
    public static String getFormatNow(String pattern){
        return getFormatTime(LocalDateTime.now(),pattern);
    }

    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit temporalUnit){
        return time.plus(number,temporalUnit);
    }

    public static LocalDateTime minus(LocalDateTime time, long number,TemporalUnit temporalUnit){
        return time.minus(number,temporalUnit);
    }

    public static long betweenToTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field){
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS){
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS){
            return period.getYears()*12 + period.getMonths();
        }
        return field.between(startTime,endTime);
    }

    public static LocalDateTime getDateStart(LocalDateTime time){
        return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static LocalDateTime getDateEnd(LocalDateTime time){
        return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

}
