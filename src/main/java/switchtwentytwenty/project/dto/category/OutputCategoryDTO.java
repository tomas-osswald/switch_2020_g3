package switchtwentytwenty.project.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
public class OutputCategoryDTO {

    private String categoryName;
    private String categoryID;
    private String parentID;

    public OutputCategoryDTO(String categoryName, String categoryID, String parentID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
        this.parentID = parentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputCategoryDTO that = (OutputCategoryDTO) o;
        return Objects.equals(categoryName, that.categoryName) && Objects.equals(categoryID, that.categoryID) && Objects.equals(parentID, that.parentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, categoryID, parentID);
    }

}
