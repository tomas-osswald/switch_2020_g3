package switchtwentytwenty.project.domain.category;

import switchtwentytwenty.project.shared.CategoryID;
import switchtwentytwenty.project.util.ID;

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
