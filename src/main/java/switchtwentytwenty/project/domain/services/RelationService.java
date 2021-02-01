package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.dtos.output.FamilyMemberRelationDTO;
import switchtwentytwenty.project.domain.utils.exceptions.NoParentalPermissionException;

import java.util.List;

public class RelationService {


    public boolean addRelation(Family targetFamily, FamilyMember memberA, FamilyMember memberB, String relationDesignation, boolean aIsParentOfB) {
        Relation newRelation = new Relation(relationDesignation, memberA, memberB, aIsParentOfB);
        return targetFamily.addRelation(newRelation);
    }

    public List<FamilyMemberRelationDTO> getFamilyMembersRelationDTOList(Family targetFamily) {
        return targetFamily.getFamilyMembersRelationDTOList();
    }

    public boolean checkIfMemberAisParentOfB(Family targetFamily, FamilyMember memberA, FamilyMember memberB) {
        return targetFamily.isAParentOfB(memberA, memberB);
    }

    public boolean verifyParenthood(Family targetFamily, FamilyMember memberA, FamilyMember memberB) {
        boolean parenthood = targetFamily.isAParentOfB(memberA, memberB);
        if (!targetFamily.isAParentOfB(memberA, memberB)){
            throw new NoParentalPermissionException("No parental permission");
        }
        return parenthood;
    }
}
