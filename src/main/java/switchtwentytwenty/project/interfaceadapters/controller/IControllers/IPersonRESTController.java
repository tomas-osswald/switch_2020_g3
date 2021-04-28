package switchtwentytwenty.project.interfaceadapters.controller.IControllers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.AddEmailDTO;

public interface IPersonRESTController {

        public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO);

    }