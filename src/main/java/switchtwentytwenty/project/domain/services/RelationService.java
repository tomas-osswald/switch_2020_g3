package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.utils.exceptions.NoParentalPermissionException;

import java.util.List;

public class RelationService {

    /**
     * Method to add a relation to a family.
     *
     * @param targetFamily        Family object to which we add the relation
     * @param memberA             First FamilyMember Object of the relation
     * @param memberB             Second FamilyMember Object of the relation
     * @param relationDesignation Name of the relation
     * @param aIsParentOfB        True if First member has parental permission over the second memeber
     * @return True if relation successfully added
     */
    public boolean addRelation(Family targetFamily, FamilyMember memberA, FamilyMember memberB, String relationDesignation, boolean aIsParentOfB) {
        Relation newRelation = new Relation(relationDesignation, memberA, memberB, aIsParentOfB);
        targetFamily.addRelation(newRelation);
        return true;
    }

    public List<FamilyMemberRelationDTO> getFamilyMembersRelationDTOList(Family targetFamily) {
        return targetFamily.getFamilyMembersRelationDTOList();
    }

    /**
     * Method to verify the parenthood permission of two family members
     *
     * @param targetFamily Family of the two members
     * @param memberA      Member to check if parent
     * @param memberB      Member to check if child
     * @return True if A is parent of B
     */
    public boolean checkIfMemberAisParentOfB(Family targetFamily, FamilyMember memberA, FamilyMember memberB) {
        return targetFamily.verifyParenthood(memberA, memberB);
    }

    public boolean verifyParenthood(Family targetFamily, FamilyMember memberA, FamilyMember memberB) {
        boolean parenthood = targetFamily.verifyParenthood(memberA, memberB);
        if (!targetFamily.verifyParenthood(memberA, memberB)) {
            throw new NoParentalPermissionException("No parental permission");
        }
        return true;
    }
}
