package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.family.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.GetProfileInfoDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

public interface IPersonRESTController {

        public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO);
        public ResponseEntity<Object> getEmail (String personID, String emailID);
        public ResponseEntity<OutputPersonDTO> getProfileInfo(GetProfileInfoDTO getProfileInfoDTO);
        public ResponseEntity<Object> addFamilyMember(AddFamilyMemberDTO addFamilyMemberDTO);
    }