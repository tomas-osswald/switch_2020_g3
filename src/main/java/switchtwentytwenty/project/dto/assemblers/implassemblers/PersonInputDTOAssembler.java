package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.person.*;

@Component
public class PersonInputDTOAssembler {

    public InputAddFamilyMemberDTO toInputAddFamilyMemberDTO(AddFamilyMemberDTO AddFamilyMemberDTO) {

        InputAddFamilyMemberDTO internalAddFamilyMemberDTO = new InputAddFamilyMemberDTO();

        internalAddFamilyMemberDTO.setAdminID(AddFamilyMemberDTO.getAdminID());
        internalAddFamilyMemberDTO.setEmailID(AddFamilyMemberDTO.getEmailID());
        internalAddFamilyMemberDTO.setName(AddFamilyMemberDTO.getName());
        internalAddFamilyMemberDTO.setBirtDate(AddFamilyMemberDTO.getBirthDate());
        internalAddFamilyMemberDTO.setVatNumber(AddFamilyMemberDTO.getVatNumber());
        internalAddFamilyMemberDTO.setPhone(AddFamilyMemberDTO.getPhone());
        internalAddFamilyMemberDTO.setStreet(AddFamilyMemberDTO.getStreet());
        internalAddFamilyMemberDTO.setCity(AddFamilyMemberDTO.getCity());
        internalAddFamilyMemberDTO.setHouseNumber(AddFamilyMemberDTO.getHouseNumber());
        internalAddFamilyMemberDTO.setZipCode(AddFamilyMemberDTO.getZipCode());

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