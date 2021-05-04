package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IPersonRESTController;

public class PersonRESTController implements IPersonRESTController {


    @Override
    public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO) {
        return null;
    }
}