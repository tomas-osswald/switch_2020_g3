package switchtwentytwenty.project.ONEdomain.aggregates.category;

import switchtwentytwenty.project.ONEdomain.valueobject.CategoryID;
import switchtwentytwenty.project.ONEdomain.valueobject.CategoryName;
import switchtwentytwenty.project.ONEdomain.valueobject.FamilyID;

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
