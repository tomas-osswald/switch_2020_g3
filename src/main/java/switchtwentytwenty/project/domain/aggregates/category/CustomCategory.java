package switchtwentytwenty.project.domain.aggregates.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class CustomCategory implements Category {

    private CategoryID categoryID;
    private CategoryID parentID;
    private CategoryName categoryName;
    private FamilyID familyID;

    public CustomCategory(CategoryID categoryID, CategoryName categoryName, FamilyID familyID) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.familyID = familyID;
    }

    public CustomCategory(CategoryID categoryID, CategoryID parentID, CategoryName categoryName, FamilyID familyID) {
        this.categoryID = categoryID;
        this.parentID = parentID;
        this.categoryName = categoryName;
        this.familyID = familyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomCategory that = (CustomCategory) o;
        return Objects.equals(categoryID, that.categoryID) && Objects.equals(parentID, that.parentID) && Objects.equals(categoryName, that.categoryName) && Objects.equals(familyID, that.familyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, parentID, categoryName, familyID);
    }

    @Override
    public CategoryID id() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasID(CategoryID id) {
        throw new UnsupportedOperationException();
    }


}
