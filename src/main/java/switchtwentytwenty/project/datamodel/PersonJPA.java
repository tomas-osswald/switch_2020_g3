package switchtwentytwenty.project.datamodel;


import lombok.Data;
import lombok.NoArgsConstructor;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.PersonID;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "persons")
public class PersonJPA {
    @Id
    @Embedded
    private PersonID id;

    private String name;
    private String birthdate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<EmailAddressJPA> emails;

    private String vat;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<PhoneNumberJPA> phones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressJPA address;


    private FamilyID familyid;

    public PersonJPA(PersonID id, String name, String birthdate, List<EmailAddressJPA> emails, String vat, List<PhoneNumberJPA> phones, AddressJPA address, FamilyID familyid) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.emails = emails;
        this.vat = vat;
        this.phones = phones;
        this.address = address;
        this.familyid = familyid;
    }

    @Override
    public String toString() {
        return "PersonJPA{" +
                "id=" + id +
                '}';
    }
}
