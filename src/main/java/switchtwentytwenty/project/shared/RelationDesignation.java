package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.util.ValueObject;

public class RelationDesignation implements ValueObject<String> {

    private String description;

    public RelationDesignation(String designation) {
        this.description = designation;
    }
}
