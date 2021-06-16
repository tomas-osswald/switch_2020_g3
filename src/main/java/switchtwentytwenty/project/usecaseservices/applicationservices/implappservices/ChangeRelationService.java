package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.Relation;
import switchtwentytwenty.project.domain.valueobject.RelationDesignation;
import switchtwentytwenty.project.domain.valueobject.RelationID;
import switchtwentytwenty.project.dto.assemblers.implassemblers.RelationInputDTOAssembler;
import switchtwentytwenty.project.dto.family.InputChangeRelationDTO;
import switchtwentytwenty.project.dto.family.OutputRelationDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IChangeRelationService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

@Service
@NoArgsConstructor
public class ChangeRelationService implements IChangeRelationService {

    private IFamilyRepository familyRepository;

    @Autowired
    public ChangeRelationService(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }


    public OutputRelationDTO changeRelation(InputChangeRelationDTO inputChangeRelationDTO){

        //create VO
        FamilyID familyID = new FamilyID(inputChangeRelationDTO.getFamilyID());

        RelationID newRelationID = new RelationID(Integer.parseInt(inputChangeRelationDTO.getRelationID()));
        RelationDesignation newRelationDesignation = new RelationDesignation(inputChangeRelationDTO.getNewDesignation());

        Family family = familyRepository.getByID(familyID);
        family.changeRelation(newRelationID, newRelationDesignation );

        return new OutputRelationDTO();
    }



}