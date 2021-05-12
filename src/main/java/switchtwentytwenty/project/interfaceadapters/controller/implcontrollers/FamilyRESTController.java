package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyInputDTOAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInputDTOAssembler;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.AddRelationDTO;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IFamilyRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;
import switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.FamiliesOptionsService;
import switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.FamilyOptionsService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/families")
@CrossOrigin
public class FamilyRESTController implements IFamilyRESTController {

    private final ICreateFamilyService createFamilyService;

    private final FamilyInputDTOAssembler familyAssembler;

    private final PersonInputDTOAssembler personAssembler;

    private final FamiliesOptionsService familiesOptionsService;

    private final FamilyOptionsService familyOptionsService;

    @Autowired
    public FamilyRESTController(ICreateFamilyService createFamilyService, FamilyInputDTOAssembler familyAssembler, PersonInputDTOAssembler personAssembler, FamiliesOptionsService familiesOptionsService, FamilyOptionsService familyOptionsService) {
        this.createFamilyService = createFamilyService;
        this.familyAssembler = familyAssembler;
        this.personAssembler = personAssembler;
        this.familiesOptionsService = familiesOptionsService;
        this.familyOptionsService = familyOptionsService;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<OptionsDTO> familiesOptions() {

        OptionsDTO options = familiesOptionsService.getFamiliesOptions();

        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "POST, OPTIONS");

        return new ResponseEntity(options, header, HttpStatus.OK);
    }

    /**
     * Method to create a family and add a person as administrator
     *
     * @param addFamilyAndSetAdminDTO
     * @return True if Family successfully created and added. False (by Exception e catch) if anything fails validation. False (by boolean false return on line 24) if admin email is already registered.
     */
    @PostMapping
    public ResponseEntity<OutputFamilyDTO> createFamilyAndSetAdmin(@RequestBody AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        InputPersonDTO inputPersonDTO = personAssembler.toInputPersonDTO(addFamilyAndSetAdminDTO);
        InputFamilyDTO inputFamilyDTO = familyAssembler.toInputFamilyDTO(addFamilyAndSetAdminDTO);

        HttpStatus status;
        OutputFamilyDTO outputFamilyDTO;

        try {
            outputFamilyDTO = createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO);
            status = HttpStatus.CREATED;

            Link selfLink = linkTo(methodOn(FamilyRESTController.class).getFamily(outputFamilyDTO.getFamilyID())).withSelfRel();
            outputFamilyDTO.add(selfLink);
            return new ResponseEntity(outputFamilyDTO, status);
        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;

            return new ResponseEntity("Business Error Api Logic", status);

        }
    }

    @RequestMapping(value = "/{familyID}", method = RequestMethod.OPTIONS)
    public ResponseEntity<OptionsDTO> getFamilyOptions(@PathVariable String familyID) {

        OptionsDTO options = familyOptionsService.getFamilyOptions(familyID);

        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "OPTIONS");

        return new ResponseEntity<>(options, header, HttpStatus.OK);
    }

    @PostMapping("/{familyID}/relations")
    public ResponseEntity<Object> addRelation(@RequestBody AddRelationDTO addRelationDTO, @PathVariable String familyID) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{familyID}")
    public ResponseEntity<Object> getFamily(@PathVariable String familyID) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/{familyID}/categories", method = RequestMethod.OPTIONS)
    public ResponseEntity<OptionsDTO> getCategoriesOptions(@PathVariable String familyID){
        throw new UnsupportedOperationException();
    }
}