package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AddFamilyAndSetAdminDTOAssembler;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.AddRelationDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IFamilyRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/families")
@CrossOrigin
public class FamilyRESTController implements IFamilyRESTController {

    private ICreateFamilyService createFamilyService;

    private AddFamilyAndSetAdminDTOAssembler assembler;

    @Autowired
    public FamilyRESTController(ICreateFamilyService createFamilyService, AddFamilyAndSetAdminDTOAssembler assembler) {
        this.createFamilyService = createFamilyService;
        this.assembler = assembler;
    }

    /**
     * Method to create a family and add a person as administrator
     *
     * @param addFamilyAndSetAdminDTO
     * @return True if Family successfully created and added. False (by Exception e catch) if anything fails validation. False (by boolean false return on line 24) if admin email is already registered.
     */
    @PostMapping("/")
    public ResponseEntity<OutputFamilyDTO> createFamilyAndSetAdmin(@RequestBody AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO) {
        InputPersonDTO inputPersonDTO = assembler.toInputPersonDTO(addFamilyAndSetAdminDTO);
        InputFamilyDTO inputFamilyDTO = assembler.toInputFamilyDTO(addFamilyAndSetAdminDTO);

        HttpStatus status;
        OutputFamilyDTO outputFamilyDTO;

        try {
            outputFamilyDTO = createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO);
            status = HttpStatus.CREATED;

            Link selfLink = linkTo(methodOn(FamilyRESTController.class).getFamilyName(addFamilyAndSetAdminDTO.getFamilyName())).withSelfRel();
            outputFamilyDTO.add(selfLink);
            return new ResponseEntity(outputFamilyDTO, status);
        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;

            return new ResponseEntity("Business Error Api Logic", status);

        }
    }

    @RequestMapping(value = "/{familyID}", method = RequestMethod.OPTIONS)
    public ResponseEntity<Object> getFamilyOptions(@PathVariable String familyID){

        // FamilyOptionsDTO e por ai em diante? que extende o RepresentationModel para colocarmos os varios links?

        Link optionOne = linkTo(methodOn(FamilyRESTController.class).addRelation(new AddRelationDTO())).withRel("Add new Relation").withType("POST");
        //Link selfLinkTwo = linkTo(methodOn(FamilyRESTController.class).changeRelation(relationInputDTO, familyID).withSelfRel();

        //outputFamilyDTO.add(selfLink);

        //List<Link> options = new ArrayList<>();

        //options.add(optionOne);

        return new ResponseEntity<>(optionOne, HttpStatus.OK);

    }

    @RequestMapping(value = "/{familyID}/relations", method = RequestMethod.PATCH)
    public ResponseEntity<Object> addRelation(@RequestBody AddRelationDTO addRelationDTO) {

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/{familyName}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFamilyName(@PathVariable String familyName) {
        return null;
    }

}