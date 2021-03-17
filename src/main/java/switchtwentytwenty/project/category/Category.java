package switchtwentytwenty.project.category;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.CategoryID;
import switchtwentytwenty.project.shared.CategoryName;

public class Category implements AggregateRoot {

    private CategoryName categoryName;
    private CategoryID categoryID;

    public Category(CategoryName categoryName, CategoryID categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }

    
}
