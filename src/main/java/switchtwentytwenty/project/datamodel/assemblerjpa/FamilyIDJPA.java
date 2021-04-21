package switchtwentytwenty.project.datamodel.assemblerjpa;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@ToString
@EqualsAndHashCode
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


}