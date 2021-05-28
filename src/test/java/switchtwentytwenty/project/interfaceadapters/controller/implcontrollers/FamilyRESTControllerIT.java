package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.FamilyDataDomainAssembler;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.PersonDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.*;
import switchtwentytwenty.project.datamodel.repositoryjpa.ICategoryRepositoryJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IPersonRepositoryJPA;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyInputDTOAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInputDTOAssembler;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.FamilyMemberAndRelationsListDTO;
import switchtwentytwenty.project.dto.family.OutputPersonRelationDTO;
import switchtwentytwenty.project.dto.person.FamilyMemberAndRelationsDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IFamilyRESTController;
import switchtwentytwenty.project.interfaceadapters.implrepositories.CategoryRepository;
import switchtwentytwenty.project.interfaceadapters.implrepositories.FamilyRepository;
import switchtwentytwenty.project.interfaceadapters.implrepositories.PersonRepository;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.*;
import switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.GetFamilyMembersAndRelationshipService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@SpringBootTest
@RunWith(SpringRunner.class)
class FamilyRESTControllerIT {
    AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("tony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");
    AddFamilyAndSetAdminDTO invaliddto = new AddFamilyAndSetAdminDTO("tonyemail.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

    // Category repo

    @Mock
    ICategoryRepositoryJPA categoryRepositoryJPA;

    @InjectMocks
    CategoryRepository categoryRepository;

    // Family Repository

    @Mock
    IFamilyRepositoryJPA iFamilyRepositoryJPA;

    @Mock
    FamilyDataDomainAssembler familyDataDomainAssembler;

    @InjectMocks
    FamilyRepository familyRepository;

    // Person Repository

    @Mock
    IPersonRepositoryJPA iPersonRepositoryJPA;

    @Mock
    PersonDataDomainAssembler personDataDomainAssembler;

    @InjectMocks
    PersonRepository personRepository;

    // Autowired

    @Autowired
    IFamilyRESTController familyRESTController;

    @Autowired
    ICreateFamilyService iCreateFamilyService;

    @Autowired
    FamilyInputDTOAssembler familyAssembler;

    @Autowired
    PersonInputDTOAssembler personAssembler;

    @Autowired
    IGetFamilyMembersAndRelationshipService getFamilyMembersAndRelationshipService;

    @Autowired
    IFamiliesOptionsService familiesOptionsService;

    @Autowired
    IFamilyOptionsService familyOptionsService;

    @Autowired
    ICreateRelationService createRelationService;

    @Autowired
    IGetCustomCategoriesService getCustomCategoriesService;

    @Autowired
    FamilyDTODomainAssembler familyDTODomainAssembler;

    //private AutoCloseable closeable;

   /* @BeforeEach
    void setUp() {
        // We can create mock based on the Interface or a Class
        // templateEngine = mock(TemplateEngine.class);

        // init mock with annotations
        //MockitoAnnotations.initMocks(this);

        // just another version of initilization of mocks with annotation
        // pay attention to tear down method - we have to call close method
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }*/


    @Test
    void testCreateFamilyAndSetAdmin() {
        ResponseEntity expected = new ResponseEntity("Error: This Email is not valid", HttpStatus.UNPROCESSABLE_ENTITY);
        ResponseEntity result = familyRESTController.createFamilyAndSetAdmin(invaliddto);

        assertEquals(expected, result);
    }

    @Test
    void familiesOptionsTest() {
        OptionsDTO optionsDTO = new OptionsDTO();
        Link link = linkTo(methodOn(FamilyRESTController.class).familiesOptions()).withSelfRel();
        Link linkToAddFamily = linkTo(methodOn(FamilyRESTController.class).createFamilyAndSetAdmin(new AddFamilyAndSetAdminDTO())).withRel("Add new Family");

        optionsDTO.add(link);
        optionsDTO.add(linkToAddFamily);

        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "POST, OPTIONS");

        ResponseEntity expected = new ResponseEntity<>(optionsDTO, header, HttpStatus.OK);
        ResponseEntity result = familyRESTController.familiesOptions();

        OptionsDTO resultDTO = (OptionsDTO) result.getBody();
        OptionsDTO expectedDTO = (OptionsDTO) expected.getBody();

        assertEquals(resultDTO.getLinks(), expectedDTO.getLinks());
        assertEquals(result.getHeaders(), expected.getHeaders());
        assertEquals(result.getStatusCode(), expected.getStatusCode());
    }


