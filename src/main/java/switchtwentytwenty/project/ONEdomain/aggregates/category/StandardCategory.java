package switchtwentytwenty.project.ONEdomain.aggregates.category;

import switchtwentytwenty.project.ONEdomain.valueobject.CategoryID;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

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
    public boolean hasID(ID id) {
        return false;
    }
}
