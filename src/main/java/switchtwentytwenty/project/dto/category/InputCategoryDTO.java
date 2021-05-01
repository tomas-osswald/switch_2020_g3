package switchtwentytwenty.project.dto.category;

import java.util.Objects;

public class InputCategoryDTO {

    private String categoryName;

    private String parentID;

    public InputCategoryDTO(String categoryName, String parentID) {
        this.categoryName = categoryName;
        this.parentID = parentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputCategoryDTO that = (InputCategoryDTO) o;
        return categoryName.equals(that.categoryName) && parentID.equals(that.parentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, parentID);
    }
}
