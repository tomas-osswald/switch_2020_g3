package switchtwentytwenty.project.util;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.exceptions.InvalidDateException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DateHelperTest {

    @Test
    void parseDateAndTimeTestInvalidDateFormat() {
        String dateString = "10-10-2000";
        String timeString = "12:30";

        assertThrows(InvalidDateException.class,()->DateHelper.parseDateAndTime(dateString,timeString));
    }

    @Test
    void parseDateAndTimeTestInvalidTimeFormat() {
        String dateString = "10/10/2000";
        String timeString = "12h30";

        assertThrows(InvalidDateException.class,()->DateHelper.parseDateAndTime(dateString,timeString));
    }

    @Test
    void parseDateAndTimeTest() {
        String dateString = "10/10/2000";
        String timeString = "12:30";
        Calendar calendar = DateHelper.parseDateAndTime(dateString,timeString);

        assertNotNull(calendar);
    }


    @Test
    void isSameDayTrue() {
        Calendar dateOne = Calendar.getInstance();
        dateOne.set(2013,Calendar.AUGUST,12);
        Calendar dateTwo = Calendar.getInstance();
        dateTwo.set(2013,Calendar.AUGUST,12);

        boolean result = DateHelper.isSameDay(dateOne,dateTwo);

        assertTrue(result);
    }

    @Test
    void isSameDayFalseWrongYear() {
        Calendar dateOne = Calendar.getInstance();
        dateOne.set(2013,Calendar.AUGUST,12);
        Calendar dateTwo = Calendar.getInstance();
        dateTwo.set(2015,Calendar.AUGUST,12);

        boolean result = DateHelper.isSameDay(dateOne,dateTwo);

        assertFalse(result);
    }

    @Test
    void isSameDayFalseWrongMonth() {
        Calendar dateOne = Calendar.getInstance();
        dateOne.set(2013,Calendar.AUGUST,12);
        Calendar dateTwo = Calendar.getInstance();
        dateTwo.set(2013,Calendar.JULY,12);

        boolean result = DateHelper.isSameDay(dateOne,dateTwo);

        assertFalse(result);
    }

    @Test
    void isSameDayFalseWrongDay() {
        Calendar dateOne = Calendar.getInstance();
        dateOne.set(2013,Calendar.AUGUST,12);
        Calendar dateTwo = Calendar.getInstance();
        dateTwo.set(2013,Calendar.AUGUST,5);

        boolean result = DateHelper.isSameDay(dateOne,dateTwo);

        assertFalse(result);
    }

}