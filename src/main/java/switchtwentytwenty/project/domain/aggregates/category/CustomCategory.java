package switchtwentytwenty.project.domain.aggregates.category;

import switchtwentytwenty.project.domain.valueobject.CategoryID;

public class CustomCategory implements Category {

    private CategoryData categoryData;

    public CustomCategory(CategoryData categoryData) {
        this.categoryData = categoryData;
    }

    @Override
    public CategoryID id() {
        return null;
    }

    @Override
    public boolean hasID(CategoryID id) {
        return false;
    }
}
