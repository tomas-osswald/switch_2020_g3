package switchtwentytwenty.project.domain.aggregates.category;

import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

public class CategoryData {

    private CategoryName categoryName;
    private CategoryID categoryID;
    private CategoryID parentCategoryID;
    private FamilyID familyID;

    public CategoryData(CategoryName categoryName, CategoryID categoryID, CategoryID parentCategoryID, FamilyID familyID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
        this.parentCategoryID = parentCategoryID;
        this.familyID = familyID;
    }


}
