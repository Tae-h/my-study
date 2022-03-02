package com.tae.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static void main(String[] args) {
        String format = "yyyy-MM-dd";
        System.out.println(getDateFormatString(format));
    }


    private static String getDateFormatString(String format) {

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);

        String formatDate = now.format(df);

        return formatDate;
    }


}
