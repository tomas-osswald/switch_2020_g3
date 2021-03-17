package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class RegistrationDate implements ValueObject {

    private LocalDate registrationDate;

    public RegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
        if (validateDate()) {
            this.registrationDate = LocalDate.now();
        }
    }

    private boolean validateDate(){
        return registrationDate==null;
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
}
