package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;


import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;


public interface IFamilyRESTController {

    public ResponseEntity<OutputFamilyDTO> createFamilyAndSetAdmin(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO);

}