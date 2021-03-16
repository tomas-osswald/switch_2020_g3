package switchtwentytwenty.project.category;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.CategoryName;
import switchtwentytwenty.project.shared.CategoryID;

public class Category implements AggregateRoot {

    private CategoryID categoryID;
    private CategoryName categoryName;

    public Category(CategoryID categoryID, CategoryName categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    
}
