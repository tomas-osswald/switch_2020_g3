package switchtwentytwenty.project.domain.aggregates.category;

import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

import java.util.Objects;

public class CustomCategory implements Category {

    private CategoryData categoryData;
    private FamilyID familyID;

    public CustomCategory(CategoryData categoryData, FamilyID familyID) {
        this.categoryData = categoryData;
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
        CustomCategory that = (CustomCategory) o;
        return categoryData.equals(that.categoryData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryData);
    }
}
