package switchtwentytwenty.project.dto.assemblers.implassemblers;

import switchtwentytwenty.project.dto.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;

public class AddFamilyOutInAssembler {

    public InternalFamilyMemberDTO toIn (AddFamilyMemberDTO AddFamilyMemberDTO) {

        InternalFamilyMemberDTO InternalFamilyMemberDTO = new InternalFamilyMemberDTO();

        InternalFamilyMemberDTO.setAdminID(AddFamilyMemberDTO.getAdminID());
        InternalFamilyMemberDTO.setEmailID(AddFamilyMemberDTO.getEmailID());
        InternalFamilyMemberDTO.setName(AddFamilyMemberDTO.getName());
        InternalFamilyMemberDTO.setBirtDate(AddFamilyMemberDTO.getBirtDate());
        InternalFamilyMemberDTO.setVatNumber(AddFamilyMemberDTO.getVatNumber());
        InternalFamilyMemberDTO.setPhone(AddFamilyMemberDTO.getPhone());
        InternalFamilyMemberDTO.setStreet(AddFamilyMemberDTO.getStreet());
        InternalFamilyMemberDTO.setCity(AddFamilyMemberDTO.getCity());
        InternalFamilyMemberDTO.setHouseNumber(AddFamilyMemberDTO.getHouseNumber());
        InternalFamilyMemberDTO.setZipCode(AddFamilyMemberDTO.getZipCode());

        return InternalFamilyMemberDTO;
    }

}