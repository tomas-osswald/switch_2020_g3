package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.person.GetProfileInfoDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInputDTOAssembler;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.InputAddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.dto.OptionsDTO;
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

    private PersonInputDTOAssembler familyMemberExternalInternalAssembler;

    private PersonInputDTOAssembler profileInternalExternalAssembler;

    @Autowired
    public PersonRESTController(PersonInputDTOAssembler profileInternalExternalAssembler, IGetFamilyMemberProfileService getFamilyMemberProfileService, IAddFamilyMemberService addFamilyMemberService, PersonInputDTOAssembler familyMemberExternalInternalAssembler) {
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
    @PostMapping
    public ResponseEntity<OutputPersonDTO> addFamilyMember(@RequestBody AddFamilyMemberDTO addFamilyMemberDTO) {
        InputAddFamilyMemberDTO internalAddFamilyMemberDTO = familyMemberExternalInternalAssembler.toInternalAddFamilyMemberDTO(addFamilyMemberDTO);

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
    public ResponseEntity<OptionsDTO> getPersonOptions(@PathVariable String personID) {
        OptionsDTO optionsDTO = new OptionsDTO();
        Link getProfileInfo = linkTo(methodOn(PersonRESTController.class).getProfileInfo(personID)).withRel("Get Profile Info").withType("GET");
        optionsDTO.add(getProfileInfo);
        return new ResponseEntity<>(optionsDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/{personID}")
    public ResponseEntity<OutputPersonDTO> getProfileInfo(@PathVariable String personID) {
        return null;
    }

    public ResponseEntity<Object> getPersonID(GetProfileInfoDTO getProfileInfoDTO) {
        return null;
    }

}