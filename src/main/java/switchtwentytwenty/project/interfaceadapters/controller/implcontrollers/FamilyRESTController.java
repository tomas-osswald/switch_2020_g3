package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyInputDTOAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInputDTOAssembler;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;
import switchtwentytwenty.project.dto.family.*;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.exceptions.EmailNotRegisteredException;
import switchtwentytwenty.project.exceptions.InvalidEmailException;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IFamilyRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/families")
@CrossOrigin
public class FamilyRESTController implements IFamilyRESTController {

    private final ICreateFamilyService createFamilyService;

    private final FamilyInputDTOAssembler familyAssembler;

    private final PersonInputDTOAssembler personAssembler;

    private final IGetFamilyMembersAndRelationshipService getFamilyMembersAndRelationshipService;

    private final IFamiliesOptionsService familiesOptionsService;

    private final IFamilyOptionsService familyOptionsService;

    private final ICreateRelationService createRelationService;

    private final IGetCustomCategoriesService customCategoriesService;

    @Autowired
    public FamilyRESTController(ICreateFamilyService createFamilyService, FamilyInputDTOAssembler familyAssembler, PersonInputDTOAssembler personAssembler, IGetFamilyMembersAndRelationshipService getFamilyMembersAndRelationshipService, IFamiliesOptionsService familiesOptionsService, IFamilyOptionsService familyOptionsService, ICreateRelationService createRelationService, IGetCustomCategoriesService customCategoriesService) {
        this.createFamilyService = createFamilyService;
        this.familyAssembler = familyAssembler;
        this.personAssembler = personAssembler;
        this.getFamilyMembersAndRelationshipService = getFamilyMembersAndRelationshipService;
        this.familiesOptionsService = familiesOptionsService;
        this.familyOptionsService = familyOptionsService;
        this.createRelationService = createRelationService;
        this.customCategoriesService = customCategoriesService;

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
            return new ResponseEntity<>(outputFamilyDTO, status);
        } catch (IllegalArgumentException | InvalidEmailException | InvalidDataAccessApiUsageException | EmailNotRegisteredException | PersonAlreadyRegisteredException e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;

            return new ResponseEntity("Error: " + e.getMessage(), status);

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
    public ResponseEntity<Object> createRelation(@RequestBody CreateRelationDTO createRelationDTO, @PathVariable String familyID) {
        InputRelationDTO inputRelationDTO = familyAssembler.toInputRelationDTO(createRelationDTO, familyID);
        HttpStatus status;
        OutputRelationDTO outputRelationDTO;

        try {
            outputRelationDTO = createRelationService.createRelation(inputRelationDTO);
            status = HttpStatus.CREATED;
            Link optionsLink = linkTo(methodOn(FamilyRESTController.class).getFamilyOptions(familyID)).withSelfRel();
            outputRelationDTO.add(optionsLink);
            return new ResponseEntity<>(outputRelationDTO, status);
        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            return new ResponseEntity("Error: " + e.getMessage(), status);

        }

    }


    @GetMapping("/{familyID}/relations")
    public ResponseEntity<Object> getFamilyMembersAndRelations(@PathVariable String familyID) {
        HttpStatus status;
        FamilyMemberAndRelationsListDTO familyMemberAndRelationsListDTO;
        try {
            getFamilyMembersAndRelationshipService.getFamilyMembersAndRelations(familyID);
        } catch (Exception e) {

            throw new IllegalArgumentException();
        }
        return null;
    }

    @GetMapping("/{familyID}")
    public ResponseEntity<Object> getFamily(@PathVariable String familyID) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{familyID}/categories")
    public ResponseEntity<Object> getCategories(@PathVariable String familyID) {
        HttpStatus status;
        OutputCategoryTreeDTO outputCategoryTreeDTO;

        try {
            outputCategoryTreeDTO = customCategoriesService.getCustomCategories(familyID);
            status = HttpStatus.OK;

            Link selfLink = linkTo(methodOn(FamilyRESTController.class).getCategories(familyID)).withSelfRel();
            outputCategoryTreeDTO.add(selfLink);
            return new ResponseEntity<>(outputCategoryTreeDTO, status);
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity("Error: " + e.getMessage(), status);
        }
    }

    @RequestMapping(value = "/{familyID}/categories", method = RequestMethod.OPTIONS)
    public ResponseEntity<OptionsDTO> getCategoriesOptions(@PathVariable String familyID) {
        throw new UnsupportedOperationException();
    }
}