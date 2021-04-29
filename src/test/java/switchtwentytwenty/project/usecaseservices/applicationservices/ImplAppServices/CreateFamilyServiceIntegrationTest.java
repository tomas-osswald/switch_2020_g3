package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.domainjpa.PersonJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.FamilyDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.PersonDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IPersonRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.dto.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.interfaceadapters.ImplRepositories.FamilyRepository;
import switchtwentytwenty.project.interfaceadapters.ImplRepositories.PersonRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateFamilyServiceIntegrationTest {


    CreateFamilyService createFamilyService;

    @Mock
    FamilyDataDomainAssembler familyDataDomainAssembler;

    @Mock
    IFamilyRepositoryJPA familyRepositoryJPA;

    @InjectMocks
    FamilyRepository familyRepository;

    @Mock
    PersonDataDomainAssembler personDataDomainAssembler;

    @Mock
    IPersonRepositoryJPA iPersonRepositoryJPA;

    @InjectMocks
    PersonRepository personRepository;

    @Autowired
    PersonDTODomainAssembler personDTODomainAssembler;
    @Autowired
    FamilyDTODomainAssembler familyDTODomainAssembler;


    final String VALIDNAME = "JessicaMicaela";
    final String VALIDEMAIL = "jessicaMicaela@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final Integer VALIDPHONENUMBER = 916969696;
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final String VALIDADDRESSNUMBER = "69B";
    final String VALIDBIRTHDATE = "01/03/1990";
    InputPersonDTO inputPersonDTO = new InputPersonDTO(VALIDEMAIL, VALIDNAME, VALIDBIRTHDATE, VALIDVATNUMBER,
            VALIDPHONENUMBER, VALIDSTREET, VALIDCITY, VALIDADDRESSNUMBER, VALIDZIPCODE);
    //
    final String VALID_FAMILY_NAME = "Simpson";
    final String VALID_REGISTRATION_DATE = "01/03/1990";
    InputFamilyDTO inputFamilyDTO = new InputFamilyDTO(VALID_FAMILY_NAME, VALID_REGISTRATION_DATE);


    @Test
    @Tag("US010")
    void createFamilyAndAddAdminValidData() {
        // Arrange FamilyRepository
        when(familyRepositoryJPA.findById(any(FamilyIDJPA.class))).thenReturn(Optional.empty());
        when(familyDataDomainAssembler.toData(any(Family.class))).thenReturn(new FamilyJPA());
        when(familyRepositoryJPA.save(any(FamilyJPA.class))).thenReturn(new FamilyJPA(new FamilyIDJPA(VALIDEMAIL), "Silva", "12/12/1999", new PersonIDJPA(VALIDEMAIL)));
        when(familyDataDomainAssembler.toDomain(any(FamilyJPA.class))).thenReturn(new Family(new FamilyID(VALIDEMAIL), new FamilyName("Silva"), new RegistrationDate("12/12/1999"), new PersonID(VALIDEMAIL)));
        // Arrange PersonRepository
        when(iPersonRepositoryJPA.findById(any(PersonIDJPA.class))).thenReturn(Optional.empty());
        when(personDataDomainAssembler.toData(any(Person.class))).thenReturn(new PersonJPA());
        when(iPersonRepositoryJPA.save(any(PersonJPA.class))).thenReturn(new PersonJPA(new PersonIDJPA(VALIDEMAIL), "TonyZe", "12/12/199", 123456789, new FamilyIDJPA(VALIDEMAIL)));
        when(personDataDomainAssembler.toDomain(any(PersonJPA.class))).thenReturn(new Person(new Name("Rui"), new BirthDate("12/12/1999"), new PersonID("email@here.com"), new VATNumber(123456789), new PhoneNumber(987654321), new Address("Rua", "Covilhã", "6200-000", "1"), new FamilyID("email@here.com")));

        createFamilyService = new CreateFamilyService(personRepository, familyRepository, personDTODomainAssembler, familyDTODomainAssembler);

        assertDoesNotThrow(() -> createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO));
    }

    @Test
    @Tag("US010")
    void createFamilyAndAddAdminInvalidNameThrowsException() {
        // Arrange FamilyRepository
        when(familyRepositoryJPA.findById(any(FamilyIDJPA.class))).thenReturn(Optional.empty());
        when(familyDataDomainAssembler.toData(any(Family.class))).thenReturn(new FamilyJPA());
        when(familyRepositoryJPA.save(any(FamilyJPA.class))).thenReturn(new FamilyJPA());
        // Arrange PersonRepository
        when(iPersonRepositoryJPA.findById(any(PersonIDJPA.class))).thenReturn(Optional.empty());
        when(personDataDomainAssembler.toData(any(Person.class))).thenReturn(new PersonJPA());
        when(iPersonRepositoryJPA.save(any(PersonJPA.class))).thenReturn(new PersonJPA());

        createFamilyService = new CreateFamilyService(personRepository, familyRepository, personDTODomainAssembler, familyDTODomainAssembler);

        InputPersonDTO invalidInputPersonDTO = new InputPersonDTO(VALIDEMAIL, "", VALIDBIRTHDATE, VALIDVATNUMBER,
                VALIDPHONENUMBER, VALIDSTREET, VALIDCITY, VALIDADDRESSNUMBER, VALIDZIPCODE);

        assertThrows(InvalidNameException.class, () -> createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, invalidInputPersonDTO));
    }

}