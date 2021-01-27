package switch2020.project.domain.services;

import switch2020.project.domain.model.Family;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.model.Relation;
import switch2020.project.domain.DTOs.output.FamilyMemberRelationDTO;

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
}
