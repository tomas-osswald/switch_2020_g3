package switch2020.project.model;

import java.util.Objects;

public class Address {
    private final String street;
    private final String postalCode;
    private final String local;
    private final String city;

    /********************** CONSTRUCTORS **********************/

    public Address(String street, String postalCode,String local, String city){
        if(!validateEmpty(street))
            throw new IllegalArgumentException("Inserir Rua");
        this.street = street;

        if(!validateEmpty(postalCode))
            throw new IllegalArgumentException("Inserir Codigo Postal");
        this.postalCode = postalCode;

        if(!validateEmpty(local))
            throw new IllegalArgumentException("Inserir Localidade");
        this.local = local;

        if(!validateEmpty(city))
            throw new IllegalArgumentException("Inserir Cidade");
        this.city = city;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validateEmpty(String x){
        if (x == null)
            return false;
        return true;
    }

    private boolean validatePostalCodeFormat(int vatNumber){
        String regex = "\\d{4}(-\\d{3})?";
        String vat = String.valueOf(vatNumber);
        if (vat != regex) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(postalCode, address.postalCode) && Objects.equals(local, address.local) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postalCode, local, city);
    }
}
