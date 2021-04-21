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
    private PersonJPA person;

    public AddressJPA(String street, String city, String zipCode, int doorNumber, PersonJPA personJPA) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.doorNumber = doorNumber;
        this.person = personJPA;
    }

}
