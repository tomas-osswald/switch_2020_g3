package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.PersonDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IPersonRepositoryJPA;
import switchtwentytwenty.project.domain.valueobject.*;

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

    final String VALIDNAME = "TonyZe";
    final String VALIDEMAIL = "tonyze@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final int VALIDPHONENUMBER = 916969696;
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final String VALIDADDRESSNUMBER = "69";
    final String VALIDBIRTHDATE = "01/03/1990";
    Name tonyZeName;
    BirthDate tonyZeBirthDate;
    PersonID tonyZeEmail;
    VATNumber tonyZeVat;
    PhoneNumber tonyZePhone;
    Address tonyZeAddress;
    FamilyID familyID;

    @BeforeEach
    void createValidPersonAttributtes() {
        tonyZeName = new Name(VALIDNAME);
        tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
        tonyZeEmail = new PersonID(VALIDEMAIL);
        tonyZeVat = new VATNumber(VALIDVATNUMBER);
        tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
        tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
        familyID = new FamilyID(VALIDEMAIL);
    }

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
    void addPerson() {
        PersonJPA personJPA = new PersonJPA()
    }

}