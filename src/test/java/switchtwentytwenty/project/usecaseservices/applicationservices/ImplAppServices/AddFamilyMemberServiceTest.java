package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.dto.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.exceptions.*;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddFamilyMemberServiceTest {

    @Mock
    IPersonRepository personRepository;

    @Mock
    IFamilyRepository familyRepository;

    @Mock
    PersonDTODomainAssembler personDTODomainAssembler;

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

    InputPersonDTO inputPersonDTO = new InputPersonDTO("tonyze@latinas.com", "TonyZe", "10/10/1999", 123456789, 961962963, "Rua das Irma's Beleza e do Primo Flavio", "Gaia", "100", "4400");
    PersonID loggedUserID = new PersonID("tonyze@latinas.com");
    PersonID personID = new PersonID("tonyze@latinas.com");
    FamilyID familyID = new FamilyID("tonyze@latinas.com");

    InputPersonDTO inputPersonDTOWrongName = new InputPersonDTO("tonyze@latinas.com", null, "10/10/1999", 123456789, 961962963, "Rua das Irma's Beleza e do Primo Flavio", "Gaia", "100", "4400");

    @Test
    @Tag("US101")
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
        Mockito.when(personDTODomainAssembler.toDomain(inputPersonDTO,familyID)).thenReturn(admin);
        Mockito.when(personRepository.add(admin)).thenReturn(admin);


        assertDoesNotThrow(() -> addFamilyMemberService.addPerson(inputPersonDTO, "tonyze@latinas.com"));
    }

    @Test
    @Tag("US101")
    @DisplayName("Test failure where user is not admin")
    void addPersonFail_NotAdmin() {

        Mockito.doThrow(UserIsNotAdminException.class).when(familyRepository).verifyAdmin(loggedUserID);

        assertThrows(UserIsNotAdminException.class, () -> addFamilyMemberService.addPerson(inputPersonDTO, "tonyze@latinas.com"));
    }


    @Test
    @DisplayName("Test fails when the person name is invalid and throws an InvalidNameException")
    void addPersonFail_invalidValueObject() {
        Mockito.doNothing().when(familyRepository).verifyAdmin(loggedUserID);
        assertThrows(InvalidNameException.class, () -> addFamilyMemberService.addPerson(inputPersonDTOWrongName, "tonyze@latinas.com"));
    }


}