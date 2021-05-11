package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.PersonDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IPersonRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonRepositoryTest {

    @Mock
    IPersonRepositoryJPA iPersonRepositoryJPA;

    @Mock
    PersonDataDomainAssembler personDataDomainAssembler;

    @InjectMocks
    PersonRepository personRepository;

    @Captor
    ArgumentCaptor<PersonIDJPA> captorPersonIDJPA;

    // Person
    String VALIDNAME = "TonyZe";
    String VALIDEMAIL = "tonyze@latinlover.pt";
    int VALIDVATNUMBER = 999999999;
    int VALIDPHONENUMBER = 916969696;
    String VALIDSTREET = "Rua";
    String VALIDCITY = "Ermesinde";
    String VALIDZIPCODE = "4700-111";
    String VALIDADDRESSNUMBER = "69";
    String VALIDBIRTHDATE = "01/03/1990";

    Name tonyZeName= new Name(VALIDNAME);
    BirthDate tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
    PersonID tonyZeEmail = new PersonID(VALIDEMAIL);
    VATNumber tonyZeVat = new VATNumber(VALIDVATNUMBER);
    PhoneNumber tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
    Address tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
    FamilyID familyID = new FamilyID(VALIDEMAIL);

    Person person = new Person(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID);

    private AutoCloseable closeble;

    @BeforeEach
    void setUp() {
        closeble = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeble.close();
    }

    /* UNIT TESTS */

    @Test
    void getByID() {

    }

    @Test
    void addPersonDoesNotThrow() {
        PersonJPA personJPA = new PersonJPA();

        when(personDataDomainAssembler.toData(any(Person.class))).thenReturn(personJPA);
        when(iPersonRepositoryJPA.save(any(PersonJPA.class))).thenReturn(personJPA);

        assertDoesNotThrow(() -> personRepository.add(person));
    }

    @Test
    void addPersonDoesThrow() {
        PersonJPA personJPA = new PersonJPA();

        when(iPersonRepositoryJPA.findById(any(PersonIDJPA.class))).thenReturn(Optional.of(new PersonJPA()));

        assertThrows(IllegalStateException.class, () -> personRepository.add(person));
    }

}