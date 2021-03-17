package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ID;
import switchtwentytwenty.project.ValueObject;

public class CategoryID implements ValueObject, ID {

    private int categoryID;

    public CategoryID(int categoryID) {
        this.categoryID = categoryID;
        validateID();
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
