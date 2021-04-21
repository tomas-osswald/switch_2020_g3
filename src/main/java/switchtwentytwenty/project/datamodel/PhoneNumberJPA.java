package switchtwentytwenty.project.datamodel;

import lombok.Data;
import lombok.Getter;
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

    @Getter
    private int number;

    @ManyToOne()
    @JoinColumn(name = "person")
    private PersonJPA person;

    public PhoneNumberJPA(int number) {
        this.number = number;

    }
}
