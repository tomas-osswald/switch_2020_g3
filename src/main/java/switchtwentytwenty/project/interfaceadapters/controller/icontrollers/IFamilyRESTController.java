package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.category.CreateCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.dto.family.*;

public interface IFamilyRESTController {

    ResponseEntity<OutputRelationDTO> changeRelation(ChangeRelationDTO changeRelationDTO, String familyID, String relationID);

    ResponseEntity<OutputFamilyDTO> createFamilyAndSetAdmin(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO);

    ResponseEntity<OptionsDTO> familiesOptions();

    ResponseEntity<OptionsDTO> getFamilyOptions(String familyID);

    ResponseEntity<Object> createRelation(CreateRelationDTO createRelationDTO, String familyID);

    ResponseEntity<OutputFamilyDTO> getFamily(String familyName);

    ResponseEntity<Object> getCategories(String familyID);

    ResponseEntity<OutputCategoryDTO> addCustomCategory(String familyID, CreateCategoryDTO createCategoryDTO);


}