package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ID;
import switchtwentytwenty.project.ValueObject;

public class CategoryID implements ValueObject, ID {

    private int categoryID;

    public CategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    

}
