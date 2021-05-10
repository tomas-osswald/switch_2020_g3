package switchtwentytwenty.project.dto.person;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class AddFamilyMemberDTO {

    private String adminID;
    private String emailID;
    private String name;
    private String birthDate;
    private int vatNumber;
    private Integer phone;
    private String street;
    private String city;
    private String houseNumber;
    private String zipCode;

    //TODO: Duplication resolve-se com @Setters e Getters

    public String getAdminID() {
        return adminID;
    }

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

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddFamilyMemberDTO)) return false;
        AddFamilyMemberDTO that = (AddFamilyMemberDTO) o;
        return vatNumber == that.vatNumber && Objects.equals(adminID, that.adminID) && Objects.equals(emailID, that.emailID) && Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate) && Objects.equals(phone, that.phone) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID, emailID, name, birthDate, vatNumber, phone, street, city, houseNumber, zipCode);
    }
}