package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.person.AddEmailDTO;

public interface IPersonRESTController {

        public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO);

    }