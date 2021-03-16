package switchtwentytwenty.project.Category;

import switchtwentytwenty.project.AggregateRoot;

public class Category implements AggregateRoot{

    private CategoryName categoryName;
    private CategoryID categoryID;
    private int postion;

    public Category(CategoryName categoryName, CategoryID categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }





}
