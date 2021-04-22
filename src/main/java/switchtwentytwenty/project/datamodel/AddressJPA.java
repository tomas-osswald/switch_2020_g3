package switchtwentytwenty.project.datamodel;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "address")
public class AddressJPA {

    /**
     * Por não existir nenhum atributo que possa ser usados como ID. Definiu-se atributo chave id (do tipo long)
     * com a anotação @GeneratedValue
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String city;
    private String zipCode;
    private String doorNumber;


    @OneToOne()
    @JoinColumn(name = "person", nullable = false)
    //because it is in the same aggregate, a foreign key constraint is used
    private PersonJPA person;

    public AddressJPA(String street, String city, String zipCode, String doorNumber, PersonJPA personjpa) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.doorNumber = doorNumber;
        this.person = personjpa;
    }

}