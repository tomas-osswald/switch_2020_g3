package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;


import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.FamilyDataDomainAssembler;
import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.Relation;
import switchtwentytwenty.project.domain.valueobject.RelationID;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.family.InputRelationDTO;
import switchtwentytwenty.project.dto.family.OutputRelationDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@Disabled
@SpringBootTest
@RunWith(SpringRunner.class)
class CreateRelationServiceIT {
    CreateRelationService createRelationService;

    @Mock
    FamilyDataDomainAssembler familyDataDomainAssembler;

    @Mock
    IFamilyRepositoryJPA familyRepositoryJPA;

    @InjectMocks
    IFamilyRepository familyRepository;

    @Autowired
    FamilyDTODomainAssembler familyDTODomainAssembler;


    String personIDOne = "tonyze@latinlover.com";
    String personIDTwo = "mariaze@latinlover.com";
    String designation = "amante";
    String familyID = "@tonyze@latinlover.com";
    InputRelationDTO inputRelationDTO = new InputRelationDTO(personIDOne, personIDTwo, designation, familyID);

    @DisplayName("Successfully create a relation using valid data.")
    @Test
    void createRelationServiceSuccess() {

    }
}
