package switchtwentytwenty.project.domain.aggregates.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class InputCategoryDTO {

    private String categoryID;
    private String description;
    private String parentID;
    private String familyID;

    public InputCategoryDTO(String categoryID, String description, String parentID, String familyID) {
        this.categoryID = categoryID;
        this.description = description;
        this.parentID = parentID;
        this.familyID = familyID;
    }
}