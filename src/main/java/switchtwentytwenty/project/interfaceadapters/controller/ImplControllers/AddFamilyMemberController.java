package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IAddFamilyMemberController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;

@Controller
public class AddFamilyMemberController implements IAddFamilyMemberController {
    
    @Autowired
    IAddFamilyMemberService addPersonService;

    // o userID vem como string do controlador ou é logo lá é convertido em PersonID?
    public boolean addFamilyMember(InputPersonDTO inputPersonDTO, String userID) {
        boolean result;

        try {
            addPersonService.addPerson(inputPersonDTO, userID);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}