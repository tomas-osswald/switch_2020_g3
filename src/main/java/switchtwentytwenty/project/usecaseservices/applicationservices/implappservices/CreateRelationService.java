package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.Relation;
import switchtwentytwenty.project.domain.valueobject.RelationDesignation;
import switchtwentytwenty.project.dto.assemblers.implassemblers.RelationDTODomainAssembler;
import switchtwentytwenty.project.dto.relation.InputRelationDTO;
import switchtwentytwenty.project.dto.relation.OutputRelationDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateRelationService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

@Service
public class CreateRelationService implements ICreateRelationService {

    private IFamilyRepository familyRepository;
    private RelationDTODomainAssembler relationDTODomainAssembler;

    @Autowired
    public CreateRelationService(IFamilyRepository familyRepository, RelationDTODomainAssembler relationDTODomainAssembler) {
        this.familyRepository = familyRepository;
        this.relationDTODomainAssembler = relationDTODomainAssembler;
    }

    @Override
    public OutputRelationDTO createRelation(InputRelationDTO inputRelationDTO){

        PersonID personIDOne = relationDTODomainAssembler.personIDOneToDomain(inputRelationDTO);
        PersonID personIDTwo = relationDTODomainAssembler.personIDTwoToDomain(inputRelationDTO);
        RelationDesignation relationDesignation = relationDTODomainAssembler.relationDesignationToDomain(inputRelationDTO);

        Relation relation = new Relation(personIDOne, personIDTwo, relationDesignation);
        Relation savedRelation = familyRepository.addRelation(relation);

        return relationDTODomainAssembler.toDTO(savedRelation);
    }
}
