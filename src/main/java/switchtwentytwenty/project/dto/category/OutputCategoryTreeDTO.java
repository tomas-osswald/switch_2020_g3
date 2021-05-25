package switchtwentytwenty.project.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OutputCategoryTreeDTO {

    private List<OutputCategoryDTO> outputCategoryDTOList;

    public void add(OutputCategoryDTO outputCategoryDTO) {
        this.outputCategoryDTOList.add(outputCategoryDTO);
    }

}
