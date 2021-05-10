package switchtwentytwenty.project.domain.aggregates.category;

import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;

import java.util.Objects;

public class StandardCategory implements Category {

    private CategoryData categoryData;

    public StandardCategory(CategoryName categoryName){

        this.categoryData = new CategoryData(categoryName, null, null);
    }

    public StandardCategory(CategoryName categoryName, CategoryID parentID){

        this.categoryData = new CategoryData(categoryName, null, parentID);
    }

    public StandardCategory(CategoryName categoryName, CategoryID categoryID, CategoryID parentID){

        this.categoryData = new CategoryData(categoryName, categoryID, parentID);
    }


    @Override
    public CategoryID id() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasID(CategoryID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardCategory that = (StandardCategory) o;
        return categoryData.equals(that.categoryData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryData);
    }
}
