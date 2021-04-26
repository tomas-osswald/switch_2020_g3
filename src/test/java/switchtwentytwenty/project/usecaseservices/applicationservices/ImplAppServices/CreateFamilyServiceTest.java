package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.dto.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.dto.PersonDTODomainAssembler;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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

    @BeforeEach
    void setup(){
        Mockito.when(inputPersonDTO.unpackEmail()).thenReturn("admin@email.com");
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Valid data doesn't throw exception")
    void createFamilyAndAddAdminTestValidData(){
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        Mockito.when(familyRepository.generateID()).thenReturn(familyID);
        Mockito.when(personDTODomainAssembler.toDomain(any(),any())).thenReturn(admin);
        Mockito.when(familyDTODomainAssembler.toDomain(any(),any(),any())).thenReturn(family);

        Mockito.doNothing().when(personRepository).add(admin);
        Mockito.doNothing().when(familyRepository).add(family);

        assertDoesNotThrow(() -> createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO));
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Invalid person name, should throw exception")
    void createFamilyAndAddAdminTestInvalidName(){
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        Mockito.when(familyRepository.generateID()).thenReturn(familyID);
        Mockito.when(personDTODomainAssembler.toDomain(any(),any())).thenThrow(InvalidNameException.class);
        Mockito.when(familyDTODomainAssembler.toDomain(any(),any(),any())).thenReturn(family);
        Mockito.doNothing().when(personRepository).add(admin);
        Mockito.doNothing().when(familyRepository).add(family);

        assertThrows(InvalidNameException.class,() -> createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO));
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Person already registered throw exception")
    void createFamilyAndAddAdminTestPersonAlreadyRegistered(){
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        Mockito.when(familyRepository.generateID()).thenReturn(familyID);
        Mockito.when(personDTODomainAssembler.toDomain(any(),any())).thenReturn(admin);
        Mockito.when(familyDTODomainAssembler.toDomain(any(),any(),any())).thenReturn(family);
        Mockito.doThrow(PersonAlreadyRegisteredException.class).when(personRepository).add(any());
        Mockito.doNothing().when(familyRepository).add(family);

        assertThrows(PersonAlreadyRegisteredException.class,() -> createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO));
    }
}