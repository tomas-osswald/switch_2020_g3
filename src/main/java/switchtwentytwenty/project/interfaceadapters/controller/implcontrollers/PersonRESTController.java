package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;

public class PersonRESTController implements IPersonRESTController {


    @Override
    public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO) {
        return null;
    }
}