package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

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
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.exceptions.EmailNotRegisteredException;
import switchtwentytwenty.project.exceptions.InvalidEmailException;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class AddEmailServiceTest {

    @Mock
    IPersonRepository mockPersonRepository;

    @Mock
    Person tonyZe;

    @InjectMocks
    AddEmailService addEmailService;

    PersonID IDTonyZe = new PersonID("tonyZe@gmail.com");
    EmailAddress tonyEmail = new EmailAddress("tonyZe@gmail.com");
    AddEmailDTO tonyDTO = new AddEmailDTO("tonyZe@gmail.com","tonyZe@gmail.com");
    AddEmailDTO tonyInvalidPersonID = new AddEmailDTO("tony.com", "tonyZe@gmail.com");
    AddEmailDTO tonyInvalidEmail = new AddEmailDTO("tonyZe@gmail.com","tony.com");

    @Test
    void addEmailSuccess() {
        Mockito.when(mockPersonRepository.getByID(IDTonyZe)).thenReturn(tonyZe);
        Mockito.doNothing().when(tonyZe).addEmail(tonyEmail);
        Mockito.doNothing().when(mockPersonRepository).save(tonyZe);

        assertDoesNotThrow(()->addEmailService.addEmail(tonyDTO));
    }

    @Test
    void addEmailFail_PersonID() {
        assertThrows(InvalidEmailException.class,()-> addEmailService.addEmail(tonyInvalidPersonID));
    }

    @Test
    void addEmailFail_Email() {
        assertThrows(InvalidEmailException.class,()-> addEmailService.addEmail(tonyInvalidEmail));
    }

    @Test
    void addEmailFail_getByID() {
        Mockito.when(mockPersonRepository.getByID(IDTonyZe)).thenThrow(EmailNotRegisteredException.class);

        assertThrows(EmailNotRegisteredException.class,()-> addEmailService.addEmail(tonyDTO));
    }

    @Test
    void addEmailFail_AddEmail() {
        Mockito.when(mockPersonRepository.getByID(IDTonyZe)).thenReturn(tonyZe);
        Mockito.doThrow(EmailAlreadyRegisteredException.class).when(tonyZe).addEmail(tonyEmail);

        assertThrows(EmailAlreadyRegisteredException.class,()-> addEmailService.addEmail(tonyDTO));
    }
}