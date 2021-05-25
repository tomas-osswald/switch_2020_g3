package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.RelationDTODomainAssembler;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.relation.InputRelationDTO;
import switchtwentytwenty.project.dto.relation.OutputRelationDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateRelationService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

@Service
public class CreateRelationService implements ICreateRelationService {

    private IFamilyRepository familyRepository;
    private RelationDTODomainAssembler relationDTODomainAssembler;
    private FamilyDTODomainAssembler familyDTODomainAssembler;

    @Autowired
    public CreateRelationService(IFamilyRepository familyRepository, RelationDTODomainAssembler relationDTODomainAssembler) {
        this.familyRepository = familyRepository;
        this.relationDTODomainAssembler = relationDTODomainAssembler;
    }

    @Override
    public OutputRelationDTO createRelation(InputRelationDTO inputRelationDTO){

        //creating Domain valueobjects
        PersonID personIDOne = relationDTODomainAssembler.personIDOneToDomain(inputRelationDTO);
        PersonID personIDTwo = relationDTODomainAssembler.personIDTwoToDomain(inputRelationDTO);
        RelationDesignation relationDesignation = relationDTODomainAssembler.relationDesignationToDomain(inputRelationDTO);
        FamilyID familyID = relationDTODomainAssembler.familyIDToDomain(inputRelationDTO);

        //creating Relation in Domain
        Relation relation = new Relation(personIDOne, personIDTwo, relationDesignation);
        Family family = familyRepository.getByID(familyID);
        family.addRelation(relation);

        //retrieving saved relation
        Family savedFamily = familyRepository.add(family);
        RelationID relationID = relation.getId();
        Relation savedRelation = savedFamily.getRelationByID(relationID);

        return relationDTODomainAssembler.toDTO(savedRelation);
    }
}
