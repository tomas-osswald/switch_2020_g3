package switchtwentytwenty.project.category;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.CategoryName;
import switchtwentytwenty.project.shared.CategoryID;

public class Category implements AggregateRoot{

    private CategoryName categoryName;
    private CategoryID categoryID;
    private int postion;

    public Category(CategoryName categoryName, CategoryID categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }





}
