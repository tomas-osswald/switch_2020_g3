package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.RelationInputDTOAssembler;
import switchtwentytwenty.project.interfaceadapters.implrepositories.FamilyRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChangeRelationServiceIT {

    ChangeRelationService changeRelationService;


    @Mock
    IFamilyRepositoryJPA iFamilyRepositoryJPA;

    @InjectMocks
    FamilyRepository familyRepository;

    @Mock
    FamilyDTODomainAssembler familyDTODomainAssembler;

    @Autowired
    RelationInputDTOAssembler relationInputDTOAssembler;

    @DisplayName( "Change relation success")
    @Test
    void createRelationSuccessOne() {

        
    }
}