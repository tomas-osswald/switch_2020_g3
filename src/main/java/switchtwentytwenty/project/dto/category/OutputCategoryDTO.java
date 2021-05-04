package switchtwentytwenty.project.dto.category;

import java.util.Objects;

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
        return categoryID.equals(that.categoryID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID);
    }
}
