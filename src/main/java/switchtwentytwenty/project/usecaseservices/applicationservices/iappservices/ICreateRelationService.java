package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.relation.InputRelationDTO;
import switchtwentytwenty.project.dto.relation.OutputRelationDTO;

@Component
public interface ICreateRelationService {

    OutputRelationDTO createRelation(InputRelationDTO inputRelationDTO);
}
