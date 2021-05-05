package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.dto.ExternalEmailDTO;
import switchtwentytwenty.project.dto.InternalEmailDTO;
import switchtwentytwenty.project.dto.OutputEmailDTO;

@Component
public class EmailExternalInternalAssembler {

    //TODO: 04/05/2021 Target para Timmys
    public InternalEmailDTO toInternal (AddEmailDTO addEmailDTO) { return null;
    }

    public ExternalEmailDTO toExternal (OutputEmailDTO outputEmailDTO) {
        String outputEmail = outputEmailDTO.getEmail();
        String emailID = outputEmailDTO.getEmailID();
        ExternalEmailDTO externalEmailDTO = new ExternalEmailDTO(outputEmail, emailID);
        return externalEmailDTO;
    }


}
