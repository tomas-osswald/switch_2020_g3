package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.exceptions.InvalidAddressNumberException;

import java.util.Objects;

public class DoorNumber implements ValueObject {

    private String doorNumber;


    public DoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
        validateData();
    }

    @Override
    public String toString() {
        return this.doorNumber;
    }

    private void validateData() {
        checkNumber();
    }

    private void checkNumber() {
        String INVALIDADDRESSNUMBER = "Invalid Address Number";
        if (this.doorNumber == null || this.doorNumber.isEmpty() || this.doorNumber.trim().length()==0) {
            throw new InvalidAddressNumberException(INVALIDADDRESSNUMBER);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoorNumber that = (DoorNumber) o;
        return Objects.equals(doorNumber, that.doorNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doorNumber);
    }


}
