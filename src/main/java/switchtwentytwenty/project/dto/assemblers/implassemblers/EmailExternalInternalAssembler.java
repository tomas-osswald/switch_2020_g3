package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.dto.ExternalEmailDTO;
import switchtwentytwenty.project.dto.InternalEmailDTO;
import switchtwentytwenty.project.dto.OutputEmailDTO;

@Component
public class EmailExternalInternalAssembler {

    /**
     * This method receives an External DTO and converts it to an Internal DTO.
     * @param addEmailDTO
     * @return InternalEmailDTO (Contains info required to add an Email to an already existing person)
     */
    public InternalEmailDTO toInternal (AddEmailDTO addEmailDTO) { return null;
    }



}
