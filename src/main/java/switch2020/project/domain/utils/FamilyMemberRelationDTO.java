package switch2020.project.domain.utils;

import switch2020.project.domain.model.Relation;

public class FamilyMemberRelationDTO {

    // Attributes

    private final String relationDesignation;

    // Constructors
    public FamilyMemberRelationDTO(Relation relation) {
        String memberAName = relation.getMemberA().getName();
        String memberBName = relation.getMemberB().getName();
        String relationDescription = relation.getRelationDesignation();
        this.relationDesignation = memberAName + " is " + memberBName + "'s " + relationDescription;
    }

    // Business Methods


    public String getRelationDesignation() {
        return relationDesignation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof FamilyMemberRelationDTO)) return false;

        FamilyMemberRelationDTO that = (FamilyMemberRelationDTO) o;

        return this.relationDesignation.equals(that.relationDesignation);
    }

    /*@Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (relationDesignation != null ? relationDesignation.hashCode() : 0);
        return result;
    }*/
}

