package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.exceptions.InvalidStreetException;

import java.util.Objects;

public class Street implements ValueObject {

    private String street;


    public Street(String street) {
        this.street = street;
        validateData();
    }

    private void validateData() {
        checkStreet();
    }


    private void checkStreet() {
        String INVALIDSTREET = "Invalid Street Name";
        if (!validateStreet()) {
            throw new InvalidStreetException(INVALIDSTREET);
        }
    }

    // Verificar com lógica de negócio
    private boolean validateStreet() {
        return street != null && street.trim().length() != 0 && !street.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street1 = (Street) o;
        return Objects.equals(street, street1.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street);
    }

    @Override
    public String toString() {
        return this.street;
    }
}
