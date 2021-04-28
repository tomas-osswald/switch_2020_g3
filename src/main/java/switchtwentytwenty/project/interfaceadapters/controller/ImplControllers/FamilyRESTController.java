package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IFamilyRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;

@RestController
@RequestMapping("/families")
@CrossOrigin
public class FamilyRESTController implements IFamilyRESTController {

    private ICreateFamilyService createFamilyService;

    @Autowired
    public FamilyRESTController(ICreateFamilyService createFamilyService) {
        this.createFamilyService = createFamilyService;
    }
    //TODO: definir result, a cena do link para aceder ao recurso criado
    /**
     * Method to create a family and add a person as administrator
     *
     * @param addFamilyAndSetAdminDTO
     * @return True if Family successfully created and added. False (by Exception e catch) if anything fails validation. False (by boolean false return on line 24) if admin email is already registered.
     */
    @PutMapping("/")

       public ResponseEntity<Object> createFamilyAndSetAdmin(@RequestBody AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        InputPersonDTO inputPersonDTO = new InputPersonDTO(addFamilyAndSetAdminDTO.getEmailID(), addFamilyAndSetAdminDTO.getEmailID(), addFamilyAndSetAdminDTO.getName(), addFamilyAndSetAdminDTO.getBirthDate(), addFamilyAndSetAdminDTO.getVatNumber(), addFamilyAndSetAdminDTO.getPhone(), addFamilyAndSetAdminDTO.getStreet(), addFamilyAndSetAdminDTO.getCity(), addFamilyAndSetAdminDTO.getHouseNumber(), addFamilyAndSetAdminDTO.getZipCode());
        InputFamilyDTO inputFamilyDTO = new InputFamilyDTO(addFamilyAndSetAdminDTO.getFamilyName(), addFamilyAndSetAdminDTO.getLocalDate());

        HttpStatus status;
        String result;
        try {
            createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO);
            status = HttpStatus.CREATED;
            result = "Family added";
        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            result = e.getMessage();
        }
        return new ResponseEntity<>(result, status);
    }
}