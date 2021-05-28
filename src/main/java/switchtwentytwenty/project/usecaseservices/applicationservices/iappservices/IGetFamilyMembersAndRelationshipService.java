package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.family.FamilyMemberAndRelationsListDTO;

public interface IGetFamilyMembersAndRelationshipService {
    public FamilyMemberAndRelationsListDTO getFamilyMembersAndRelations(String familyID);
}
