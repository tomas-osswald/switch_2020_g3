package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.util.DateHelper;

import java.util.Calendar;
import java.util.Objects;


public class BirthDate implements ValueObject {
    private final Calendar birthDate;

    public BirthDate(String birthDate) {
        this.birthDate = DateHelper.parseDateToCalendar(birthDate);

    }

    @Override
    public String toString() {
        return birthDate.get(Calendar.DAY_OF_MONTH)+"/"+ (birthDate.get(Calendar.MONTH)+1)+"/"+ birthDate.get(Calendar.YEAR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate1 = (BirthDate) o;
        return birthDate.equals(birthDate1.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate);
    }
}
