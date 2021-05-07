package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.GetProfileInfoDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

@RestController
@RequestMapping("/people")
public class PersonRESTController implements IPersonRESTController {

    private IGetFamilyMemberProfileService getFamilyMemberProfileService;

    @Autowired
    public PersonRESTController(IGetFamilyMemberProfileService getFamilyMemberProfileService) {
        this.getFamilyMemberProfileService = getFamilyMemberProfileService;
    }

    @Override
    public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getEmail(String personID, String emailID) {
        return null;
    }


    //TODO ver se DTO vem vazio se body do pedido for vazio
    @GetMapping(value = "/{personID}")
    public ResponseEntity<OutputPersonDTO> getProfileInfo(GetProfileInfoDTO getProfileInfoDTO) { return null; }

    public ResponseEntity<Object> getPersonID (GetProfileInfoDTO getProfileInfoDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getPersonOptions(String personID) {
        return null;
    }

}