  /*  @Test
    void addRelationTest() {
        CreateRelationDTO createRelationDTO = new CreateRelationDTO();

        assertThrows(UnsupportedOperationException.class, () -> familyRESTController.createRelation(createRelationDTO, "@tonize@gmail.com"));
    }*/

    @Test
    void getFamilyNameTest() {
        String familyName = "Silva";

        assertThrows(UnsupportedOperationException.class, () -> familyRESTController.getFamily(familyName));
    }

    @Test
    void getCategoriesSuccess() {
        String familyID = "@tonize@gmail.com";

        OutputCategoryTreeDTO expectedOutputCategoryTreeDTO = new OutputCategoryTreeDTO();
        Link expectedLink = linkTo(methodOn(FamilyRESTController.class).getCategories(familyID)).withSelfRel();
        expectedOutputCategoryTreeDTO.add(expectedLink);
        ResponseEntity expected = new ResponseEntity(expectedOutputCategoryTreeDTO, HttpStatus.OK);

        when(categoryRepositoryJPA.findAllByFamilyIDJPA(any(FamilyIDJPA.class))).thenReturn(new ArrayList<CategoryJPA>());
        when(categoryRepositoryJPA.findAllByFamilyIDJPAIsNull()).thenReturn(new ArrayList<CategoryJPA>());

        ResponseEntity result = familyRESTController.getCategories(familyID);

        assertEquals(expected, result);
    }

