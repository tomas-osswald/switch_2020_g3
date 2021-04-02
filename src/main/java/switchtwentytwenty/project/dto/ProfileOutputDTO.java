package switchtwentytwenty.project.dto;

public class ProfileOutputDTO {

    private final String email;
    private final String name;
    private final String birthDate;
    private final Integer vatNumber;
    private final Integer phoneNumber;
    private final String street;
    private final String city;
    private final Integer addressNumber;
    private final String zipCode;


    public ProfileOutputDTO(String email, String name, String birthDate, Integer vatNumber, Integer phoneNumber, String street, String city, Integer addressNumber, String zipCode) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.vatNumber = vatNumber;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.addressNumber = addressNumber;
        this.zipCode = zipCode;
    }
}
