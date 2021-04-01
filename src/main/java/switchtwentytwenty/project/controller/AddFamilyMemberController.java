package switchtwentytwenty.project.controller;

import switchtwentytwenty.project.dataaccesslayer.AddFamilyMemberService;
import switchtwentytwenty.project.dataaccesslayer.Application;
import switchtwentytwenty.project.dto.AddPersonDTO;

public class AddFamilyMemberController {

    private Application application;

    public AddFamilyMemberController(Application application) {
        this.application = application;
    }

    public boolean addFamilyMember(AddPersonDTO addPersonDTO) {
        boolean result;
        AddFamilyMemberService addPersonService = new AddFamilyMemberService(application);
        try {
            addPersonService.addPerson(addPersonDTO);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
