package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidCityException;
import switchtwentytwenty.project.exceptions.InvalidStreetException;
import switchtwentytwenty.project.exceptions.InvalidZipCodeException;
import switchtwentytwenty.project.exceptions.InvalidAddressNumberException;

public class Address implements ValueObject {

    private String street;
    private String city;
    private String zipCode;
    private String number;

    private final static String INVALIDSTREET = "Invalid Street Name";
    private final static String INVALIDCITY = "Invalid City Name";
    private final static String INVALIDZIPCODE = "Invalid Zip Code";
    private final static String INVALIDADDRESSNUMBER = "Invalid Address Number";

    public Address(String street, String city, String zipCode, String number) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.number = number;
        validateData();
    }

    private void validateData() {
        checkStreet();
        checkCity();
        checkZipCode();
        checkNumber();
    }

    private void checkZipCode() {
        if(!validateZipCode()){
            throw new InvalidZipCodeException(INVALIDZIPCODE);
        }
    }

    private boolean validateZipCode() {
        return true;
    }

    private void checkNumber(){
        if(!validateNumber()) {
            throw new InvalidAddressNumberException(INVALIDADDRESSNUMBER);
        }
    }

    // Verificar com lógica de negócio
    private boolean validateNumber() {
        return true;
    }

    // Verificar com lógica de negócio
    private boolean validateCity() {
    return true;
    }

    private void checkStreet() {
        if(!validateStreet()){
            throw new InvalidStreetException(INVALIDSTREET);
        }
    }

    private void checkCity() {
        if(!validateCity()){
            throw new InvalidCityException(INVALIDCITY);
        }
    }

    // Verificar com lógica de negócio
    private boolean validateStreet() {
    return true;
    }


}
