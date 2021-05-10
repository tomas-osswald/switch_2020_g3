package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.person.*;

@Component
public class PersonInputDTOAssembler {

    public InputAddFamilyMemberDTO toInternalAddFamilyMemberDTO(AddFamilyMemberDTO AddFamilyMemberDTO) {

        InputAddFamilyMemberDTO InternalAddFamilyMemberDTO = new InputAddFamilyMemberDTO();

        InternalAddFamilyMemberDTO.setAdminID(AddFamilyMemberDTO.getAdminID());
        InternalAddFamilyMemberDTO.setEmailID(AddFamilyMemberDTO.getEmailID());
        InternalAddFamilyMemberDTO.setName(AddFamilyMemberDTO.getName());
        InternalAddFamilyMemberDTO.setBirtDate(AddFamilyMemberDTO.getBirthDate());
        InternalAddFamilyMemberDTO.setVatNumber(AddFamilyMemberDTO.getVatNumber());
        InternalAddFamilyMemberDTO.setPhone(AddFamilyMemberDTO.getPhone());
        InternalAddFamilyMemberDTO.setStreet(AddFamilyMemberDTO.getStreet());
        InternalAddFamilyMemberDTO.setCity(AddFamilyMemberDTO.getCity());
        InternalAddFamilyMemberDTO.setHouseNumber(AddFamilyMemberDTO.getHouseNumber());
        InternalAddFamilyMemberDTO.setZipCode(AddFamilyMemberDTO.getZipCode());

        return InternalAddFamilyMemberDTO;
    }

    public InputGetProfileDTO toInternalGetProfileDTO(String personID){
        InputGetProfileDTO internalGetProfileDTO = new InputGetProfileDTO();
        internalGetProfileDTO.setId(personID);
        return internalGetProfileDTO;
    }

    /**
     * This method receives an External DTO and converts it to an Internal DTO.
     * @param addEmailDTO
     * @return InternalEmailDTO (Contains info required to add an Email to an already existing person)
     */
    public InputEmailDTO toInternal (AddEmailDTO addEmailDTO) { return null;
    }

    public InputPersonDTO toInputPersonDTO(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        return new InputPersonDTO(addFamilyAndSetAdminDTO.getEmailID(), addFamilyAndSetAdminDTO.getName(), addFamilyAndSetAdminDTO.getBirthDate(), addFamilyAndSetAdminDTO.getVatNumber(), addFamilyAndSetAdminDTO.getPhone(), addFamilyAndSetAdminDTO.getStreet(), addFamilyAndSetAdminDTO.getCity(), addFamilyAndSetAdminDTO.getHouseNumber(), addFamilyAndSetAdminDTO.getZipCode());
    }

}