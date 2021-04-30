package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IFamilyRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/families")
@CrossOrigin
public class FamilyRESTController implements IFamilyRESTController {

    private ICreateFamilyService createFamilyService;

    @Autowired
    public FamilyRESTController(ICreateFamilyService createFamilyService) {
        this.createFamilyService = createFamilyService;
    }

    /**
     * Method to create a family and add a person as administrator
     *
     * @param addFamilyAndSetAdminDTO
     * @return True if Family successfully created and added. False (by Exception e catch) if anything fails validation. False (by boolean false return on line 24) if admin email is already registered.
     */
    @PostMapping("/")

    public ResponseEntity<Object> createFamilyAndSetAdmin(@RequestBody AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        InputPersonDTO inputPersonDTO = new InputPersonDTO(addFamilyAndSetAdminDTO.getEmailID(), addFamilyAndSetAdminDTO.getName(), addFamilyAndSetAdminDTO.getBirthDate(), addFamilyAndSetAdminDTO.getVatNumber(), addFamilyAndSetAdminDTO.getPhone(), addFamilyAndSetAdminDTO.getStreet(), addFamilyAndSetAdminDTO.getCity(), addFamilyAndSetAdminDTO.getHouseNumber(), addFamilyAndSetAdminDTO.getZipCode());
        InputFamilyDTO inputFamilyDTO = new InputFamilyDTO(addFamilyAndSetAdminDTO.getFamilyName(), addFamilyAndSetAdminDTO.getLocalDate());

        HttpStatus status;
        OutputFamilyDTO outputFamilyDTO;

        try {
            outputFamilyDTO = createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO);
            status = HttpStatus.CREATED;

            Link selfLink = linkTo(methodOn(FamilyRESTController.class).getFamilyName(addFamilyAndSetAdminDTO.getFamilyName())).withSelfRel();
            outputFamilyDTO.add(selfLink);
            return new ResponseEntity<>(outputFamilyDTO, status);
        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            return new ResponseEntity<>("BUSineSs ErRoR ApI LoGIc", status);
        }


    }

    @RequestMapping(value = "/{familyName}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFamilyName(@PathVariable String familyName) {
        return null;
    }

}