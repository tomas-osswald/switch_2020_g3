package switchtwentytwenty.project.dto.family;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InputRelationDTO {

    private String personIDOne;
    private String personIDTwo;
    private String designation;
    private String familyID;

    public InputRelationDTO(CreateRelationDTO createRelationDTO, String familyID) {
        this.personIDOne = createRelationDTO.getMemberOneID();
        this.personIDTwo = createRelationDTO.getMemberTwoID();
        this.designation = createRelationDTO.getRelationDesignation();
        this.familyID = familyID;
    }
}

