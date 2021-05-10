package switchtwentytwenty.project.dto.family;

import java.util.Objects;

public class InternalAddFamilyMemberDTO {

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
        if (!(o instanceof InternalAddFamilyMemberDTO)) return false;
        InternalAddFamilyMemberDTO that = (InternalAddFamilyMemberDTO) o;
        return getVatNumber() == that.getVatNumber() && Objects.equals(getAdminID(), that.getAdminID()) && Objects.equals(getEmailID(), that.getEmailID()) && Objects.equals(getName(), that.getName()) && Objects.equals(getBirtDate(), that.getBirtDate()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getHouseNumber(), that.getHouseNumber()) && Objects.equals(getZipCode(), that.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdminID(), getEmailID(), getName(), getBirtDate(), getVatNumber(), getPhone(), getStreet(), getCity(), getHouseNumber(), getZipCode());
    }
}