package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.valueobject.Relation;
import switchtwentytwenty.project.dto.family.InputChangeRelationDTO;
import switchtwentytwenty.project.dto.family.OutputRelationDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IChangeRelationService;

@Service
@NoArgsConstructor
public class ChangeRelationService implements IChangeRelationService {



    public OutputRelationDTO changeRelation(InputChangeRelationDTO inputChangeRelationDTO){


        throw new UnsupportedOperationException();
    }



}
