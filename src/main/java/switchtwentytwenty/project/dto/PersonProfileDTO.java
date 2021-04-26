package switchtwentytwenty.project.dto;

import java.util.List;
import java.util.Objects;

public class PersonProfileDTO {
    @Deprecated
    public PersonProfileDTO(){

    }
    public PersonProfileDTO(String id, String name, String birthdate, List<String> emails, List<String> phoneNumbers, String vat, String address, String familyID) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.emails = emails;
        this.phoneNumbers = phoneNumbers;
        this.vat = vat;
        this.address = address;
        this.familyID = familyID;
    }

    private String id;
    private String name;
    private String birthdate;
    private List<String> emails;
    private List<String> phoneNumbers;
    private String vat;
    private String address;
    private String familyID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonProfileDTO that = (PersonProfileDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(birthdate, that.birthdate) && Objects.equals(emails, that.emails) && Objects.equals(phoneNumbers, that.phoneNumbers) && Objects.equals(vat, that.vat) && Objects.equals(address, that.address) && Objects.equals(familyID, that.familyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthdate, emails, phoneNumbers, vat, address, familyID);
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

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamilyID() {
        return familyID;
    }

    public void setFamilyID(String familyID) {
        this.familyID = familyID;
    }
}
