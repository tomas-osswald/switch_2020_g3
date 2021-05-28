package switchtwentytwenty.project.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import switchtwentytwenty.project.dto.family.OutputPersonRelationDTO;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FamilyMemberAndRelationsDTO {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FamilyMemberAndRelationsDTO that = (FamilyMemberAndRelationsDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(personID, that.personID) && Objects.equals(relations, that.relations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, personID, relations);
    }

    private String name;
    private String personID;
    private List<OutputPersonRelationDTO> relations;
}
