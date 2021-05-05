package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AddFamilyOutInAssembler;
import switchtwentytwenty.project.dto.family.InAddFamilyMemberDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IAddFamilyMemberController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;

@Controller
public class AddFamilyMemberController implements IAddFamilyMemberController {

    IAddFamilyMemberService addPersonService;

    AddFamilyOutInAssembler addFamilyMemberAssembler;

    @Autowired
    public AddFamilyMemberController(IAddFamilyMemberService addPersonService) {
        this.addPersonService = addPersonService;
        //this.addFamilyMemberAssembler = addFamilyMemberAssembler;
    }

    // o userID vem como string do controlador ou é logo lá é convertido em PersonID?
    public boolean addFamilyMember(AddFamilyMemberDTO addFamilyMemberDTO) {

        boolean result;
        InAddFamilyMemberDTO InAddFamilyMemberDTO = addFamilyMemberAssembler.toIn(addFamilyMemberDTO);

        //TODO: Substituir
        try {
            addPersonService.addPerson(InAddFamilyMemberDTO);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}