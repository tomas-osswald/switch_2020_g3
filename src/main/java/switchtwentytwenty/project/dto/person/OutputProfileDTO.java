package switchtwentytwenty.project.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
public class OutputProfileDTO {

    private String email;
    private String name;
    private String birthDate;
    private Integer vatNumber;
    private Integer phoneNumber;
    private String street;
    private String city;
    private String addressNumber;
    private String zipCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputProfileDTO that = (OutputProfileDTO) o;
        return Objects.equals(email, that.email) && Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate) && Objects.equals(vatNumber, that.vatNumber) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(addressNumber, that.addressNumber) && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, birthDate, vatNumber, phoneNumber, street, city, addressNumber, zipCode);
    }

}
