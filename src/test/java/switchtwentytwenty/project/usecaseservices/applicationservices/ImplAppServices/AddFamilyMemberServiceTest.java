package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddFamilyMemberServiceTest {

    @Mock
    IPersonRepository personRepository;

    @Mock
    IFamilyRepository familyRepository;

    @Mock
    AddPersonDTO addPersonDTO;

    @Mock
    PersonID personID;

    @Mock
    PersonID loggedUserID;

    final String VALIDNAME = "TonyZe";
    final String VALIDEMAIL = "tonyze@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final Integer VALIDPHONENUMBER = 916969696;
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final int VALIDADDRESSNUMBER = 69;
    final String VALIDBIRTHDATE = "01/03/1990";

    Name tonyZeName = new Name(VALIDNAME);
    BirthDate tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
    PersonID tonyZeEmail = new PersonID(VALIDEMAIL);
    VATNumber tonyZeVat = new VATNumber(VALIDVATNUMBER);
    PhoneNumber tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
    Address tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
    FamilyID familyID = new FamilyID(UUID.randomUUID());

    @Mock
    Person admin = new Person(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID);
    /*@Mock
    FamilyID familyID;*/

    @InjectMocks
    AddFamilyMemberService addFamilyMemberService;

    @Test
    void addPersonSuccess() {

        Mockito.when(addPersonDTO.unpackUserID()).thenReturn("tonyze@latinas.com");
        Mockito.doNothing().when(familyRepository).verifyAdmin(loggedUserID);
        Mockito.when(addPersonDTO.unpackName()).thenReturn("tonyze@latinas.com");
        Mockito.when(addPersonDTO.unpackBirthDate()).thenReturn("10/10/1999");
        Mockito.when(addPersonDTO.unpackEmail()).thenReturn("tonyze@latinas.com");
        Mockito.when(addPersonDTO.unpackVAT()).thenReturn(123456789);
        Mockito.when(addPersonDTO.unpackPhone()).thenReturn(961962963);
        Mockito.when(addPersonDTO.unpackStreet()).thenReturn("Rua das Irmas Beleza e do Primo Flavio");
        Mockito.when(addPersonDTO.unpackCity()).thenReturn("Gaya");
        Mockito.when(addPersonDTO.unpackZipCode()).thenReturn("1000");
        Mockito.when(addPersonDTO.unpackHouseNumber()).thenReturn(666);

        Mockito.when(personRepository.isPersonIDAlreadyRegistered(personID)).thenReturn(false);
        Mockito.doReturn(admin).when(personRepository).getByID(loggedUserID);
//        Mockito.when(admin.getFamilyID()).thenReturn(familyID);
        assertDoesNotThrow(() -> addFamilyMemberService.addPerson(addPersonDTO));
    }
}