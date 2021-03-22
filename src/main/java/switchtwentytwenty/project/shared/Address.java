package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidCityException;
import switchtwentytwenty.project.exceptions.InvalidStreetException;
import switchtwentytwenty.project.exceptions.InvalidZipCodeException;
import switchtwentytwenty.project.exceptions.InvalidAddressNumberException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Address implements ValueObject {

    private String street;
    private String city;
    private String zipCode;
    private int number;

    private final static String INVALIDSTREET = "Invalid Street Name";
    private final static String INVALIDCITY = "Invalid City Name";
    private final static String INVALIDZIPCODE = "Invalid Zip Code";
    private final static String INVALIDADDRESSNUMBER = "Invalid Address Number";

    public Address(String street, String city, String zipCode, int number) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.number = number;
        validateData();
        trimData();
    }

    private void trimData() {
        this.street.trim();
        this.city.trim();
        this.zipCode.trim();
    }

    private void validateData() {
        checkStreet();
        checkCity();
        checkZipCode();
        checkNumber();
    }

    private void checkZipCode() {
        if (!validateZipCode()) {
            throw new InvalidZipCodeException(INVALIDZIPCODE);
        }
    }

    private boolean validateZipCode() {
        String regex = "\\d{4}(-\\d{3})?";
        boolean result = Pattern.matches(regex, zipCode);
        if (zipCode == null || zipCode.trim().length() == 0 || zipCode.isEmpty()) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    private void checkNumber() {
        if (!validateNumber()) {
            throw new InvalidAddressNumberException(INVALIDADDRESSNUMBER);
        }
    }

    // Verificar com lógica de negócio
    private boolean validateNumber() {
        return this.number>0;
    }

    // Verificar com lógica de negócio
    private boolean validateCity() {
        return city != null && city.trim().length() != 0 && !city.isEmpty();
    }

    private void checkStreet() {
        if (!validateStreet()) {
            throw new InvalidStreetException(INVALIDSTREET);
        }
    }

    private void checkCity() {
        if (!validateCity()) {
            throw new InvalidCityException(INVALIDCITY);
        }
    }

    // Verificar com lógica de negócio
    private boolean validateStreet() {
        return street != null && street.trim().length() != 0 && !street.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(zipCode, address.zipCode) && Objects.equals(city, address.city) && Objects.equals(number, address.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, zipCode, number, city);
    }


}
