package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices.AddFamilyMemberService;
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
