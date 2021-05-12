package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;


import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.AddRelationDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;


public interface IFamilyRESTController {

    ResponseEntity<OutputFamilyDTO> createFamilyAndSetAdmin(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO);

    ResponseEntity<OptionsDTO> familiesOptions();

    ResponseEntity<OptionsDTO> getFamilyOptions(String familyID);

    ResponseEntity<Object> addRelation(AddRelationDTO addRelationDTO, String familyID);

    ResponseEntity<Object> getFamily(String familyName);
}