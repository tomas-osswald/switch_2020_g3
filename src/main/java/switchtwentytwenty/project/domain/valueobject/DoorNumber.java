package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.exceptions.InvalidAddressNumberException;

import java.util.Objects;

public class DoorNumber implements ValueObject {

    private Integer number;


    public DoorNumber(int number) {
        this.number = number;
        validateData();
    }

    @Override
    public String toString() {
        return this.number.toString();
    }

    private void validateData() {
        checkNumber();
    }

    private void checkNumber() {
        String INVALIDADDRESSNUMBER = "Invalid Address Number";

        if (!validateNumber()) {
            throw new InvalidAddressNumberException(INVALIDADDRESSNUMBER);
        }
    }

    // Verificar com lógica de negócio
    private boolean validateNumber() {
        return this.number > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoorNumber that = (DoorNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int toInt() {
        return this.number;
    }
}
