package switchtwentytwenty.project.dto.family;

import switchtwentytwenty.project.dto.person.IinputPersonDTO;

import java.util.Objects;

public class InternalAddFamilyMemberDTO implements IinputPersonDTO {

    private String adminID;
    private String emailID;
    private String name;
    private String birtDate;
    private int vatNumber;
    private Integer phone;
    private String street;
    private String city;
    private String houseNumber;
    private String zipCode;


    public InternalAddFamilyMemberDTO(String adminID, String emailID, String name, String birtDate, int vatNumber, Integer phone, String street, String city, String houseNumber, String zipCode) {
        this.adminID = adminID;
        this.emailID = emailID;
        this.name = name;
        this.birtDate = birtDate;
        this.vatNumber = vatNumber;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }


    public InternalAddFamilyMemberDTO(){

    }

    public String getAdminID() {
        return adminID;
    }

    public String unpackEmail() {
        return emailID;
    }

    public String unpackName() {
        return name;
    }

    public String unpackBirthDate() {
        return birtDate;
    }

    public int unpackVAT() {
        return vatNumber;
    }

    public Integer unpackPhone() {
        return phone;
    }

    public String unpackStreet() {
        return street;
    }

    public String unpackCity() {
        return city;
    }

    public String unpackHouseNumber() {
        return houseNumber;
    }

    public String unpackZipCode() {
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

    public void setBirtDate(String birtDate) {
        this.birtDate = birtDate;
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
        if (!(o instanceof InternalAddFamilyMemberDTO)) return false;
        InternalAddFamilyMemberDTO that = (InternalAddFamilyMemberDTO) o;
        return unpackVAT() == that.unpackVAT() && Objects.equals(getAdminID(), that.getAdminID()) && Objects.equals(unpackEmail(), that.unpackEmail()) && Objects.equals(unpackName(), that.unpackName()) && Objects.equals(unpackBirthDate(), that.unpackBirthDate()) && Objects.equals(unpackPhone(), that.unpackPhone()) && Objects.equals(unpackStreet(), that.unpackStreet()) && Objects.equals(unpackCity(), that.unpackCity()) && Objects.equals(unpackHouseNumber(), that.unpackHouseNumber()) && Objects.equals(unpackZipCode(), that.unpackZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdminID(), unpackEmail(), unpackName(), unpackBirthDate(), unpackVAT(), unpackPhone(), unpackStreet(), unpackCity(), unpackHouseNumber(), unpackZipCode());
    }
}