package switchtwentytwenty.project.domain.valueobject;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;
        return (memberA.equals(relation.memberA) && memberB.equals(relation.memberB)) || (memberA.equals(relation.memberB) && memberB.equals(relation.memberA));
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberA, memberB);
    }
}
