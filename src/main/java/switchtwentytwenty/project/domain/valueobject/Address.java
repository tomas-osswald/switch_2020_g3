package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class Address implements ValueObject {

    private Street street;
    private City city;
    private ZipCode zipCode;
    private DoorNumber number;

    public Address(String street, String city, String zipCode, int number) {
        this.street = new Street(street);
        this.city = new City(city);
        this.zipCode = new ZipCode(zipCode);
        this.number = new DoorNumber(number);

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

    @Override
    public String toString() {
        return "Address{" +
                "street=" + street.toString() +
                ", city=" + city.toString() +
                ", zipCode=" + zipCode.toString() +
                ", number=" + number +
                '}';
    }
}
