package switchtwentytwenty.project.dto.assemblers.implassemblers;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;

@Component
@NoArgsConstructor
public class FamilyInputDTOAssembler {

    // Tirei os statics e meti como component, João Pinto

    public InputFamilyDTO toInputFamilyDTO(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        return new InputFamilyDTO(addFamilyAndSetAdminDTO.getFamilyName(), addFamilyAndSetAdminDTO.getLocalDate());

    }
}
