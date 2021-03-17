package switchtwentytwenty.project.domain.category;

import switchtwentytwenty.project.shared.CategoryID;
import switchtwentytwenty.project.shared.CategoryName;

public class Category {

    private CategoryName categoryName;
    private CategoryID categoryID;

    public Category(CategoryName categoryName, CategoryID categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }

    
}
