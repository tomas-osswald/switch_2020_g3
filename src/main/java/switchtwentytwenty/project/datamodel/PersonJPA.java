package switchtwentytwenty.project.datamodel;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.PersonIDJPA;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "persons")
public class PersonJPA {
    @Id
    private PersonIDJPA id;

    @Getter
    private String name;
    @Getter
    private String birthdate;
/*
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<EmailAddressJPA> emails;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<PhoneNumberJPA> phones;*/

    @Getter
    private int vat;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressJPA address;

    @Getter
    private FamilyIDJPA familyid;

    public PersonJPA(PersonIDJPA id, String name, String birthdate, List<EmailAddressJPA> emails, int vat, List<PhoneNumberJPA> phones, AddressJPA address, FamilyIDJPA familyid) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        //this.emails = emails;
        this.vat = vat;
        //this.phones = phones;
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
