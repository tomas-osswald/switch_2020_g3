package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.util.DateHelper;

import java.util.Calendar;


public class BirthDate implements ValueObject {
    private final Calendar birthDate;

    public BirthDate(String birthDate) {
        this.birthDate = DateHelper.parseDateToCalendar(birthDate);

    }

    @Override
    public String toString() {
        String date = birthDate.get(Calendar.DAY_OF_MONTH)+"/"+ birthDate.get(Calendar.MONTH)+"/"+ birthDate.get(Calendar.YEAR);
        return date;
    }
}
