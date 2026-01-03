package com.example.utils;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {
    public String Conversion(String text) throws ParseException {
        DateFormat formate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formate2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Date date = formate2.parse(text);
        String dateString = formate1.format(date);
        return dateString;
    }
}
