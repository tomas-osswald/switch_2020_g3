package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Data
@NoArgsConstructor
@Entity
@Table(name = "emailAddresses")
public class EmailAddressJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    private String email;


    @ManyToOne()
    @JoinColumn(name = "person", nullable=true)
    //because it is in the same aggregate, a foreign key constraint is used
    private PersonJPA person;

    public EmailAddressJPA(String email, PersonJPA personJPA) {
        this.email = email;
        this.person = personJPA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddressJPA that = (EmailAddressJPA) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}