package switchtwentytwenty.project.THREEinterfaceadapters.controller;

import switchtwentytwenty.project.TWOusecaseservices.applicationservices.AddFamilyMemberService;
import switchtwentytwenty.project.Application;
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
