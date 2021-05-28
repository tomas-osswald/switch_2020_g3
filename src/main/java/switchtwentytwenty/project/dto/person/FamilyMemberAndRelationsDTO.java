package switchtwentytwenty.project.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import switchtwentytwenty.project.dto.family.OutputPersonRelationDTO;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FamilyMemberAndRelationsDTO extends RepresentationModel<FamilyMemberAndRelationsDTO> {

    private String name;
    private String personID;
    private List<OutputPersonRelationDTO> relations;
}
