package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.services.RelationService;

public class AddOrChangeRelationController {

    /**
     * Method to add a Relation to a Family Member
     *
     * @param adminCC             Identificator of user that wants to create a Relation
     * @param memberACCNumber     Identificator of the family member to assign a Relation
     * @param memberBCCNumber     Identificator of the other family member to assign a Relation
     * @param relationDesignation Designation of the Relation
     * @param familyID            Identificator of the family of stakeholders
     * @param aIsParentOfB        boolean to check if A is a parent of B
     * @return boolean If a Relation has been assign or not
     */

    public boolean addOrChangeRelation(Application ffmApplication, String adminCC, String memberACCNumber, String memberBCCNumber, int familyID, String relationDesignation, boolean aIsParentOfB) {
        try {

            FamilyService familyService = ffmApplication.getFamilyService();
            RelationService relationService = ffmApplication.getRelationService();
            Family targetFamily = familyService.getFamily(familyID);
            if (!targetFamily.verifyAdministrator(adminCC)) {
                return false;
            }
            FamilyMember memberA = targetFamily.getFamilyMember(memberACCNumber);
            FamilyMember memberB = targetFamily.getFamilyMember(memberBCCNumber);
            return relationService.addRelation(targetFamily, memberA, memberB, relationDesignation, aIsParentOfB);
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
