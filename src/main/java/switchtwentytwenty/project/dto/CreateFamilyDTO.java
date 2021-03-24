package switchtwentytwenty.project.dto;

public class CreateFamilyDTO {


    private String adminEmail;
    private String familyName;
    private String name;
    private String birtDate;
    private int vatNumber;
    private int phone;
    private String street;
    private String city;
    private int houseNumber;
    private String zipCode;
    private String ccNumber;

    public CreateFamilyDTO(String adminEmail, String familyName, String name, String birtDate, int vatNumber, int phone, String street, String city, int houseNumber, String zipCode, String ccNumber) {
        this.adminEmail = adminEmail;
        this.familyName = familyName;
        this.name = name;
        this.birtDate = birtDate;
        this.vatNumber = vatNumber;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.ccNumber = ccNumber;
    }

    public String unpackAdminEmail() {
        return this.adminEmail;
    }

    public String unpackFamilyName() {
        return this.familyName;
    }

    public String unpackName() {
        return this.name;
    }

    public String unpackBirthDate() {
        return this.birtDate;
    }

    public int unpackVAT() {
        return this.vatNumber;
    }

    public int unpackPhone() {
        return this.phone;
    }

    public String unpackStreet() {
        return this.street;
    }

    public String unpackCity() {
        return this.city;
    }

    public int unpackHouseNumber() {
        return this.houseNumber;
    }

    public String unpackZipCode() {
        return this.zipCode;
    }

    public String unpackCCNumber() {
        return this.ccNumber;
    }
}
