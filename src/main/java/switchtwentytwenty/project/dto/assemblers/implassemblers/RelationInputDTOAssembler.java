package switchtwentytwenty.project.dto.assemblers.implassemblers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.relation.CreateRelationDTO;
import switchtwentytwenty.project.dto.relation.InputRelationDTO;


@Component
@NoArgsConstructor
public class RelationInputDTOAssembler  {

    public InputRelationDTO toInputRelationDTO(CreateRelationDTO createRelationDTO, String familyID) {
        return new InputRelationDTO(createRelationDTO, familyID );
    }

}