package switchtwentytwenty.project.datamodel;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "address")
public class AddressJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String city;
    private String zipCode;
    private int doorNumber;


    @OneToOne()
    @JoinColumn(name = "person", nullable = false)
    //because it is in the same aggregate, a foreign key constraint is used
    private PersonJPA person;

    public AddressJPA(String street, String city, String zipCode, int doorNumber) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.doorNumber = doorNumber;
    }

}