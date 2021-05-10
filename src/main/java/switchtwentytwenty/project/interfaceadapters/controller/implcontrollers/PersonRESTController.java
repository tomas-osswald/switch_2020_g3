package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.GetProfileInfoDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInternalDTOAssembler;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.family.InternalAddFamilyMemberDTO;
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

    private IAddFamilyMemberService addFamilyMemberService;

    private PersonInternalDTOAssembler familyMemberExternalInternalAssembler;

    private PersonInternalDTOAssembler profileInternalExternalAssembler;

    @Autowired
    public PersonRESTController(PersonInternalDTOAssembler profileInternalExternalAssembler, IGetFamilyMemberProfileService getFamilyMemberProfileService, IAddFamilyMemberService addFamilyMemberService, PersonInternalDTOAssembler familyMemberExternalInternalAssembler) {
        this.getFamilyMemberProfileService = getFamilyMemberProfileService;
        this.addFamilyMemberService = addFamilyMemberService;
        this.familyMemberExternalInternalAssembler = familyMemberExternalInternalAssembler;
        this.profileInternalExternalAssembler = profileInternalExternalAssembler;
    }

    @Override
    public ResponseEntity<Object> addEmail(AddEmailDTO addEmailDTO) {
        return null;
    }

    /**
     * Not a User Story method. This method exists to allow access to an added email. It's supposed to be an Options method
     * to be included after the addEmail method successfully adds an email to a person.
     *
     * @param personID
     * @param emailID
     * @return A string with the person id to access the person resource and a string with the added email id to access the added resource.
     */
    @Override
    public ResponseEntity<Object> getEmail(String personID, String emailID) {
        return null;
    }

    @Override
    @PostMapping("/add/")
    public ResponseEntity<OutputPersonDTO> addFamilyMember(@RequestBody AddFamilyMemberDTO addFamilyMemberDTO) {
        InternalAddFamilyMemberDTO internalAddFamilyMemberDTO = familyMemberExternalInternalAssembler.toInternalAddFamilyMemberDTO(addFamilyMemberDTO);

        HttpStatus status;
        OutputPersonDTO outputPersonDTO;

        try {
            outputPersonDTO = addFamilyMemberService.addPerson(internalAddFamilyMemberDTO);
            status = HttpStatus.CREATED;

            Link personOptionsLink = linkTo(methodOn(PersonRESTController.class).getPersonOptions(outputPersonDTO.getId())).withRel("Person Options");
            outputPersonDTO.add(personOptionsLink);
            return new ResponseEntity<>(outputPersonDTO, status);
        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            return new ResponseEntity("Error: " + e.getMessage(), status);
        }

    }

    @RequestMapping(value = "/{personID}", method = RequestMethod.OPTIONS)
    public ResponseEntity<PersonOptionsDTO> getPersonOptions(@PathVariable String personID) {
        PersonOptionsDTO personOptionsDTO = new PersonOptionsDTO();
        Link getProfileInfo = linkTo(methodOn(PersonRESTController.class).getProfileInfo(personID)).withRel("Get Profile Info").withType("GET");
        personOptionsDTO.add(getProfileInfo);
        return new ResponseEntity<PersonOptionsDTO>(personOptionsDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/{personID}")
    public ResponseEntity<OutputPersonDTO> getProfileInfo(@PathVariable String personID) {
        return null;
    }

    public ResponseEntity<Object> getPersonID(GetProfileInfoDTO getProfileInfoDTO) {
        return null;
    }

}