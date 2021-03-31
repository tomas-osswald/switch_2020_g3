package switchtwentytwenty.project.dto;

public class AddPersonDTO {

    private String email;
    private String name;
    private String birtDate;
    private int vatNumber;
    private Integer phone;
    private String street;
    private String city;
    private int houseNumber;
    private String zipCode;


    public AddPersonDTO(String email, String name, String birtDate, int vatNumber, Integer phone, String street, String city, int houseNumber, String zipCode) {
        this.email = email;
        this.name = name;
        this.birtDate = birtDate;
        this.vatNumber = vatNumber;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;

    }

    public String unpackEmail() {
        return this.email;
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

    public int unpackHouseNumber() {
        return this.houseNumber;
    }

    public String unpackZipCode() {
        return this.zipCode;
    }

}
