package switchtwentytwenty.project.dto.person;

import java.util.Objects;

public class InputPersonDTO implements IInputPersonDTO {

    private String emailID;
    private String name;
    private String birthDate;
    private int vatNumber;
    private Integer phone;
    private String street;
    private String city;
    private String houseNumber;
    private String zipCode;


    //TODO: Retirar o userID deste DTO.
    // Partimos do pressuposto que quem está a usar esta funcionalidade tem autenticação efetuada corretamente.
    // O userID vem na mesma no megaDTO externo mas é extraído à parte para obter a family e este não fica "poluído"(João Pinto).
    //TODO: retirar ID do admin pq não devemos "poluir" com informação que não é necessária para a criação de uma Person (aqui tivemos o nosso momento GRETA)

    public InputPersonDTO(String emailID, String name, String birthDate, int vatNumber, Integer phone, String street, String city, String houseNumber, String zipCode) {

        this.emailID = emailID;
        this.name = name;
        this.birthDate = birthDate;
        this.vatNumber = vatNumber;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;

    }

    public String unpackEmail() {
        return this.emailID;
    }

    public String unpackName() {
        return this.name;
    }

    public String unpackBirthDate() {
        return this.birthDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputPersonDTO that = (InputPersonDTO) o;
        return vatNumber == that.vatNumber && emailID.equals(that.emailID) && name.equals(that.name) && birthDate.equals(that.birthDate) && Objects.equals(phone, that.phone) && street.equals(that.street) && city.equals(that.city) && houseNumber.equals(that.houseNumber) && zipCode.equals(that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailID, name, birthDate, vatNumber, phone, street, city, houseNumber, zipCode);
    }
}