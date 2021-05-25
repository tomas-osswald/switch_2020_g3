package switchtwentytwenty.project.dto.relation;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
public class OutputRelationDTO extends RepresentationModel<OutputRelationDTO> {
    private String personIDOne;
    private String personIDTwo;
    private String designation;
}

