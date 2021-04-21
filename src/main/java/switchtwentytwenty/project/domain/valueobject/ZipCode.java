package switchtwentytwenty.project.domain.valueobject;

import lombok.ToString;
import switchtwentytwenty.project.exceptions.InvalidZipCodeException;

import java.util.Objects;
import java.util.regex.Pattern;

@ToString
public class ZipCode implements ValueObject {

    private String zipCode;


    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
        validateData();
    }

    @Override
    public String toString() {
        return this.zipCode;
    }

    private void validateData() {
        checkZipCode();
    }

    private void checkZipCode() {
        String INVALIDZIPCODE = "Invalid Zip Code";
        if (!validateZipCode()) {
            throw new InvalidZipCodeException(INVALIDZIPCODE);
        }
    }

    private boolean validateZipCode() {
        String regex = "\\d{4}(-\\d{3})?";
        boolean result;
        if (zipCode == null || zipCode.trim().length() == 0 || zipCode.isEmpty()) {
            result = false;
        } else {
            result = Pattern.matches(regex, zipCode);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode1 = (ZipCode) o;
        return zipCode.equals(zipCode1.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode);
    }
}
