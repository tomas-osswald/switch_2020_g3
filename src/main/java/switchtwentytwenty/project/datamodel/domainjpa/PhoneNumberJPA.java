package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumberJPA {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    private int number;

    @Getter
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
        return id == that.id && number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,number);
    }
}