    @DisplayName("Family Members And Relations IT - Success")
    @Test
    void getFamilyMembersAndRelationsITSuccess() {
        IGetFamilyMembersAndRelationshipService iGetFamilyMembersAndRelationshipService = new GetFamilyMembersAndRelationshipService(familyDTODomainAssembler, personRepository, familyRepository);
        FamilyRESTController familyRESTController = new FamilyRESTController(iCreateFamilyService, familyAssembler, personAssembler, iGetFamilyMembersAndRelationshipService, familiesOptionsService, familyOptionsService, createRelationService, getCustomCategoriesService);

        // Mocking
        // Person Repo
        when(personDataDomainAssembler.createFamilyID(any(FamilyID.class))).thenReturn(new FamilyIDJPA("@tonyze@email.com"));

        List<PersonJPA> personJPAList = new ArrayList();
        personJPAList.add(new PersonJPA(new PersonIDJPA("tony@email.com"), "tony", "19/02/1992", 999999999, new FamilyIDJPA("@tonyze@email.com")));
        personJPAList.add(new PersonJPA(new PersonIDJPA("katia@email.com"), "katia", "12/03/1999", 999999998, new FamilyIDJPA("@tonyze@email.com")));

        when(iPersonRepositoryJPA.findAllByFamilyid(any(FamilyIDJPA.class))).thenReturn(personJPAList);

        when(personDataDomainAssembler.createPersonID(any(PersonJPA.class))).thenReturn(new PersonID("tony@email.com")).thenReturn(new PersonID("katia@email.com"));
        when(personDataDomainAssembler.createName(any(PersonJPA.class))).thenReturn(new Name("tony")).thenReturn(new Name("katia"));
        when(personDataDomainAssembler.createBirthDate(any(PersonJPA.class))).thenReturn(new BirthDate("19/02/1992")).thenReturn(new BirthDate("12/03/1999"));
        when(personDataDomainAssembler.createEmailAdressList(any(PersonJPA.class))).thenReturn(new ArrayList<>()).thenReturn(new ArrayList<>());
        when(personDataDomainAssembler.createVATNumber(any(PersonJPA.class))).thenReturn(new VATNumber(999999999)).thenReturn(new VATNumber(999999998));
        when(personDataDomainAssembler.createPhoneNumberList(any(PersonJPA.class))).thenReturn(new ArrayList<>()).thenReturn(new ArrayList<>());
        when(personDataDomainAssembler.createAddress(any(PersonJPA.class))).thenReturn(new Address("Rua", "Covilhã", "0000-000", "1")).thenReturn(new Address("Rua", "Covilhã", "0000-000", "1"));
        when(personDataDomainAssembler.createFamilyID(any(PersonJPA.class))).thenReturn(new FamilyID("@tonyze@email.com")).thenReturn(new FamilyID("@tonyze@email.com"));

        // Family Repo
        FamilyJPA familyJPA = new FamilyJPA(new FamilyIDJPA("@tonyze@email.com"), "Zés", "27/05/2021", new PersonIDJPA("tonyze@email.com"));

        Optional<FamilyJPA> optionalFamilyJPA = Optional.of(familyJPA);

        when(iFamilyRepositoryJPA.findById(any(FamilyIDJPA.class))).thenReturn(optionalFamilyJPA);

        when(familyDataDomainAssembler.createFamilyID(any(FamilyJPA.class))).thenReturn(new FamilyID("@tonyze@email.com"));
        when(familyDataDomainAssembler.createFamilyName(any(FamilyJPA.class))).thenReturn(new FamilyName("Zés"));
        when(familyDataDomainAssembler.createRegistrationDate(any(FamilyJPA.class))).thenReturn(new RegistrationDate("27/05/2021"));
        when(familyDataDomainAssembler.createAdminID(any(FamilyJPA.class))).thenReturn(new PersonID("tonyze@email.com"));

        List<Relation> relationList = new ArrayList<>();
        Relation relation = new Relation(new PersonID("tony@email.com"), new PersonID("katia@email.com"), new RelationDesignation("Marido"));
        relationList.add(relation);

        when(familyDataDomainAssembler.createRelationList(any(FamilyJPA.class))).thenReturn(relationList);

        // Expected
        FamilyMemberAndRelationsListDTO familyMemberAndRelationsListDTO = new FamilyMemberAndRelationsListDTO();
        Integer relationID = Objects.hash(new PersonID("tony@email.com"), new PersonID("katia@email.com"));

        List<OutputPersonRelationDTO> relations = new ArrayList<>();
        relations.add(new OutputPersonRelationDTO("tony@email.com", "katia@email.com", "Marido", relationID.toString()));

        FamilyMemberAndRelationsDTO memberOne = new FamilyMemberAndRelationsDTO("tony", "tony@email.com", relations);
        Link linkToOne = linkTo(methodOn(PersonRESTController.class).getProfileInfo("tony@email.com")).withSelfRel();
        memberOne.add(linkToOne);

        FamilyMemberAndRelationsDTO memberTwo = new FamilyMemberAndRelationsDTO("katia", "katia@email.com", Collections.emptyList());
        Link linkToTwo = linkTo(methodOn(PersonRESTController.class).getProfileInfo("katia@email.com")).withSelfRel();
        memberTwo.add(linkToTwo);

        familyMemberAndRelationsListDTO.addDTO(memberOne);
        familyMemberAndRelationsListDTO.addDTO(memberTwo);

        Link link = linkTo(methodOn(FamilyRESTController.class).getFamilyMembersAndRelations("@tonyze@email.com")).withSelfRel();
        familyMemberAndRelationsListDTO.add(link);

        ResponseEntity expected = new ResponseEntity(familyMemberAndRelationsListDTO, HttpStatus.OK);

        String familyID = "@tonyze@email.com";

        ResponseEntity result = familyRESTController.getFamilyMembersAndRelations(familyID);

        assertEquals(expected, result);
    }

    @DisplayName("Family Members And Relations IT - Failure - Family Does not Exist")
    @Test
    void getFamilyMembersAndRelationsITFailure() {
        IGetFamilyMembersAndRelationshipService iGetFamilyMembersAndRelationshipService = new GetFamilyMembersAndRelationshipService(familyDTODomainAssembler, personRepository, familyRepository);
        FamilyRESTController familyRESTController = new FamilyRESTController(iCreateFamilyService, familyAssembler, personAssembler, iGetFamilyMembersAndRelationshipService, familiesOptionsService, familyOptionsService, createRelationService, getCustomCategoriesService);

        when(iFamilyRepositoryJPA.findById(any(FamilyIDJPA.class))).thenReturn(Optional.empty());

        ResponseEntity expected = new ResponseEntity("Error: Family does not exists", HttpStatus.BAD_REQUEST);

        String familyID = "@tonyze@email.com";

        ResponseEntity result = familyRESTController.getFamilyMembersAndRelations(familyID);

        assertEquals(expected, result);
    }
}