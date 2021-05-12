package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.person.*;

@Component
public class PersonInputDTOAssembler {

    public InputAddFamilyMemberDTO toInputAddFamilyMemberDTO(AddFamilyMemberDTO addFamilyMemberDTO) {

        InputAddFamilyMemberDTO internalAddFamilyMemberDTO = new InputAddFamilyMemberDTO();
        internalAddFamilyMemberDTO.setAdminID(addFamilyMemberDTO.getAdminID());
        internalAddFamilyMemberDTO.setEmailID(addFamilyMemberDTO.getEmailID());
        internalAddFamilyMemberDTO.setName(addFamilyMemberDTO.getName());
        internalAddFamilyMemberDTO.setBirtDate(addFamilyMemberDTO.getBirthDate());
        internalAddFamilyMemberDTO.setVatNumber(addFamilyMemberDTO.getVatNumber());
        internalAddFamilyMemberDTO.setPhone(addFamilyMemberDTO.getPhone());
        internalAddFamilyMemberDTO.setStreet(addFamilyMemberDTO.getStreet());
        internalAddFamilyMemberDTO.setCity(addFamilyMemberDTO.getCity());
        internalAddFamilyMemberDTO.setHouseNumber(addFamilyMemberDTO.getHouseNumber());
        internalAddFamilyMemberDTO.setZipCode(addFamilyMemberDTO.getZipCode());

        return internalAddFamilyMemberDTO;
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
    public InputEmailDTO toInputEmailDTO(AddEmailDTO addEmailDTO) {
        InputEmailDTO inputEmailDTO = new InputEmailDTO();

        inputEmailDTO.setEmail(addEmailDTO.unpackEmail());
        inputEmailDTO.setId(addEmailDTO.unpackUserID());

        return inputEmailDTO;
    }

    public InputPersonDTO toInputPersonDTO(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        return new InputPersonDTO(addFamilyAndSetAdminDTO.getEmailID(), addFamilyAndSetAdminDTO.getName(), addFamilyAndSetAdminDTO.getBirthDate(), addFamilyAndSetAdminDTO.getVatNumber(), addFamilyAndSetAdminDTO.getPhone(), addFamilyAndSetAdminDTO.getStreet(), addFamilyAndSetAdminDTO.getCity(), addFamilyAndSetAdminDTO.getHouseNumber(), addFamilyAndSetAdminDTO.getZipCode());
    }

}