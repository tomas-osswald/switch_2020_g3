package switchtwentytwenty.project.category;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.categoryName;
import switchtwentytwenty.project.shared.categoryID;

public class category implements AggregateRoot {
    private categoryID categoryID;
    private categoryName categoryName;

    public category(categoryID categoryID, categoryName categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }


}
