package switchtwentytwenty.project.datamodel;


import lombok.Data;
import lombok.NoArgsConstructor;
import switchtwentytwenty.project.domain.valueobject.Address;

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

    public AddressJPA(Address address) {
        this.street = address.getStreet();
        this.city = address.getCity();
        this.zipCode = address.getZipCode();
        this.doorNumber = address.getDoorNumber();

    }


}
