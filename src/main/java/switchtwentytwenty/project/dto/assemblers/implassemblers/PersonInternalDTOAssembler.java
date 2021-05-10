package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.InternalGetProfileDTO;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.family.InternalAddFamilyMemberDTO;

@Component
public class PersonInternalDTOAssembler {

    public InternalAddFamilyMemberDTO toInternalAddFamilyMemberDTO(AddFamilyMemberDTO AddFamilyMemberDTO) {

        InternalAddFamilyMemberDTO InternalAddFamilyMemberDTO = new InternalAddFamilyMemberDTO();

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

    public InternalGetProfileDTO toInternalGetProfileDTO(String personID){
        InternalGetProfileDTO internalGetProfileDTO = new InternalGetProfileDTO();
        internalGetProfileDTO.setId(personID);
        return internalGetProfileDTO;
    }

}