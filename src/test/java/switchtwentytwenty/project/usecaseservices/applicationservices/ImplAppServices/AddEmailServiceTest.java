package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.EmailAddress;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.dto.InputEmailDTO;
import switchtwentytwenty.project.dto.OutputEmailDTO;
import switchtwentytwenty.project.dto.UserIDDTO;
import switchtwentytwenty.project.exceptions.*;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class AddEmailServiceTest {

    @Mock
    IPersonRepository mockIPersonRepository;

    @Mock
    AddEmailDTO mockEmailDTO;

    @Mock
    Person tonyZe;

    @Mock
    InputEmailDTO mockInputEmailDTO;


    @Mock
    UserIDDTO mockUserIDDTO;

    @Mock
    OutputEmailDTO mockOutputEmailDTO;

    @InjectMocks
    AddEmailService addEmailService;


    PersonID IDTonyZe = new PersonID("tonyZe@gmail.com");
    EmailAddress tonyEmail = new EmailAddress("tonyZe@gmail.com");
    AddEmailDTO emailDTO = new AddEmailDTO(IDTonyZe.toString(), tonyEmail.toString());

    @BeforeEach
    void setup(){

        Mockito.when(mockUserIDDTO.unpackUserID()).thenReturn("tonyze@latinlover.com");
        Mockito.when(mockInputEmailDTO.unpackEmail()).thenReturn("tonyze@addemail.com");
    }


   /* AddEmailDTO tonyDTO = new AddEmailDTO("tonyZe@gmail.com","tonyZe@gmail.com");
    AddEmailDTO tonyInvalidPersonID = new AddEmailDTO("tony.com", "tonyZe@gmail.com");
    AddEmailDTO tonyInvalidEmail = new AddEmailDTO("tonyZe@gmail.com","tony.com");
    */

    @Test
    void addEmail() {
        PersonID tonyZeId = new PersonID("tonyze@latinlover.com");
        EmailAddress emailToAdd = new EmailAddress("tonyze@addemail.com");
        Mockito.when(mockIPersonRepository.getByID(tonyZeId)).thenReturn(tonyZe);
        Mockito.doNothing().when(tonyZe).addEmail(emailToAdd);
        Mockito.doNothing().when(mockIPersonRepository).updatePerson(tonyZe);

        assertDoesNotThrow(() -> addEmailService.addEmail(mockInputEmailDTO, mockUserIDDTO));
    }







    /*
    //TODO: adicionar metodo update no FamilyRepository (update sem fazer o check se a pessoa existe, o .add faz isso). Corrigir teste
    @Test
    @Disabled
    void addEmailSuccess() {
        Mockito.when(mockPersonRepository.getByID(IDTonyZe)).thenReturn(tonyZe);
        Mockito.doNothing().when(tonyZe).addEmail(tonyEmail);
        Mockito.when(mockPersonRepository.add(tonyZe)).thenReturn(tonyZe);

        assertDoesNotThrow(()->addEmailService.addEmail(tonyDTO));
    }

    @Test
    void addEmailFailWhenPersonIDFormatIsInvalid() {
        assertThrows(InvalidEmailException.class,()-> addEmailService.addEmail(tonyInvalidPersonID));
    }

    @Test
    void addEmailFailWhenEmailToAddHasInvalidFormat() {
        assertThrows(InvalidEmailException.class,()-> addEmailService.addEmail(tonyInvalidEmail));
    }

    @Test
    void addEmailFailWhenLoggedUserIDIsNotRegisteredInTheApplication() {
        Mockito.when(mockPersonRepository.getByID(IDTonyZe)).thenThrow(EmailNotRegisteredException.class);

        assertThrows(EmailNotRegisteredException.class,()-> addEmailService.addEmail(tonyDTO));
    }

    @Test
    void addEmailFailWhenEmailIsAlreadyRegisteredInThePerson() {
        Mockito.when(mockPersonRepository.getByID(IDTonyZe)).thenReturn(tonyZe);
        Mockito.doThrow(EmailAlreadyRegisteredException.class).when(tonyZe).addEmail(tonyEmail);

        assertThrows(EmailAlreadyRegisteredException.class,()-> addEmailService.addEmail(tonyDTO));
    }

     */

}