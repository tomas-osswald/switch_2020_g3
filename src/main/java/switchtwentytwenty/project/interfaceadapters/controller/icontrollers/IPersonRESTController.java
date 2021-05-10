package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.dto.OptionsDTO;

public interface IPersonRESTController {


    public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO);

    public ResponseEntity<Object> getEmail(String personID, String emailID);

    public ResponseEntity<OutputPersonDTO> getProfileInfo(String personID);

    public ResponseEntity<OptionsDTO> getPersonOptions(String personID);

    public ResponseEntity<OutputPersonDTO> addFamilyMember(AddFamilyMemberDTO addFamilyMemberDTO);
}