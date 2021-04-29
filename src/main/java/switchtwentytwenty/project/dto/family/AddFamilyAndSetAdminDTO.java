package switchtwentytwenty.project.dto.family;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class AddFamilyAndSetAdminDTO  {

    private String emailID;
    private String name;
    private String birthDate;
    private int vatNumber;
    private Integer phone;
    private String street;
    private String city;
    private String houseNumber;
    private String zipCode;

    private String familyName;
    private String localDate;

    public String getEmailID() {
        return emailID;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getLocalDate() {
        return localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddFamilyAndSetAdminDTO that = (AddFamilyAndSetAdminDTO) o;
        return vatNumber == that.vatNumber && emailID.equals(that.emailID) && name.equals(that.name) && birthDate.equals(that.birthDate) && Objects.equals(phone, that.phone) && street.equals(that.street) && city.equals(that.city) && houseNumber.equals(that.houseNumber) && zipCode.equals(that.zipCode) && familyName.equals(that.familyName) && Objects.equals(localDate, that.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailID, name, birthDate, vatNumber, phone, street, city, houseNumber, zipCode, familyName, localDate);
    }
}