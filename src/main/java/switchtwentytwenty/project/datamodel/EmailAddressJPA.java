package switchtwentytwenty.project.datamodel;

import lombok.Data;
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
    @JoinColumn(name = "person")
    private PersonJPA person;

    public EmailAddressJPA(String email) {
        this.email = email;


    }
}