package switchtwentytwenty.project.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OutputCategoryTreeDTO extends RepresentationModel {

    private List<OutputCategoryDTO> outputCategoryDTOList;

    public void addOutputCategoryDTO(OutputCategoryDTO outputCategoryDTO) {
        this.outputCategoryDTOList.add(outputCategoryDTO);
    }

}
