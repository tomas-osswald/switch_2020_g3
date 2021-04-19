package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.exceptions.EmailNotRegisteredException;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
import switchtwentytwenty.project.exceptions.UserIsNotAdminException;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddFamilyMemberServiceTest {

    @Mock
    IPersonRepository personRepository;

    @Mock
    IFamilyRepository familyRepository;

    /*@Mock
    AddPersonDTO addPersonDTO;*/

    //@Mock
    //PersonID personID;

    @Mock
    Person admin;


    //@Mock
    //FamilyID familyID;

    //PersonID loggedUserIDtest = new PersonID("tonyze@latinas.com");

    //@Mock
    //PersonID loggedUserID;

    @InjectMocks
    AddFamilyMemberService addFamilyMemberService;

    AddPersonDTO addPersonDTO = new AddPersonDTO("tonyze@latinas.com", "tonyze@latinas.com", "TonyZe", "10/10/1999", 123456789, 961962963, "Rua das Irma's Beleza e do Primo Flavio", "Gaia", 100, "4400");
    PersonID loggedUserID = new PersonID("tonyze@latinas.com");
    PersonID personID = new PersonID("tonyze@latinas.com");
    FamilyID familyID = new FamilyID(UUID.randomUUID());

    AddPersonDTO addPersonDTOWrongName = new AddPersonDTO("tonyze@latinas.com", "tonyze@latinas.com", null, "10/10/1999", 123456789, 961962963, "Rua das Irma's Beleza e do Primo Flavio", "Gaia", 100, "4400");

    @Test
    void addPersonSuccess() {

//        Mockito.when(addPersonDTO.unpackUserID()).thenReturn("tonyze@latinas.com");
        //   Mockito.doNothing().when(familyRepository).verifyAdmin(loggedUserID);
        /*Mockito.when(addPersonDTO.unpackName()).thenReturn("tonyze@latinas.com");
        Mockito.when(addPersonDTO.unpackBirthDate()).thenReturn("10/10/1999");
        Mockito.when(addPersonDTO.unpackEmail()).thenReturn("tonyze@latinas.com");
        Mockito.when(addPersonDTO.unpackVAT()).thenReturn(123456789);
        Mockito.when(addPersonDTO.unpackPhone()).thenReturn(961962963);
        Mockito.when(addPersonDTO.unpackStreet()).thenReturn("Rua das Irma's Beleza e do Primo Flavio");
        Mockito.when(addPersonDTO.unpackCity()).thenReturn("Gaya");
        Mockito.when(addPersonDTO.unpackZipCode()).thenReturn("1000");
        Mockito.when(addPersonDTO.unpackHouseNumber()).thenReturn(666);*/

        Mockito.when(personRepository.isPersonIDAlreadyRegistered(personID)).thenReturn(false);
        Mockito.when(personRepository.getByID(loggedUserID)).thenReturn(admin);
        Mockito.when(admin.getFamilyID()).thenReturn(familyID);

        assertDoesNotThrow(() -> addFamilyMemberService.addPerson(addPersonDTO));
    }

    @Test
    @DisplayName("Test failure where user is not admin")
    void addPersonFail_NotAdmin() {

        Mockito.doThrow(UserIsNotAdminException.class).when(familyRepository).verifyAdmin(loggedUserID);

        assertThrows(UserIsNotAdminException.class, () -> addFamilyMemberService.addPerson(addPersonDTO));
    }

    //TODO: make the other value objects tests
    @Test
    @DisplayName("Test failure where value object is invalid")
    void addPersonFail_invalidValueObject() {
        Mockito.doNothing().when(familyRepository).verifyAdmin(loggedUserID);
        assertThrows(InvalidNameException.class, () -> addFamilyMemberService.addPerson(addPersonDTOWrongName));
    }

    @Test
    @DisplayName("Test failure where getByID")
    void addPersonFail_getByID() {
        Mockito.when(personRepository.isPersonIDAlreadyRegistered(loggedUserID)).thenReturn(false);
        Mockito.doThrow(EmailNotRegisteredException.class).when(personRepository).getByID(loggedUserID);

        assertThrows(EmailNotRegisteredException.class, () -> addFamilyMemberService.addPerson(addPersonDTO));
    }


    @Test
    @DisplayName("Test failure where person already registered")
    void addPersonFail_personalreadyregistered() {
        Mockito.when(personRepository.isPersonIDAlreadyRegistered(loggedUserID)).thenReturn(true);

        assertThrows(PersonAlreadyRegisteredException.class, () -> addFamilyMemberService.addPerson(addPersonDTO));
    }


}