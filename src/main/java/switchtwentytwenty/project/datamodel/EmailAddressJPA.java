package switchtwentytwenty.project.datamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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

}