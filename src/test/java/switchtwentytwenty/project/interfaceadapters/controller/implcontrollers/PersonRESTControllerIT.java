package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.authentication.JWTokenUtil;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.PersonDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AddressJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IPersonRepositoryJPA;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInputDTOAssembler;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.implrepositories.PersonRepository;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IRemoveEmailService;
import switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.GetFamilyMemberProfileService;
import switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.PeopleOptionsService;
import switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.PersonOptionsService;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@SpringBootTest
class PersonRESTControllerIT {


    // Person Repository
    @Mock
    IPersonRepositoryJPA iPersonRepositoryJPA;

    @Autowired
    PersonDataDomainAssembler personDataDomainAssembler;

    // Get Family Member Profile Service
    @Autowired
    PersonDTODomainAssembler personDTODomainAssembler;

    @InjectMocks
    PersonRepository personRepository;

    @Autowired
    IRemoveEmailService removeEmailService;

    // PersonRESTController

    @Autowired
    IAddEmailService addEmailService;

    @Autowired
    PersonInputDTOAssembler personInputDTOAssembler;

    @Autowired
    PersonInputDTOAssembler profileInternalExternalAssembler;

    @Autowired
    PersonOptionsService personOptionsService;

    @Autowired
    IAddFamilyMemberService iAddFamilyMemberService;

    @Autowired
    JWTokenUtil jwTokenUtil;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


    @DisplayName("Get Profile - Controller - Integration Test - Success")
    @Test
    void integrationTestSuccessCase() {
        // Init Classes

        IPersonRepository personRepository = new PersonRepository(iPersonRepositoryJPA, personDataDomainAssembler);
        GetFamilyMemberProfileService getFamilyMemberProfileService = new GetFamilyMemberProfileService(personRepository, personDTODomainAssembler, jwTokenUtil);
        PeopleOptionsService peopleOptionsService = new PeopleOptionsService();
        PersonRESTController personRESTController = new PersonRESTController(peopleOptionsService, personOptionsService, profileInternalExternalAssembler, getFamilyMemberProfileService, iAddFamilyMemberService, personInputDTOAssembler, addEmailService, removeEmailService);


        // PersonID
        String personID = "tonyze@latinlover.com";
        String veryDurableJwt = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b255emVAbGF0aW5sb3Zlci5jb20iLCJyb2xlIjoiZmFtaWx5QWRtaW5pc3RyYXRvciIsImV4cCI6MTgwMDAwMTYyNDI5MjcxMiwiaWF0IjoxNjI0MjkyNzEyfQ.L0ib9t84dubgRWdtK_WCtHBMagp3QbDcNlcLLACPqSRFt3__sJ0T7ef5tGEARj-aRuGXZdxOhMpOG39BwS6KRg";

        // PersonJPA
        PersonJPA personJPA = new PersonJPA();



        // Person
        final String VALIDNAME = "TonyZe";
        final String VALIDEMAIL = "tonyze@latinlover.com";
        final int VALIDVATNUMBER = 999999999;
        final Integer VALIDPHONENUMBER = 916969696;
        final String VALIDSTREET = "Rua";
        final String VALIDCITY = "Ermesinde";
        final String VALIDZIPCODE = "4700-111";
        final String VALIDADDRESSNUMBER = "69";
        final String VALIDBIRTHDATE = "1/03/1990";

        personJPA.setId(new PersonIDJPA(VALIDEMAIL));
        personJPA.setAddress(new AddressJPA(null, VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER, personJPA));
        personJPA.setBirthdate(VALIDBIRTHDATE);
        personJPA.setEmails(new ArrayList<>());
        personJPA.setFamilyid(new FamilyIDJPA("@tonyze@latinlover.com"));
        personJPA.setName("Senhor");
        personJPA.setPhones(new ArrayList<>());
        personJPA.setVat(123456789);


        Name tonyZeName = new Name(VALIDNAME);
        BirthDate tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
        PersonID tonyZeEmail = new PersonID(VALIDEMAIL);
        VATNumber tonyZeVat = new VATNumber(VALIDVATNUMBER);
        PhoneNumber tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(tonyZePhone);
        Address tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
        FamilyID familyID = new FamilyID(VALIDEMAIL);

        //Person person = new Person(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID);

        // Mocking
        when(iPersonRepositoryJPA.existsById(any(PersonIDJPA.class))).thenReturn(true);
        when(iPersonRepositoryJPA.findById(any(PersonIDJPA.class))).thenReturn(Optional.of(personJPA));

        // Expected
        List<OutputEmailDTO> expectedEmails = Collections.emptyList();

        List<Integer> expectedPhones = new ArrayList<>();
        expectedPhones.add(VALIDPHONENUMBER);

        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO(VALIDEMAIL, VALIDNAME, VALIDBIRTHDATE, expectedEmails, expectedPhones, "999999999", VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER, VALIDEMAIL);

        Link expectedLink = linkTo(methodOn(PersonRESTController.class).personOptions(personID)).withSelfRel();
        Link expectedLink2 = linkTo(methodOn(FamilyRESTController.class).getFamilyOptions(familyID.getId())).withRel("Family Link");
        expectedOutputPersonDTO.add(expectedLink);
        expectedOutputPersonDTO.add(expectedLink2);


        ResponseEntity expectedResponse = new ResponseEntity(expectedOutputPersonDTO, HttpStatus.OK);

        // Result
        ResponseEntity resultResponse = personRESTController.getProfileInfo(personID,veryDurableJwt);

        // Assert
        assertEquals(expectedResponse.toString(), resultResponse.toString());
    }

    @DisplayName("Get Profile - Controller - Integration Test - Failure - EmailNotRegisteredException")
    @Test
    void integrationTestFailureCaseEmailNotRegistered() {
        // Init Classes
        GetFamilyMemberProfileService getFamilyMemberProfileService = new GetFamilyMemberProfileService(personRepository, personDTODomainAssembler, jwTokenUtil);
        PeopleOptionsService peopleOptionsService = new PeopleOptionsService();
        PersonRESTController personRESTController = new PersonRESTController(peopleOptionsService, personOptionsService, profileInternalExternalAssembler, getFamilyMemberProfileService, iAddFamilyMemberService, personInputDTOAssembler, addEmailService,removeEmailService);

        // PersonID
        String personID = "tonyze@latinlover.com";
        String veryDurableJwt = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b255emVAbGF0aW5sb3Zlci5jb20iLCJyb2xlIjoiZmFtaWx5QWRtaW5pc3RyYXRvciIsImV4cCI6MTgwMDAwMTYyNDI5MjcxMiwiaWF0IjoxNjI0MjkyNzEyfQ.L0ib9t84dubgRWdtK_WCtHBMagp3QbDcNlcLLACPqSRFt3__sJ0T7ef5tGEARj-aRuGXZdxOhMpOG39BwS6KRg";

        // Mocking
        when(iPersonRepositoryJPA.existsById(any(PersonIDJPA.class))).thenReturn(false);

        // Expected

        ResponseEntity expectedResponse = new ResponseEntity("Error: Email is not registered to any person", HttpStatus.UNPROCESSABLE_ENTITY);

        // Result
        ResponseEntity resultResponse = personRESTController.getProfileInfo(personID,veryDurableJwt);

        // Assert
        assertEquals(expectedResponse.toString(), resultResponse.toString());
    }
}