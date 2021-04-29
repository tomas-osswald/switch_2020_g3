package switchtwentytwenty.project.domain.aggregates.category;

import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;

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
        return null;
    }

    @Override
    public boolean hasID(CategoryID id) {
        return false;
    }
}
