package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.valueobject.EmailAddress;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.EmailExternalInternalAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyMemberExternalInternalAssembler;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IPersonRESTController;
import switchtwentytwenty.project.interfaceadapters.controller.ImplControllers.FamilyRESTController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.OutputEmailDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.ProfileInternalExternalAssembler;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IPersonRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonRESTControllerTest {

    @Mock
    EmailExternalInternalAssembler mockAssembler;

    @Mock
    FamilyMemberExternalInternalAssembler mockAddFamilyMemberAssembler;

    @Mock
    IAddEmailService mockAddEmailService;

    @Mock
    IGetFamilyMemberProfileService getFamilyMemberProfileService;

    @Mock
    IAddFamilyMemberService mockAddFamilyMemberService;

    @Mock
    GetProfileInfoDTO getProfileInfoDTO;

    @Mock
    InternalProfileDTO anInternalProfileDTO;

    @Mock
    InternalFamilyMemberDTO anInternalFamilyMemberDTO;

    @Mock
    OutputPersonDTO outputPersonDTO;

    @Mock
    OutputPersonDTO anOutputPersonDTO;


    @Mock
    ProfileInternalExternalAssembler profileInternalExternalAssembler;

    @InjectMocks
    switchtwentytwenty.project.interfaceadapters.controller.implcontrollers.PersonRESTController personRESTController;

    EmailAddress emailAddress = new EmailAddress("tonyze@latinlover.com");
    PersonID personID = new PersonID(emailAddress);
    InternalEmailDTO internalEmailDTO = new InternalEmailDTO(emailAddress.toString(), "3");
    OutputEmailDTO outputEmailDTO = new OutputEmailDTO(emailAddress.toString(), 3L);
    AddEmailDTO addEmailDTO = new AddEmailDTO("3", "tonyze@latinlover.com");
    AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO();

    @Disabled
    @Test
    void successCaseInAddEmail() {
        Mockito.when(mockAssembler.toInternal(addEmailDTO)).thenReturn(internalEmailDTO);
        Mockito.when(mockAddEmailService.addEmail(internalEmailDTO)).thenReturn(outputEmailDTO);


        OutputEmailDTO expectedOutputEmailDTO = new OutputEmailDTO(emailAddress.toString(), 3L);
        Link link = linkTo(methodOn(IPersonRESTController.class).getEmail(personID.toString(), outputEmailDTO.getEmailID())).withSelfRel();
        expectedOutputEmailDTO.add(link);

        ResponseEntity expected = new ResponseEntity(expectedOutputEmailDTO, HttpStatus.OK);

        ResponseEntity result = personRESTController.addEmail(addEmailDTO);

        assertEquals(expected, result);
    }

    @Disabled
    @Test
    void successCaseInGetProfileInfo() {

        Mockito.when(profileInternalExternalAssembler.toService(getProfileInfoDTO)).thenReturn(anInternalProfileDTO);
        Mockito.when(getFamilyMemberProfileService.getFamilyMemberProfile(anInternalProfileDTO)).thenReturn(outputPersonDTO);

        Mockito.when(getProfileInfoDTO.getPersonID()).thenReturn("tonyze@latinlover.com");

        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        //expectedOutputPersonDTO.add(link);
        ResponseEntity<OutputPersonDTO> expected = new ResponseEntity<OutputPersonDTO>(outputPersonDTO, HttpStatus.FOUND);

        ResponseEntity<OutputPersonDTO> result = personRESTController.getProfileInfo(getProfileInfoDTO);

        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode());
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Disabled
    @Test
    void successCaseInAddFamilyMemberl() {
        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        Mockito.when(mockAddFamilyMemberAssembler.toInner(addFamilyMemberDTO)).thenReturn(anInternalFamilyMemberDTO);
        Mockito.when(mockAddFamilyMemberService.addPerson(anInternalFamilyMemberDTO)).thenReturn(anOutputPersonDTO);

        Link link = linkTo(methodOn(IPersonRESTController.class).getEmail(personID.toString(), outputEmailDTO.getEmailID())).withSelfRel();
        expectedOutputPersonDTO.add(link);

        ResponseEntity expected = new ResponseEntity(expectedOutputPersonDTO, HttpStatus.OK);

        ResponseEntity result = personRESTController.addEmail(addEmailDTO);

        assertEquals(expected, result);
    }

}