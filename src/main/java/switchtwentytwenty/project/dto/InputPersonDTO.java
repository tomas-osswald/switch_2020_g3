package switchtwentytwenty.project.dto;

public class InputPersonDTO {

    private String userID;
    private String emailID;
    private String name;
    private String birtDate;
    private int vatNumber;
    private Integer phone;
    private String street;
    private String city;
    private String houseNumber;
    private String zipCode;


    public InputPersonDTO(String userID, String emailID, String name, String birtDate, int vatNumber, Integer phone, String street, String city, String houseNumber, String zipCode) {
        this.userID = userID;
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

    public String unpackUserID() {
        return this.userID;
    }

    public String unpackEmail() {
        return this.emailID;
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

    public Integer unpackPhone() {
        return this.phone;
    }

    public String unpackStreet() {
        return this.street;
    }

    public String unpackCity() {
        return this.city;
    }

    public String unpackHouseNumber() {
        return this.houseNumber;
    }

    public String unpackZipCode() {
        return this.zipCode;
    }


}

