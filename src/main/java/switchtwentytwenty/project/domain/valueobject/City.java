package switchtwentytwenty.project.domain.valueobject;

import lombok.ToString;
import switchtwentytwenty.project.exceptions.InvalidCityException;

import java.util.Objects;

@ToString
public class City implements ValueObject {


    String INVALIDCITY = "Invalid City Name";
    private String city;

    public City(String city) {
        this.city = city;
        validateData();
    }

    @Override
    public String toString() {
        return this.city;
    }

    private void validateData() {
        checkCity();
    }

    private void checkCity() {
        if (!validateCity()) {
            throw new InvalidCityException(INVALIDCITY);
        }
    }

    // Verificar com lógica de negócio
    private boolean validateCity() {
        return city != null && city.trim().length() != 0 && !city.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}