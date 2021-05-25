package switchtwentytwenty.project.dto.relation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

@Getter
public class InputRelationDTO {

        private final CreateRelationDTO createRelationDTO;
        private final String familyID;

    public InputRelationDTO(CreateRelationDTO createRelationDTO, String familyID) {
        this.createRelationDTO = createRelationDTO;
        this.familyID = familyID;
    }
}