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
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.EmailExternalInternalAssembler;

import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInternalDTOAssembler;
import switchtwentytwenty.project.dto.person.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.family.InternalAddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.exceptions.InvalidEmailException;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
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
    PersonInternalDTOAssembler mockAddFamilyMemberAssembler;

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
    InternalAddFamilyMemberDTO anInternalAddFamilyMemberDTO;

    @Mock
    OutputPersonDTO outputPersonDTO;

    @Mock
    OutputPersonDTO anOutputPersonDTO;


    @Mock
    PersonInternalDTOAssembler profileInternalExternalAssembler;

    @InjectMocks

    // Este Person precisa de ser instanciado para o email lhe ser adicionado após a implementação e poder testar se adiciona?
    //Ou pode ser mocked e o Spring faz magia negra e sabe que é o Tony e adiciona-lhe o email?
    Person personToAddEmail;

    String emailAddressAsID = "tonyze@latinlover.com";
    PersonID personID = new PersonID(emailAddressAsID);
    String emailToAdd = "tony@emailtoadd.com";
    String invalidEmailToAdd = "invalidemail.com";
    String emailIDAfterAddingToDatabase = "3L";
    InternalEmailDTO internalEmailDTO = new InternalEmailDTO(emailAddressAsID, emailToAdd);
    OutputEmailDTO outputEmailDTO = new OutputEmailDTO(emailToAdd, emailIDAfterAddingToDatabase);
    AddEmailDTO addEmailDTO = new AddEmailDTO(emailAddressAsID,emailToAdd);
    AddEmailDTO INVALIDAddEmailDTO = new AddEmailDTO(emailAddressAsID, invalidEmailToAdd);
    InternalEmailDTO INVALIDInternalEmailDTO = new InternalEmailDTO(INVALIDAddEmailDTO.unpackUserID(), INVALIDAddEmailDTO.unpackEmail());

    AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO("2L", "3L", "tony", "12/02/1999", 123456789, 961962963, "Rua da Estrada", "Porto", "12", "4000");


    @Disabled
    @Test
    @DisplayName("Success case of adding an email to a Person")
    void successCaseInAddEmail() {
        Mockito.when(mockAssembler.toInternal(addEmailDTO)).thenReturn(internalEmailDTO);
        Mockito.when(mockAddEmailService.addEmail(internalEmailDTO)).thenReturn(outputEmailDTO);


        OutputEmailDTO expectedOutputEmailDTO = new OutputEmailDTO(emailAddressAsID, "3L");
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
    Mockito.when(mockAssembler.toInternal(addEmailDTO)).thenReturn(internalEmailDTO);
    Mockito.when(mockAddEmailService.addEmail(internalEmailDTO)).thenThrow(EmailAlreadyRegisteredException.class);

    ResponseEntity expected = new ResponseEntity("Error message to be implemented", HttpStatus.BAD_REQUEST);

    ResponseEntity result = personRESTController.addEmail(addEmailDTO);

    assertEquals(expected, result);
    }

    @Disabled
    @DisplayName("Fail test when Email is in invalid format")
    @Test
    void failCaseInAddEmailWhenProvidedEmailIsWrongfullyInsertedExpectingInvalidEmailException() {
    Mockito.when(mockAssembler.toInternal(INVALIDAddEmailDTO)).thenReturn(INVALIDInternalEmailDTO);
    Mockito.when(mockAddEmailService.addEmail(INVALIDInternalEmailDTO)).thenThrow(InvalidEmailException.class);

    //Sem certeza que Bad_Request se enquadra neste HttpStatus
    ResponseEntity expected = new ResponseEntity("Error message to be implemented", HttpStatus.BAD_REQUEST);

    ResponseEntity result = personRESTController.addEmail(INVALIDAddEmailDTO);

    assertEquals(expected, result);
    }

    @Disabled
    @Test
    void successCaseInGetProfileInfo() {

        Mockito.when(profileInternalExternalAssembler.toInternalProfileDTO(emailAddressAsID)).thenReturn(anInternalProfileDTO);
        Mockito.when(getFamilyMemberProfileService.getFamilyMemberProfile(anInternalProfileDTO)).thenReturn(outputPersonDTO);

        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        Link link = linkTo(methodOn(PersonRESTController.class).getPersonOptions(getProfileInfoDTO.getPersonID())).withSelfRel();
        expectedOutputPersonDTO.add(link);
        ResponseEntity<OutputPersonDTO> expected = new ResponseEntity<OutputPersonDTO>(expectedOutputPersonDTO, HttpStatus.FOUND);

        ResponseEntity<OutputPersonDTO> result = personRESTController.getProfileInfo(getProfileInfoDTO.getPersonID());

        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode());
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }


    @Disabled
    @Test
    void successCaseInAddFamilyMember() {
//        AddFamilyMemberDTO addFamilyMemberDTO = new AddFamilyMemberDTO("2L","3L", "tony", "12/02/1999", 123456789,961962963, "Rua da Estrada", "Porto", "12", "4000" );
        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        Mockito.when(mockAddFamilyMemberAssembler.toInternalAddFamilyMemberDTO(addFamilyMemberDTO)).thenReturn(anInternalAddFamilyMemberDTO);
        Mockito.when(mockAddFamilyMemberService.addPerson(anInternalAddFamilyMemberDTO)).thenReturn(anOutputPersonDTO);

        Link link = linkTo(methodOn(IPersonRESTController.class).addFamilyMember(addFamilyMemberDTO)).withSelfRel();
        expectedOutputPersonDTO.add(link);

        ResponseEntity expected = new ResponseEntity(expectedOutputPersonDTO, HttpStatus.OK);

        ResponseEntity result = personRESTController.addFamilyMember(addFamilyMemberDTO);

        assertEquals(expected, result);
    }

    @Disabled
    @Test
    /*void failCaseInAddFamilyMemberWhenPersonisAlreadyRegistered() {
        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        Mockito.when(mockAddFamilyMemberAssembler.toInternalAddFamilyMemberDTO(addFamilyMemberDTO)).thenReturn(anInternalAddFamilyMemberDTO);
        Mockito.when(mockAddFamilyMemberService.addPerson(anInternalAddFamilyMemberDTO)).thenThrow(PersonAlreadyRegisteredException.class);

        Link link = linkTo(methodOn(IPersonRESTController.class).addFamilyMember(addFamilyMemberDTO)).withSelfRel();
        //expectedOutputPersonDTO.add(link);

        ResponseEntity expected = new ResponseEntity("error message", HttpStatus.BAD_REQUEST);

        ResponseEntity result = personRESTController.addFamilyMember(addFamilyMemberDTO);

        assertEquals(expected, result);
    }*/

}