package switch2020.project.model;

import java.util.regex.Pattern;

public class Address {
    private final String street;
    private final String postalCode;
    private final String local;
    private final String city;

    /********************** CONSTRUCTORS **********************/

    public Address(String street, String postalCode,String local, String city){
        if(!validateStreet(street))
            throw new IllegalArgumentException("Insert street.");
        this.street = street;

        if(!validatePostalCode(postalCode))
            throw new IllegalArgumentException("Insert Postal Code correctly");
        this.postalCode = postalCode;

        if(!validateLocal(local))
            throw new IllegalArgumentException("Insert Local correctly");
        this.local = local;

        if(!validateCity(city))
            throw new IllegalArgumentException("Insert City correctly");
        this.city = city;
    }

    /********************** GETTERS AND SETTERS **********************/

    public boolean validateStreet(String street){
        if (street == null || street.isBlank() || street.isEmpty())
            return false;
        return true;
    }

    public boolean validatePostalCode(String postalCode){
        String regex = "\\d{4}(-\\d{3})?";
        boolean test = Pattern.matches(regex, postalCode);
        if (postalCode == null || postalCode.isBlank() || postalCode.isEmpty()) {
            return false;
        }else if(!test) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateLocal(String local){
        if (local == null || local.isBlank() || local.isEmpty())
            return false;
        return true;
    }

    public boolean validateCity(String city){
        if (city == null || city.isBlank() || city.isEmpty())
            return false;
        return true;
    }
}
