package switchtwentytwenty.project.dto.family;

import java.util.Objects;


public class AddFamilyMemberDTO {

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

    public AddFamilyMemberDTO(String adminID, String emailID, String name,String birtDate, int vatNumber, Integer phone, String street,  String city, String houseNumber, String zipCode  ){
    }

    public String getAdminID() {
        return adminID;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getName() {
        return name;
    }

    public String getBirtDate() {
        return birtDate;
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
        if (!(o instanceof AddFamilyMemberDTO)) return false;
        AddFamilyMemberDTO that = (AddFamilyMemberDTO) o;
        return vatNumber == that.vatNumber && Objects.equals(adminID, that.adminID) && Objects.equals(emailID, that.emailID) && Objects.equals(name, that.name) && Objects.equals(birtDate, that.birtDate) && Objects.equals(phone, that.phone) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID, emailID, name, birtDate, vatNumber, phone, street, city, houseNumber, zipCode);
    }
}