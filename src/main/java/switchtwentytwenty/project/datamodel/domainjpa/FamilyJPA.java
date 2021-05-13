package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "families")
public class FamilyJPA {

    @Getter
    @Id
    private FamilyIDJPA id;
    @Getter
    private String familyName;
    @Getter
    private String registrationDate;
    @Getter
    private PersonIDJPA adminID;

    public FamilyJPA(FamilyIDJPA id, String familyName, String registrationDate, PersonIDJPA adminID) {
        this.id = id;
        this.familyName = familyName;
        this.registrationDate = registrationDate;
        this.adminID = adminID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyJPA familyJPA = (FamilyJPA) o;
        return Objects.equals(id, familyJPA.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
