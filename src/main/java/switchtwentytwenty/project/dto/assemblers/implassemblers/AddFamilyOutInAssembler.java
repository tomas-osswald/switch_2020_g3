package switchtwentytwenty.project.dto.assemblers.implassemblers;

import switchtwentytwenty.project.dto.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.family.InAddFamilyMemberDTO;

public class AddFamilyOutInAssembler {

    public InAddFamilyMemberDTO toIn (AddFamilyMemberDTO AddFamilyMemberDTO) {

        InAddFamilyMemberDTO InAddFamilyMemberDTO = new InAddFamilyMemberDTO();

        InAddFamilyMemberDTO.setAdminID(AddFamilyMemberDTO.getAdminID());
        InAddFamilyMemberDTO.setEmailID(AddFamilyMemberDTO.getEmailID());
        InAddFamilyMemberDTO.setName(AddFamilyMemberDTO.getName());
        InAddFamilyMemberDTO.setBirtDate(AddFamilyMemberDTO.getBirtDate());
        InAddFamilyMemberDTO.setVatNumber(AddFamilyMemberDTO.getVatNumber());
        InAddFamilyMemberDTO.setPhone(AddFamilyMemberDTO.getPhone());
        InAddFamilyMemberDTO.setStreet(AddFamilyMemberDTO.getStreet());
        InAddFamilyMemberDTO.setCity(AddFamilyMemberDTO.getCity());
        InAddFamilyMemberDTO.setHouseNumber(AddFamilyMemberDTO.getHouseNumber());
        InAddFamilyMemberDTO.setZipCode(AddFamilyMemberDTO.getZipCode());

        return InAddFamilyMemberDTO;
    }


}