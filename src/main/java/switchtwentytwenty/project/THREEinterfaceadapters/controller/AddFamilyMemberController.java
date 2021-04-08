package switchtwentytwenty.project.THREEinterfaceadapters.controller;

import switchtwentytwenty.project.TWOusecaseservices.applicationservices.AddFamilyMemberService;
import switchtwentytwenty.project.dto.AddPersonDTO;

public class AddFamilyMemberController {




    public boolean addFamilyMember(AddPersonDTO addPersonDTO) {
        boolean result;
        AddFamilyMemberService addPersonService = new AddFamilyMemberService();
        try {
            addPersonService.addPerson(addPersonDTO);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
