package switchtwentytwenty.project.domain.model.user_data;

import java.util.Objects;
import java.util.regex.Pattern;

public class Address {
    private final String street;
    private final String postalCode;
    private final String local;
    private final String city;

    /********************** CONSTRUCTORS **********************/

    public Address(String street, String postalCode, String local, String city) {
        if (!validateStreet(street))
            throw new IllegalArgumentException("Insert street.");
        this.street = street;

        if (!validatePostalCode(postalCode))
            throw new IllegalArgumentException("Insert Postal Code correctly");
        this.postalCode = postalCode;

        if (!validateLocal(local))
            throw new IllegalArgumentException("Insert Local correctly");
        this.local = local;

        if (!validateCity(city))
            throw new IllegalArgumentException("Insert City correctly");
        this.city = city;
    }

    /********************** GETTERS AND SETTERS **********************/

    public boolean validateStreet(String street) {
        return street != null && street.trim().length() != 0 && !street.isEmpty();
    }

    public boolean validatePostalCode(String postalCode) {
        String regex = "\\d{4}(-\\d{3})?";
        boolean test = Pattern.matches(regex, postalCode);
        if (postalCode == null || postalCode.trim().length() == 0 || postalCode.isEmpty()) {
            return false;
        } else return test;
    }

    public boolean validateLocal(String local) {
        return local != null && local.trim().length() != 0 && !local.isEmpty();
    }

    public boolean validateCity(String city) {
        return city != null && city.trim().length() != 0 && !city.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(postalCode, address.postalCode) && Objects.equals(local, address.local) && Objects.equals(city, address.city);
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(street, postalCode, local, city);
    }
     */
}
