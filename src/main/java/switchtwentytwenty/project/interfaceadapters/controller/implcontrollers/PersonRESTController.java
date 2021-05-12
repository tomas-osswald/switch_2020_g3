package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInputDTOAssembler;
import switchtwentytwenty.project.dto.person.*;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.exceptions.EmailNotRegisteredException;
import switchtwentytwenty.project.exceptions.InvalidEmailException;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IPersonOptionsService;
import switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.PersonOptionsService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/people")
@CrossOrigin
public class PersonRESTController implements IPersonRESTController {

    private IGetFamilyMemberProfileService getFamilyMemberProfileService;

    private IAddFamilyMemberService addFamilyMemberService;

    private IAddEmailService addEmailService;

    private PersonInputDTOAssembler personInputDTOAssembler;

    private PersonInputDTOAssembler profileInternalExternalAssembler;

    private IPersonOptionsService personOptionsService;

    @Autowired
    public PersonRESTController(PersonOptionsService personOptionsService, PersonInputDTOAssembler profileInternalExternalAssembler, IGetFamilyMemberProfileService getFamilyMemberProfileService, IAddFamilyMemberService addFamilyMemberService, PersonInputDTOAssembler personInputDTOAssembler, IAddEmailService addEmailService) {
        this.getFamilyMemberProfileService = getFamilyMemberProfileService;
        this.addFamilyMemberService = addFamilyMemberService;
        this.personInputDTOAssembler = personInputDTOAssembler;
        this.profileInternalExternalAssembler = profileInternalExternalAssembler;
        this.addEmailService = addEmailService;
        this.personOptionsService = personOptionsService;
    }

    @Override
    @PostMapping(value = "/{personID}/emails")
    public ResponseEntity<Object> addEmail(@RequestBody AddEmailDTO addEmailDTO, @PathVariable String personID) {
        InputEmailDTO inputEmailDTO = personInputDTOAssembler.toInputEmailDTO(addEmailDTO, personID);

        HttpStatus status;
        OutputEmailDTO outputEmailDTO;

        try {
            outputEmailDTO = addEmailService.addEmail(inputEmailDTO);
            status = HttpStatus.OK;

            Link personSelfLink = linkTo(methodOn(PersonRESTController.class).getProfileInfo(personID)).withSelfRel();
            outputEmailDTO.add(personSelfLink);
            return new ResponseEntity<>(outputEmailDTO, status);
        } catch (InvalidEmailException | EmailAlreadyRegisteredException e) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>("Error: " + e.getMessage(), status);
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<OutputPersonDTO> addFamilyMember(@RequestBody AddFamilyMemberDTO addFamilyMemberDTO) {
        InputAddFamilyMemberDTO internalAddFamilyMemberDTO = personInputDTOAssembler.toInputAddFamilyMemberDTO(addFamilyMemberDTO);

        HttpStatus status;
        OutputPersonDTO outputPersonDTO;

        try {
            outputPersonDTO = addFamilyMemberService.addPerson(internalAddFamilyMemberDTO);
            status = HttpStatus.CREATED;
            Link personOptionsLink = linkTo(methodOn(PersonRESTController.class).personOptions(outputPersonDTO.getId())).withRel("Person Options");
            outputPersonDTO.add(personOptionsLink);
            return new ResponseEntity<>(outputPersonDTO, status);
        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            return new ResponseEntity(status);
        }

    }

    @RequestMapping(value = "/{personID}", method = RequestMethod.OPTIONS)
    public ResponseEntity<OptionsDTO> personOptions(@PathVariable String personID) {
        OptionsDTO optionsDTO = personOptionsService.getPersonOptions(personID);

        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "OPTIONS");

        return new ResponseEntity<>(optionsDTO, header, HttpStatus.OK);
    }


    @GetMapping(value = "/{personID}")
    public ResponseEntity<OutputPersonDTO> getProfileInfo(@PathVariable String personID) {

        try {
            InputGetProfileDTO inputGetProfileDTO = profileInternalExternalAssembler.toInternalGetProfileDTO(personID);

            OutputPersonDTO outputPersonDTO = getFamilyMemberProfileService.getFamilyMemberProfile(inputGetProfileDTO);

            Link link = linkTo(methodOn(PersonRESTController.class).personOptions(personID)).withSelfRel();

            outputPersonDTO.add(link);

            return new ResponseEntity(outputPersonDTO, HttpStatus.FOUND);

        } catch (EmailNotRegisteredException e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

        }

    }

}