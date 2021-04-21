package switchtwentytwenty.project.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

@Entity
@Table(name = "emailAddresses")
public class EmailAddressJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;


    @ManyToOne()
    @JoinColumn(name = "person", nullable=false)
    //because it is in the same aggregate, a foreign key constraint is used
    private PersonJPA person;

    public EmailAddressJPA(String email) {
        this.email =email;

    }
}