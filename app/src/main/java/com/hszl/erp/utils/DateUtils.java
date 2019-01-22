package com.hszl.erp.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    public static String getDateBylong(long currentTime)
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date(currentTime);
        return sdf.format(date);
    }

    /**
     * 获取当前年
     * @return
     */
    public static int getCurrentYear()
    {
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 按照year年份统计前size年和后size年的统计年份（例如2018）
     * @param year 传入的要统计的中间年份
     * @param size 前后size年
     * @return
     */
    public static List<String> getCurrentYears(int year,int size)
    {
        List<String> list=new ArrayList<>();
        for (int i = size; i >0 ; i--) {
            list.add(String.valueOf(year-i));
        }
        list.add(String.valueOf(year));
        for (int i = 1; i < size+1; i++) {
            list.add(String.valueOf(year+i));
        }
        return list;
    }

    /**
     * 获取月的天数
     * @param month 月份
     * @param isLeapYear 是否为闰年
     * @return
     */
    public static int getDaysOfMonth(int month,boolean isLeapYear)
    {
        int days=0;
        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days=31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days=30;
                break;
            case 2:
                if (isLeapYear)
                    days=29;
                else
                    days=28;
                break;
        }
        return days;
    }

    public static boolean isLeapYear(int year)
    {
        if (year%100==0&&year%400==0)
        {
            return true;
        }else if (year%100!=0&&year%4==0)
        {
            return true;
        }
        return false;
    }

    public static int getCurrentMonth()
    {
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        return month;
    }
}
