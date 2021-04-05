package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.util.ValueObject;

public class ParentCategory implements ValueObject<Integer> {

    private int parentID;

    public ParentCategory(int parentID) {
        this.parentID = parentID;
    }


}
