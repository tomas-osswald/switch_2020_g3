package switchtwentytwenty.project.domain.category;

import switchtwentytwenty.project.shared.CategoryID;
import switchtwentytwenty.project.shared.CategoryName;
import switchtwentytwenty.project.shared.FamilyID;

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
