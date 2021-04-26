package switchtwentytwenty.project.datamodel.assemblerjpa;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@ToString
@NoArgsConstructor
@Embeddable
public class FamilyIDJPA implements Serializable {
    @Getter
    @Setter
    private String familyID;

    public FamilyIDJPA(String familyID) {
        this.familyID = familyID;
    }

    public FamilyIDJPA(UUID familyID) {
        this.familyID = familyID.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyIDJPA that = (FamilyIDJPA) o;
        return familyID.equals(that.familyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyID);
    }

    @Override
    public String toString() {
        return this.familyID;
    }
}