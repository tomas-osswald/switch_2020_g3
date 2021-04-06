package switchtwentytwenty.project.ONEdomain.aggregates.category;

import switchtwentytwenty.project.ONEdomain.valueobject.CategoryID;
import switchtwentytwenty.project.ONEdomain.valueobject.FamilyID;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

public class CustomCategory implements Category {

    private CategoryData categoryData;
    private FamilyID family;

    public CustomCategory(CategoryData categoryData) {
        this.categoryData = categoryData;
    }

    @Override
    public CategoryID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}
