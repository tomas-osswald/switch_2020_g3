package switchtwentytwenty.project.domain.dtos.output;

import switchtwentytwenty.project.domain.model.Relation;

import java.util.Objects;

public class FamilyMemberRelationDTO {

    // Attributes

    private final String relationDesignation;
    private final boolean parentalPermission;

    // Constructors
    public FamilyMemberRelationDTO(Relation relation) {
        String memberAName = relation.getMemberA().getName();
        String memberBName = relation.getMemberB().getName();
        String relationDescription = relation.getRelationDesignation();
        this.relationDesignation = memberAName + " is " + memberBName + "'s " + relationDescription;
        this.parentalPermission = relation.isAParentOfB();
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

        return (this.relationDesignation.equals(that.relationDesignation) && this.parentalPermission == that.parentalPermission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationDesignation, parentalPermission);
    }
}

