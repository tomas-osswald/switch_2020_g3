package switchtwentytwenty.project.dto.person;

import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class OutputPersonDTO extends RepresentationModel<OutputPersonDTO> {

    private String id;
    private String name;
    private String birthdate;
    private List<String> emails;
    private List<Integer> phoneNumbers;
    private String vat;
    private String street;
    private String city;
    private String zipCode;
    private String doorNumber;
    private String familyID;

    public OutputPersonDTO(String id, String name, String birthdate, List<String> emails, List<Integer> phoneNumbers, String vat, String street, String city, String zipCode, String doorNumber, String familyID) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.emails = emails;
        this.phoneNumbers = phoneNumbers;
        this.vat = vat;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.doorNumber = doorNumber;
        this.familyID = familyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputPersonDTO that = (OutputPersonDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(birthdate, that.birthdate) && Objects.equals(emails, that.emails) && Objects.equals(phoneNumbers, that.phoneNumbers) && Objects.equals(vat, that.vat) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && Objects.equals(doorNumber, that.doorNumber) && Objects.equals(familyID, that.familyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthdate, emails, phoneNumbers, vat, street, city, zipCode, doorNumber, familyID);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<Integer> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Integer> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getFamilyID() {
        return familyID;
    }

    public void setFamilyID(String familyID) {
        this.familyID = familyID;
    }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getDoorNumber() { return doorNumber; }

    public void setDoorNumber(String doorNumber) { this.doorNumber = doorNumber; }
}