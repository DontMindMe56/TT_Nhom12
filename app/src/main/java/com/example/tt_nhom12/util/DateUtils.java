package com.example.tt_nhom12.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    private final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public String getDateString(Date date) {
        return DATE_FORMAT.format(date);
    }

    public String getTimeString(Date date) {
        return TIME_FORMAT.format(date);
    }

    public String getDateTimeString(Date date) {
        return DATETIME_FORMAT.format(date);
    }

    public Date parseDate(String dateString) throws ParseException {
        return DATE_FORMAT.parse(dateString);
    }

    public Date resetToStartOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public Date endOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    // Tính kỳ theo số ngày (ví dụ: kỳ 7 ngày)
    // start phải là 00:00:00
    // end = start + (days - 1), kết thúc lúc 23:59:59.999
    public Date getPeriodEnd(Date start, int days) {
        Date startNormalized = resetToStartOfDay(start);
        Date end = addDays(startNormalized, days - 1);
        return endOfDay(end);
    }

    public boolean isTheSameDay(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }

    public int daysBetween(Date start, Date end) {
        Date s = resetToStartOfDay(start);
        Date e = resetToStartOfDay(end);
        long diff = e.getTime() - s.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }
}
