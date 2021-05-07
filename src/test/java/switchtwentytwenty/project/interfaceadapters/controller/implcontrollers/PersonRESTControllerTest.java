package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.EmailExternalInternalAssembler;

import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyMemberExternalInternalAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.ProfileInternalExternalAssembler;
import switchtwentytwenty.project.dto.family.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;

import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonRESTControllerTest {

    @Autowired
    IPersonRESTController personRESTController;

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


    String emailAddress = "tonyze@latinlover.com";
    PersonID personID = new PersonID(emailAddress);
    InternalEmailDTO internalEmailDTO = new InternalEmailDTO(emailAddress.toString(), "tonyadmin@gmail.com");
    OutputEmailDTO outputEmailDTO = new OutputEmailDTO(emailAddress.toString(), "tonyadmin@gmail.com");
    AddEmailDTO addEmailDTO = new AddEmailDTO("tonyadmin@gmail.com", "tonyze@latinlover.com");
    AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO("2L","3L", "tony", "12/02/1999", 123456789,961962963, "Rua da Estrada", "Porto", "12", "4000" );

    @Disabled
    @Test
    @DisplayName("Success case of adding an email to a Person")
    void successCaseInAddEmail() {
        Mockito.when(mockAssembler.toInternal(addEmailDTO)).thenReturn(internalEmailDTO);
        Mockito.when(mockAddEmailService.addEmail(internalEmailDTO)).thenReturn(outputEmailDTO);


        OutputEmailDTO expectedOutputEmailDTO = new OutputEmailDTO(emailAddress.toString(), "tonyadmin@gmail.com");
        Link link = linkTo(methodOn(IPersonRESTController.class).getEmail(personID.toString(), outputEmailDTO.unpackEmailID())).withSelfRel();
        expectedOutputEmailDTO.add(link);

        ResponseEntity expected = new ResponseEntity(expectedOutputEmailDTO, HttpStatus.OK);

        ResponseEntity result = personRESTController.addEmail(addEmailDTO);

        assertEquals(expected, result);
    }

    @Disabled
    @DisplayName("Fail test when Email is already registered in the Person")
    @Test
    void failCaseInAddEmailWhenProvidedEmailIsAlreadyRegisteredInThePerson() {

    }

    @Disabled
    @DisplayName("Fail test when Email is in invalid format")
    @Test
    void failCaseInAddEmailWhenProvidedEmailIsWrongfullyInsertedExpectingInvalidEmailException() {

    }

    @Disabled
    @Test
    void successCaseInGetProfileInfo() {

        Mockito.when(profileInternalExternalAssembler.toService(getProfileInfoDTO)).thenReturn(anInternalProfileDTO);
        Mockito.when(getFamilyMemberProfileService.getFamilyMemberProfile(anInternalProfileDTO)).thenReturn(outputPersonDTO);

        Mockito.when(getProfileInfoDTO.getPersonID()).thenReturn("tonyze@latinlover.com");

        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        Link link = linkTo(methodOn(PersonRESTController.class).getPersonOptions(getProfileInfoDTO.getPersonID())).withSelfRel();
        expectedOutputPersonDTO.add(link);
        ResponseEntity<OutputPersonDTO> expected = new ResponseEntity<OutputPersonDTO>(expectedOutputPersonDTO, HttpStatus.FOUND);

        ResponseEntity<OutputPersonDTO> result = personRESTController.getProfileInfo(getProfileInfoDTO);

        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode());
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Disabled
    @Test
    void successCaseInAddFamilyMember() {
//        AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO("2L","3L", "tony", "12/02/1999", 123456789,961962963, "Rua da Estrada", "Porto", "12", "4000" );
        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        Mockito.when(mockAddFamilyMemberAssembler.toInner(addFamilyMemberDTO)).thenReturn(anInternalFamilyMemberDTO);
        Mockito.when(mockAddFamilyMemberService.addPerson(anInternalFamilyMemberDTO)).thenReturn(anOutputPersonDTO);

        Link link = linkTo(methodOn(IPersonRESTController.class).addFamilyMember(addFamilyMemberDTO)).withSelfRel();
        expectedOutputPersonDTO.add(link);

        ResponseEntity expected = new ResponseEntity(expectedOutputPersonDTO, HttpStatus.OK);

        ResponseEntity result = personRESTController.addFamilyMember(addFamilyMemberDTO);

        assertEquals(expected, result);
    }

}