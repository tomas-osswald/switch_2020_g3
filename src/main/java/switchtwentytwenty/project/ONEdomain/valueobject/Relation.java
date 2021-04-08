package switchtwentytwenty.project.ONEdomain.valueobject;


public class Relation implements ValueObject {

    private EmailAddress memberA;
    private EmailAddress memberB;
    private RelationDesignation relationDesignation;

    public Relation (EmailAddress memberA, EmailAddress memberB, String designation) {
        validateRelation();
        this.memberA = memberA;
        this.memberB = memberB;
        this.relationDesignation = new RelationDesignation(designation);
    }

    private void validateRelation() {

    }
}