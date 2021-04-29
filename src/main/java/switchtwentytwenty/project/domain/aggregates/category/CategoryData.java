package switchtwentytwenty.project.domain.aggregates.category;

import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

import java.util.Objects;

public class CategoryData {

    private CategoryName categoryName;
    private CategoryID categoryID;
    private CategoryID parentCategoryID;


    public CategoryData(CategoryName categoryName, CategoryID categoryID, CategoryID parentCategoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
        this.parentCategoryID = parentCategoryID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryData that = (CategoryData) o;
        return categoryID.equals(that.categoryID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID);
    }
}
