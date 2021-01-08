package switch2020.project.utils;

import java.util.Objects;

public class StandardCategoryDTO {
    private String categoryName;
    private boolean standardCategory;

    public StandardCategoryDTO(String categoryName){
        this.categoryName = categoryName;
        this.standardCategory = true;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public boolean isStandardCategory() {
        return standardCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardCategoryDTO that = (StandardCategoryDTO) o;
        return standardCategory == that.standardCategory && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, standardCategory);
    }
}
