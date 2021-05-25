package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.relation.InputRelationDTO;
import switchtwentytwenty.project.dto.relation.OutputRelationDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateRelationService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

@Service
@NoArgsConstructor
public class CreateRelationService implements ICreateRelationService {

    public OutputRelationDTO createRelation(InputRelationDTO inputRelationDTO) {

        return null;
    }

}