package com.tae.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static void main(String[] args) throws ParseException {
        String format = "yyyy-MM-dd HH:mm";
        System.out.println(getDateFormatString(format));

        getDateFormat();

        String date = "2022-04-05 19:30";
        String ss = getDateFormatStrKor(format, date, "011111");

        System.out.println(ss);




    }


    private static String getDateFormatString(String format) {

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);

        String formatDate = now.format(df);

        return formatDate;
    }

    private static String getDateFormat() throws ParseException {

        String dateStr = "2022-03-04 19:30";

        /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = format.parse(dateStr);
        System.out.println(date);*/

        //LocalDate localDate = LocalDate.of(2022, 3, 4);
        LocalDate localDate = LocalDate.parse(dateStr.substring(0, 10));
        System.out.println(localDate);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();


        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN));

        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.KOREAN));
        System.out.println(localDate.getDayOfMonth()+"일");

        System.out.println(dateStr.substring(11, 13));
        System.out.println(dateStr.substring(14, 16));

        System.out.println("========================");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, df);
        System.out.println(localDateTime);
        System.out.println(localDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
        System.out.println(localDateTime.getYear() + "년");
        System.out.println(localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.KOREAN));
        System.out.println(localDateTime.getDayOfMonth() + "일");
        System.out.println(localDateTime.getHour() + "시");
        System.out.println(localDateTime.getMinute()+ "분");

        System.out.println(localDateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));


        return "";
    }


    public static String getDateFormatStrKor(String format, String date, String form) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDateTime dateTime = LocalDateTime.parse(date, df);


        String year = dateTime.getYear() + "년";
        String month = dateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.KOREAN);
        String day = dateTime.getDayOfMonth() + "일";
        String dayOfWeek = "(" + dateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN) + ")"; // O요일
        String hour = dateTime.getHour() + "시";
        String minute = dateTime.getMinute() + "분";

        String[] timeArr = {
                year, month, day, dayOfWeek, hour, minute
        };

        StringBuilder result = new StringBuilder();
        if ( !"".equals(form)) {

            for ( int i = 0; i < timeArr.length; i++ ) {
                if ( form.charAt(i) == '1' ) {
                    result.append(timeArr[i]).append(" ");
                }
            }

            return result.toString().trim();
        }


        return String.format("%s %s %s %s %s %s", year, month, day, dayOfWeek, hour, minute);


    }

}
