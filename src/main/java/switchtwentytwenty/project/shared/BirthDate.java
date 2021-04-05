package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.util.ValueObject;
import switchtwentytwenty.project.util.DateHelper;

import java.util.Calendar;


public class BirthDate implements ValueObject<Calendar> {
    private final Calendar birthDate;

    public BirthDate(String birthDate) {
        this.birthDate = DateHelper.parseDateToCalendar(birthDate);

    }
}
