package switchtwentytwenty.project.datamodel;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumberJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;

    @ManyToOne()
    @JoinColumn(name = "person", nullable = true)
    private PersonJPA person;

    public PhoneNumberJPA(int number, PersonJPA person) {
        this.number = number;
        this.person = person;
    }
}
