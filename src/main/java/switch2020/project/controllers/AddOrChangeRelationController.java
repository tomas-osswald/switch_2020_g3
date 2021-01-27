package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.Family;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.FamilyService;
import switch2020.project.domain.services.RelationService;

public class AddOrChangeRelationController {
    private Application ffmApplication;

    public AddOrChangeRelationController() {

    }

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
            this.ffmApplication = ffmApplication;
            FamilyService familyService = this.ffmApplication.getFamilyService();
            RelationService relationService = this.ffmApplication.getRelationService();
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
