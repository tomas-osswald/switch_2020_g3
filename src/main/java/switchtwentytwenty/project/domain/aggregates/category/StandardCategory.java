package switchtwentytwenty.project.domain.aggregates.category;

import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.ID;

public class StandardCategory implements Category {

    private CategoryData categoryData;

    public StandardCategory(CategoryData categoryData) {
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
