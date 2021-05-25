package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.Relation;
import switchtwentytwenty.project.domain.valueobject.RelationDesignation;
import switchtwentytwenty.project.dto.relation.InputRelationDTO;
import switchtwentytwenty.project.dto.relation.OutputRelationDTO;

@Component
public class RelationDTODomainAssembler {

    public PersonID personIDOneToDomain(InputRelationDTO inputRelationDTO) {

        return new PersonID(inputRelationDTO.getPersonIDOne());
    }
    public PersonID personIDTwoToDomain(InputRelationDTO inputRelationDTO) {

        return new PersonID(inputRelationDTO.getPersonIDTwo());
    }
    public RelationDesignation relationDesignationToDomain(InputRelationDTO inputRelationDTO) {
        return new RelationDesignation(inputRelationDTO.getDesignation());
    }

    public OutputRelationDTO toDTO(Relation relation) {
        String personIDOne = relation.getMemberA().toString();
        String personIDTwo = relation.getMemberB().toString();
        String designation = relation.getRelationDesignation().toString();

        OutputRelationDTO outputRelationDTO = new OutputRelationDTO();
        outputRelationDTO.setPersonIDOne(personIDOne);
        outputRelationDTO.setPersonIDTwo(personIDTwo);
        outputRelationDTO.setDesignation(designation);

        return outputRelationDTO;
    }
}
