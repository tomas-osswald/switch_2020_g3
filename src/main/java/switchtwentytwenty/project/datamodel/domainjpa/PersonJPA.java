package switchtwentytwenty.project.datamodel.domainjpa;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<EmailAddressJPA> emails = new ArrayList<>();


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<PhoneNumberJPA> phones = new ArrayList<>();

    @Getter
    private int vat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressJPA address;

    @Getter
    private FamilyIDJPA familyid;

    public PersonJPA(PersonIDJPA id, String name, String birthdate, int vat, FamilyIDJPA familyid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonJPA personJPA = (PersonJPA) o;
        return vat == personJPA.vat && id.equals(personJPA.id) && name.equals(personJPA.name) && birthdate.equals(personJPA.birthdate) && familyid.equals(personJPA.familyid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthdate, emails, phones, vat, address, familyid);
    }
}