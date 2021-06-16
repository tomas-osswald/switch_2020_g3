package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.Relation;
import switchtwentytwenty.project.domain.valueobject.RelationDesignation;
import switchtwentytwenty.project.domain.valueobject.RelationID;
import switchtwentytwenty.project.dto.assemblers.implassemblers.RelationInputDTOAssembler;
import switchtwentytwenty.project.dto.family.ChangeRelationDTO;
import switchtwentytwenty.project.dto.family.InputChangeRelationDTO;
import switchtwentytwenty.project.dto.family.OutputRelationDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ChangeRelationServiceTest {

    @Mock
    IFamilyRepository familyRepository;

    @Mock
    RelationInputDTOAssembler relationInputDTOAssembler;

    @Mock
    Family family;

    @Mock
    Relation newRelation;

    @Mock
    OutputRelationDTO outputRelationDTO;

    @InjectMocks
    ChangeRelationService changeRelationService;

    String relationID = "4";
    String designationString = "BFF";
    String familyIDString = "@tonyze@latinlover.com";
    FamilyID familyID = new FamilyID(familyIDString);
    ChangeRelationDTO changeRelationDTO = new ChangeRelationDTO(relationID, designationString);
    InputChangeRelationDTO inputChangeRelationDTO = new InputChangeRelationDTO(changeRelationDTO, familyID.toString());

    @DisplayName("Change relation service: success when changing a existent relation")
    @Test
    void changeRelationSuccess() {

        Mockito.when(relationInputDTOAssembler.toInputChangeRelationDTO(any(ChangeRelationDTO.class), any(String.class))).thenReturn(new InputChangeRelationDTO(changeRelationDTO,familyID.toString()));
        Mockito.when(familyRepository.getByID(any(FamilyID.class))).thenReturn(family);
        Mockito.when(family.changeRelation(any(RelationID.class), any(RelationDesignation.class))).thenReturn();

        assertDoesNotThrow(() -> changeRelationService.changeRelation(inputChangeRelationDTO));

    }

    @DisplayName("Change relation service: failure when changing a non-existent relation")
    @Test
    void changeRelationFailure() {

        Mockito.when(relationInputDTOAssembler.toInputChangeRelationDTO(any(ChangeRelationDTO.class), any(String.class))).thenReturn(new InputChangeRelationDTO(changeRelationDTO,familyID.toString()));
        Mockito.when(familyRepository.getByID(any(FamilyID.class))).thenReturn(family);


        assertDoesNotThrow(() -> changeRelationService.changeRelation(inputChangeRelationDTO));

    }

}