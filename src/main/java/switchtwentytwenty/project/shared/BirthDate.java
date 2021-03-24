package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.util.DateHelper;

import java.util.Calendar;


public class BirthDate {
    private final Calendar birthDate;

    public BirthDate(String birthDate) {
        this.birthDate = DateHelper.parseDateToCalendar(birthDate);

    }
}
