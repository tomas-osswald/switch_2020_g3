package switchtwentytwenty.project.domain.category;

import switchtwentytwenty.project.shared.CategoryID;
import switchtwentytwenty.project.shared.CategoryName;
import switchtwentytwenty.project.shared.ParentCategory;

public class Category {

    private CategoryName categoryName;
    private CategoryID categoryID;
    private ParentCategory parentCategory;

    public Category(CategoryName categoryName, CategoryID categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }


}
