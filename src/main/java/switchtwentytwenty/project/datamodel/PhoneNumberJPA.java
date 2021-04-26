package switchtwentytwenty.project.datamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

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

    public PhoneNumberJPA(int number, PersonJPA personJPA) {
        this.number = number;

        this.person = personJPA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumberJPA that = (PhoneNumberJPA) o;
        return id == that.id && number == that.number && person.equals(that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, person);
    }
}
