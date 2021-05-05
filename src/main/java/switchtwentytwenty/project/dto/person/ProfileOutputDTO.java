package switchtwentytwenty.project.dto.person;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class ProfileOutputDTO {
    //TODO should class' name be refactored so the Output is the first part of the class name?

    private String email;
    private String name;
    private String birthDate;
    private Integer vatNumber;
    private Integer phoneNumber;
    private String street;
    private String city;
    private String addressNumber;
    private String zipCode;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(Integer vatNumber) {
        this.vatNumber = vatNumber;
    }


    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileOutputDTO that = (ProfileOutputDTO) o;
        return Objects.equals(email, that.email) && Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate) && Objects.equals(vatNumber, that.vatNumber) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(addressNumber, that.addressNumber) && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, birthDate, vatNumber, phoneNumber, street, city, addressNumber, zipCode);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
