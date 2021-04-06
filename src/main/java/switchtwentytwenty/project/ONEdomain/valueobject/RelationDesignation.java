package switchtwentytwenty.project.ONEdomain.valueobject;

public class RelationDesignation implements ValueObject<String> {

    private String description;

    public RelationDesignation(String designation) {
        this.description = designation;
    }
}
