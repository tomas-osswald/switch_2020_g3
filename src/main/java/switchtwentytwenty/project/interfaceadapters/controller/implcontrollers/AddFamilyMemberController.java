package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInputDTOAssembler;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.InputAddFamilyMemberDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IAddFamilyMemberController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;

@Controller
public class AddFamilyMemberController implements IAddFamilyMemberController {

    IAddFamilyMemberService addPersonService;
    PersonInputDTOAssembler addFamilyMemberAssembler;

    @Autowired
    public AddFamilyMemberController(IAddFamilyMemberService addPersonService) {
        this.addPersonService = addPersonService;
        //this.addFamilyMemberAssembler = addFamilyMemberAssembler;
    }

    // o userID vem como string do controlador ou é logo lá é convertido em PersonID?
    public boolean addFamilyMember(AddFamilyMemberDTO addFamilyMemberDTO) {

        boolean result;
        InputAddFamilyMemberDTO InternalAddFamilyMemberDTO = addFamilyMemberAssembler.toInternalAddFamilyMemberDTO(addFamilyMemberDTO);

        //TODO: Substituir
        try {
            addPersonService.addPerson(InternalAddFamilyMemberDTO);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}