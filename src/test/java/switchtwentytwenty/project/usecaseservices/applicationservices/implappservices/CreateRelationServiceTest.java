package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.family.CreateRelationDTO;
import switchtwentytwenty.project.dto.family.InputRelationDTO;
import switchtwentytwenty.project.dto.family.OutputRelationDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
class CreateRelationServiceTest {

    @Mock
    IFamilyRepository familyRepository;
    @Mock
    FamilyDTODomainAssembler familyDTODomainAssembler;
    @Mock
    Relation relation;
    @Mock
    Family family;
    @Mock
    Family savedFamily;
    @Mock
    Relation savedRelation;
    @Mock
    OutputRelationDTO outputRelationDTO;


    @InjectMocks
    CreateRelationService createRelationService;


    String personIDOneString = "tonyze@latinlover.com";
    PersonID personIDOne = new PersonID(personIDOneString);
    String personIDTwoString = "mariaze@latinlover.com";
    PersonID personIDTwo = new PersonID(personIDTwoString);
    String designationString = "amante";
    RelationDesignation relationDesignation = new RelationDesignation(designationString);
    String familyIDString = "@tonyze@latinlover.com";
    FamilyID familyID = new FamilyID(familyIDString);
    InputRelationDTO inputRelationDTO = new InputRelationDTO(personIDOneString, personIDTwoString, designationString, familyIDString);
    RelationID relationID = new RelationID(123456);

    /*
    @DisplayName("Create relation service: Successfully add relation to family")
    @Test
    void createRelationSuccess(){

        Mockito.when(familyDTODomainAssembler.personIDOneToDomain(any(InputRelationDTO.class))).thenReturn(personIDOne);
        Mockito.when(familyDTODomainAssembler.personIDTwoToDomain(any(InputRelationDTO.class))).thenReturn(personIDTwo);
        Mockito.when(familyDTODomainAssembler.relationDesignationToDomain(any(InputRelationDTO.class))).thenReturn(relationDesignation);
        Mockito.when(familyDTODomainAssembler.familyIDToDomain(any(InputRelationDTO.class))).thenReturn(familyID);
        Mockito.when(familyRepository.getByID(any(FamilyID.class))).thenReturn(family);
        Mockito.doNothing().when(family).addRelation(any(Relation.class));
        Mockito.when(familyRepository.add(any(Family.class))).thenReturn(savedFamily);
        Mockito.when(relation.getId()).thenReturn(relationID);
        Mockito.when(family.getRelationByID(any(RelationID.class))).thenReturn(savedRelation);
        Mockito.when(familyDTODomainAssembler.toDTO(savedRelation)).thenReturn(outputRelationDTO);

        OutputRelationDTO expected = outputRelationDTO;
        OutputRelationDTO result = createRelationService.createRelation(inputRelationDTO);

        assertEquals(expected, result);
    }
    */
}