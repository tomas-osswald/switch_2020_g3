package switchtwentytwenty.project.dto.assemblers.implassemblers;

import switchtwentytwenty.project.dto.family.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;

public class FamilyMemberExternalInternalAssembler {

    public InternalFamilyMemberDTO toInner(AddFamilyMemberDTO AddFamilyMemberDTO) {

        InternalFamilyMemberDTO internalFamilyMemberDTO = new InternalFamilyMemberDTO();

        internalFamilyMemberDTO.setAdminID(AddFamilyMemberDTO.getAdminID());
        internalFamilyMemberDTO.setEmailID(AddFamilyMemberDTO.getEmailID());
        internalFamilyMemberDTO.setName(AddFamilyMemberDTO.getName());
        internalFamilyMemberDTO.setBirtDate(AddFamilyMemberDTO.getBirtDate());
        internalFamilyMemberDTO.setVatNumber(AddFamilyMemberDTO.getVatNumber());
        internalFamilyMemberDTO.setPhone(AddFamilyMemberDTO.getPhone());
        internalFamilyMemberDTO.setStreet(AddFamilyMemberDTO.getStreet());
        internalFamilyMemberDTO.setCity(AddFamilyMemberDTO.getCity());
        internalFamilyMemberDTO.setHouseNumber(AddFamilyMemberDTO.getHouseNumber());
        internalFamilyMemberDTO.setZipCode(AddFamilyMemberDTO.getZipCode());

        return internalFamilyMemberDTO;
    }

}