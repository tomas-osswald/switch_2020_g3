package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.relation.InputRelationDTO;
import switchtwentytwenty.project.dto.relation.OutputRelationDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

public interface ICreateRelationService {

    OutputRelationDTO createRelation(InputRelationDTO inputRelationDTO);


}