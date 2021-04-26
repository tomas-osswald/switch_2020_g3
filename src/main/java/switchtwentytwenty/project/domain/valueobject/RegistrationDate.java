package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.util.DateHelper;

import java.util.Calendar;
import java.util.Objects;

public class RegistrationDate implements ValueObject {

    private Calendar registrationDate;

    /**
     * Constructor for a RegistrationDate Object, if the argument registrationDate is null the registration date will be the current date
     *
     * @param registrationDate a LocalDate object that will represent the date of the registration
     */
    public RegistrationDate(String registrationDate) {
        if (isDateNull(registrationDate)) {
            this.registrationDate = Calendar.getInstance();
        } else {

            this.registrationDate = DateHelper.parseDateToCalendar(registrationDate);
        }
    }

    /**
     * Method to determine if a date is valid, i.e. not null
     *
     * @return boolean - returns true if the date is valid, false if it is null
     */
    private boolean isDateNull(String registrationDate) {
        return registrationDate == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationDate)) return false;
        RegistrationDate that = (RegistrationDate) o;
        return registrationDate.equals(that.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationDate);
    }

    @Override
    public String toString() {
        String date = registrationDate.get(Calendar.DAY_OF_MONTH)+"/"+ (registrationDate.get(Calendar.MONTH)+1)+"/"+ registrationDate.get(Calendar.YEAR);
        return date;
    }
}
