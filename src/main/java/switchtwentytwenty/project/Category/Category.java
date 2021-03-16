package switchtwentytwenty.project.Category;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.Category.shared.CategoryID;
import switchtwentytwenty.project.Category.shared.CategoryName;

public class Category implements AggregateRoot{

    private CategoryName categoryName;
    private CategoryID categoryID;
    private int position;

    public Category(CategoryName categoryName, CategoryID categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }
}