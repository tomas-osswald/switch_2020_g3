package switchtwentytwenty.project.Category.shared;

import switchtwentytwenty.project.ID;
import switchtwentytwenty.project.ValueObject;

public class CategoryID implements ID, ValueObject {
    private int categoryID;

    public CategoryID() {
        this.categoryID = categoryID;
    }

    private void validateID(){
        if(!isIDValid()){
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    private boolean isIDValid(){
        return this.categoryID<1;
    }
}
