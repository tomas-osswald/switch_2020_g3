package switchtwentytwenty.project.dto.assemblers.implassemblers;

import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;

public class AddFamilyAndSetAdminDTOAssembler {

    public static InputPersonDTO toInputPersonDTO(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        return new InputPersonDTO(addFamilyAndSetAdminDTO.getEmailID(), addFamilyAndSetAdminDTO.getName(), addFamilyAndSetAdminDTO.getBirthDate(), addFamilyAndSetAdminDTO.getVatNumber(), addFamilyAndSetAdminDTO.getPhone(), addFamilyAndSetAdminDTO.getStreet(), addFamilyAndSetAdminDTO.getCity(), addFamilyAndSetAdminDTO.getHouseNumber(), addFamilyAndSetAdminDTO.getZipCode());
    }

    public static InputFamilyDTO toInputFamilyDTO(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        return new InputFamilyDTO(addFamilyAndSetAdminDTO.getFamilyName(), addFamilyAndSetAdminDTO.getLocalDate());

    }
}
