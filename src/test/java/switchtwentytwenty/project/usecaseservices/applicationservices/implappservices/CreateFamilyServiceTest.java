package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateFamilyServiceTest {

    @Mock
    IFamilyRepository familyRepository;

    @Mock
    IPersonRepository personRepository;

    @Mock
    PersonDTODomainAssembler personDTODomainAssembler;

    @Mock
    FamilyDTODomainAssembler familyDTODomainAssembler;

    @Mock
    Person admin;

    @Mock
    Family family;

    @Mock
    InputFamilyDTO inputFamilyDTO;

    @Mock
    InputPersonDTO inputPersonDTO;

    @InjectMocks
    CreateFamilyService createFamilyService;

    String familyName = "Silva";
    String familyID = "@admin@gmail.com";
    String adminID = "admin@gmail.com";
    String registrationDate = "12/5/1999";

    @BeforeEach
    void setup(){
        Mockito.when(inputPersonDTO.unpackEmail()).thenReturn("admin@email.com");
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Valid data doesn't throw exception")
    void createFamilyAndAddAdminTestValidData(){
        Mockito.when(personDTODomainAssembler.toDomain(any(InputPersonDTO.class),any(FamilyID.class))).thenReturn(admin);
        Mockito.when(familyDTODomainAssembler.toDomain(any(InputFamilyDTO.class),any(FamilyID.class),any(PersonID.class))).thenReturn(family);

        Mockito.when(personRepository.add(admin)).thenReturn(admin);
        Mockito.when(familyRepository.add(family)).thenReturn(family);

        Mockito.when(familyDTODomainAssembler.toDTO(any(Family.class))).thenReturn(new OutputFamilyDTO(familyName,familyID,adminID,registrationDate));

        OutputFamilyDTO outputFamilyDTO = createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO);
        Assertions.assertNotNull(outputFamilyDTO);
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Invalid person name, should throw exception")
    void createFamilyAndAddAdminTestInvalidName(){
        Mockito.when(personDTODomainAssembler.toDomain(any(InputPersonDTO.class),any(FamilyID.class))).thenThrow(InvalidNameException.class);
        Mockito.when(familyDTODomainAssembler.toDomain(any(InputFamilyDTO.class),any(FamilyID.class),any(PersonID.class))).thenReturn(family);
        Mockito.when(personRepository.add(admin)).thenReturn(admin);
        Mockito.when(familyRepository.add(family)).thenReturn(family);
        Mockito.when(familyDTODomainAssembler.toDTO(any(Family.class))).thenReturn(new OutputFamilyDTO(familyName,familyID,adminID,registrationDate));

        assertThrows(InvalidNameException.class,() -> createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO));
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Person already registered throw exception")
    void createFamilyAndAddAdminTestPersonAlreadyRegistered(){
        Mockito.when(personDTODomainAssembler.toDomain(any(InputPersonDTO.class),any(FamilyID.class))).thenReturn(admin);
        Mockito.when(familyDTODomainAssembler.toDomain(any(InputFamilyDTO.class),any(FamilyID.class),any(PersonID.class))).thenReturn(family);
        Mockito.doThrow(PersonAlreadyRegisteredException.class).when(personRepository).add(any());
        Mockito.when(familyRepository.add(family)).thenReturn(family);
        Mockito.when(familyDTODomainAssembler.toDTO(any(Family.class))).thenReturn(new OutputFamilyDTO(familyName,familyID,adminID,registrationDate));

        assertThrows(PersonAlreadyRegisteredException.class,() -> createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO));
    }
}