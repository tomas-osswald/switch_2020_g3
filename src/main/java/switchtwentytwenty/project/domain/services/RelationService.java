package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.utils.exceptions.NoParentalPermissionException;

import java.util.List;

public class RelationService {
    private FamilyService familyService;

    public RelationService(FamilyService familyService) {
        this.familyService = familyService;
    }

    public RelationService() {

    }

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
     * Method to verify parental permission of a member relating another member of the same Family
     *
     * @param targetFamily Family to whom the Family Members belong
     * @param memberA      Expecting parent
     * @param memberB      Expecting child
     * @return If the parental permission exists, returns true. Else, throws an exception.
     */
    public boolean verifyParenthood(Family targetFamily, FamilyMember memberA, FamilyMember memberB) {
        if (!targetFamily.isAParentofB(memberA, memberB)) {
            throw new NoParentalPermissionException("No parental permission");
        }
        return true;
    }
}
