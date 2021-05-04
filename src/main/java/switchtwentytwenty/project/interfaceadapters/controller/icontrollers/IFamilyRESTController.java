package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;


import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;


public interface IFamilyRESTController {

    public ResponseEntity<Object> createFamilyAndSetAdmin(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO);

}