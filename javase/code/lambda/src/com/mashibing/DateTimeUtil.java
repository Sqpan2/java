package com.mashibing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

    public static final String DATE_SHORT_MONTH_ENG = "d MMM yyyy";
    public static final Locale LOCALE_ENGLISH       = new Locale("en", "US");
    public static final String DATE_TIME_CN         = "yyyy年MM月dd日";

    public static String dateString(Date date, String pattern, Locale locale) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat dateFm = new SimpleDateFormat(pattern, locale);
            String dateTime = dateFm.format(date);
            return dateTime;
        }
    }

    /**
     * 将日期格式化成一个字符串
     */
    public static String dateString(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat dateFm = new SimpleDateFormat(pattern);
        String dateTime = dateFm.format(date);
        return dateTime;
    }
}
