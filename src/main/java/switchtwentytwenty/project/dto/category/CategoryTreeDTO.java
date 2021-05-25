package switchtwentytwenty.project.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class CategoryTreeDTO extends RepresentationModel<CategoryTreeDTO> {

    @Getter
    private List<OutputCategoryDTO> categoryTreeDTO = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryTreeDTO)) return false;
        if (!super.equals(o)) return false;
        CategoryTreeDTO that = (CategoryTreeDTO) o;
        return Objects.equals(getCategoryTreeDTO(), that.getCategoryTreeDTO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCategoryTreeDTO());
    }

    /*
    public CategoryTreeDTO addDTO(OutputCategoryDTO outputCategoryDTO){
        CategoryTreeDTO categoryTreeDTO = new CategoryTreeDTO();

        categoryTreeDTO.add(outputCategoryDTO);

        return categoryTreeDTO;
    }
     */

}
