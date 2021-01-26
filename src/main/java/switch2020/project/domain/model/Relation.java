package switch2020.project.domain.model;

public class Relation {

    // Attributes
    private String relationDesignation;
    private FamilyMember memberA;
    private FamilyMember memberB;
    private boolean isAparentOfB = false;

    // Constructors
    public Relation(String relationDesignation, FamilyMember memberA, FamilyMember memberB, boolean aParentOfB) {
        isValid(relationDesignation);
        this.relationDesignation = relationDesignation;
        this.memberA = memberA;
        this.memberB = memberB;
        this.isAparentOfB = aParentOfB;

    }

    public boolean isAparentOfB() {
        return isAparentOfB;
    }

    public FamilyMember getMemberA() {
        return memberA;
    }

    public FamilyMember getMemberB() {
        return memberB;
    }
// Business Methods

    /**
     * Method to verify if a given relation designation to instantiate is null or empty
     *
     * @param relationDesignation Relation Designation to instantiate a Relation
     */

    private void isValid(String relationDesignation) {
        if (relationDesignation == null || relationDesignation.isBlank() || relationDesignation.isEmpty()) {
            // If is null or empty, a exception is throw
            throw new IllegalArgumentException("Empty or Null relation designation");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Relation)) return false;

        Relation otherRelation = (Relation) o;

        return (this.relationDesignation.equals(otherRelation.relationDesignation) && this.memberA.equals(otherRelation.memberA) && this.memberB.equals(otherRelation.memberB) && this.isAparentOfB == otherRelation.isAparentOfB);
    }

    @Override
    public int hashCode() {
        return relationDesignation != null ? relationDesignation.hashCode() : 0;
    }

    /**
     * Method to get the relation designation of the Relation
     *
     * @return String relation designation
     */

    public String getRelationDesignation() {
        return relationDesignation;
    }

}
