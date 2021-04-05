package switchtwentytwenty.project.shared;

public class RelationDesignation implements ValueObject<String> {

    private String description;

    public RelationDesignation(String designation) {
        this.description = designation;
    }
}
