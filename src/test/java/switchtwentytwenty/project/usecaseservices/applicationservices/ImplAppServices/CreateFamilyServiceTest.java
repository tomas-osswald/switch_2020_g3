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
import switchtwentytwenty.project.dto.AddPersonFormDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
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
    Person admin;

    @Mock
    Family family;

    @Mock
    CreateFamilyDTO createFamilyDTO;

    @Mock
    AddPersonFormDTO addPersonFormDTO;

    @InjectMocks
    CreateFamilyService createFamilyService;

    @BeforeEach
    void setup(){
        Mockito.when(addPersonFormDTO.unpackEmail()).thenReturn("admin@email.com");
        Mockito.when(addPersonFormDTO.unpackName()).thenReturn("Admin");
        Mockito.when(addPersonFormDTO.unpackBirthDate()).thenReturn("01/03/2021");
        Mockito.when(addPersonFormDTO.unpackVAT()).thenReturn(999999999);
        Mockito.when(addPersonFormDTO.unpackPhone()).thenReturn(999999999);
        Mockito.when(addPersonFormDTO.unpackStreet()).thenReturn("Rua da Amargura");
        Mockito.when(addPersonFormDTO.unpackCity()).thenReturn("Porto");
        Mockito.when(addPersonFormDTO.unpackZipCode()).thenReturn("4405-586");
        Mockito.when(addPersonFormDTO.unpackHouseNumber()).thenReturn("14");
        Mockito.when(createFamilyDTO.unpackFamilyName()).thenReturn("Silva");

    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Valid data doesn't throw exception")
    void createFamilyAndAddAdminTestValidData(){
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        Mockito.when(familyRepository.generateID()).thenReturn(familyID);
        Mockito.doNothing().when(personRepository).add(admin);
        Mockito.doNothing().when(familyRepository).add(family);

        assertDoesNotThrow(() -> createFamilyService.createFamilyAndAddAdmin(createFamilyDTO,addPersonFormDTO));
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Invalid person name, should throw exception")
    void createFamilyAndAddAdminTestInvalidName(){
        Mockito.when(addPersonFormDTO.unpackName()).thenReturn("");
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        Mockito.when(familyRepository.generateID()).thenReturn(familyID);
        Mockito.doNothing().when(personRepository).add(admin);
        Mockito.doNothing().when(familyRepository).add(family);

        assertThrows(InvalidNameException.class,() -> createFamilyService.createFamilyAndAddAdmin(createFamilyDTO,addPersonFormDTO));
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Person already registered throw exception")
    void createFamilyAndAddAdminTestPersonAlreadyRegistered(){
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        Mockito.when(familyRepository.generateID()).thenReturn(familyID);
        Mockito.doThrow(PersonAlreadyRegisteredException.class).when(personRepository).add(any());
        Mockito.doNothing().when(familyRepository).add(family);

        assertThrows(PersonAlreadyRegisteredException.class,() -> createFamilyService.createFamilyAndAddAdmin(createFamilyDTO,addPersonFormDTO));
    }
}