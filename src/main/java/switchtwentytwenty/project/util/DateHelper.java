package switchtwentytwenty.project.util;


import switchtwentytwenty.project.exceptions.InvalidDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateHelper {

    private DateHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static Calendar parseDateAndTime(String dateString, String timeString) {
        String pattern = "dd/MM/yyyyHH:mm";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateAndTime = dateString + timeString;
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(format.parse(dateAndTime));
        } catch (ParseException e) {
            throw new InvalidDateException("Date is in invalid format");
        }
        return calendar;
    }

    public static Calendar parseDateToCalendar(String dateString) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(format.parse(dateString));
        } catch (NullPointerException e) {
            throw new InvalidDateException("Date is in invalid format");
        } catch (ParseException e) {
            throw new InvalidDateException("Date is in invalid format");
        }
        return calendar;
    }

    // from https://www.baeldung.com/java-check-two-dates-on-same-day
    public static boolean isSameDay(Calendar calendar1, Calendar calendar2) {
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }


}
