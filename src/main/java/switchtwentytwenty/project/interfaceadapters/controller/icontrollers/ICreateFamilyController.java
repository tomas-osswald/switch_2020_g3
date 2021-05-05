package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;

@Controller
public interface ICreateFamilyController {

    public ResponseEntity<Object> createFamilyAndSetAdmin(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO);


}