package switchtwentytwenty.project.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreateStandardCategoryDTO {

    private String categoryDescription;
    private Long categoryID;
    private Long parentID;

    public CreateStandardCategoryDTO(String categoryDescription, Long categoryID, Long parentID) {
        this.categoryDescription = categoryDescription;
        this.categoryID = categoryID;
        this.parentID = parentID;
    }
}
