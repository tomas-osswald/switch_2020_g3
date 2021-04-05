package switchtwentytwenty.project.domain.category;

import switchtwentytwenty.project.shared.CategoryID;
import switchtwentytwenty.project.shared.FamilyID;
import switchtwentytwenty.project.shared.ID;

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
