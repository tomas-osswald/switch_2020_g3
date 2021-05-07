package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.GetProfileInfoDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyMemberExternalInternalAssembler;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.dto.person.PersonOptionsDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/people")
@CrossOrigin
public class PersonRESTController implements IPersonRESTController {

    private IGetFamilyMemberProfileService getFamilyMemberProfileService;

    private FamilyMemberExternalInternalAssembler familyMemberExternalInternalAssembler;

    private IAddFamilyMemberService addFamilyMemberService;


    @Autowired
    public PersonRESTController(IGetFamilyMemberProfileService getFamilyMemberProfileService, IAddFamilyMemberService addFamilyMemberService) {
        this.getFamilyMemberProfileService = getFamilyMemberProfileService;
        this.addFamilyMemberService = addFamilyMemberService;
    }

    @Override
    public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getEmail(String personID, String emailID) {
        return null;
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<OutputPersonDTO> addFamilyMember(AddFamilyMemberDTO addFamilyMemberDTO) {
        InternalFamilyMemberDTO internalFamilyMemberDTO = familyMemberExternalInternalAssembler.toInner(addFamilyMemberDTO);

        HttpStatus status;
        OutputPersonDTO outputPersonDTO;

        try {
            outputPersonDTO = addFamilyMemberService.addPerson(internalFamilyMemberDTO);
            status = HttpStatus.CREATED;

            Link personOptionsLink = linkTo(methodOn(PersonRESTController.class).getPersonOptions(outputPersonDTO.getId())).withSelfRel();
            outputPersonDTO.add(personOptionsLink);
            return new ResponseEntity<OutputPersonDTO>(outputPersonDTO, status);
        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            return new ResponseEntity("Error", status);
        }

    }

    @RequestMapping(value = "/{personID}", method = RequestMethod.OPTIONS)
    public ResponseEntity<PersonOptionsDTO> getPersonOptions(@PathVariable String personID) {
        PersonOptionsDTO personOptionsDTO = new PersonOptionsDTO();
        Link getProfileInfo = linkTo(methodOn(PersonRESTController.class).getProfileInfo(new GetProfileInfoDTO(personID))).withRel("Get Profile Info").withType("GET");
        personOptionsDTO.add(getProfileInfo);
        return new ResponseEntity<PersonOptionsDTO>(personOptionsDTO, HttpStatus.OK);
    }

    //TODO ver se DTO vem vazio se body do pedido for vazio
    @GetMapping(value = "/{personID}")
    public ResponseEntity<OutputPersonDTO> getProfileInfo(GetProfileInfoDTO getProfileInfoDTO) {
        return null;
    }

}