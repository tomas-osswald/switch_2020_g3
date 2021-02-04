package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;

public class ChangeRelationBaseController {

    private final Application ffmApplication;


    public ChangeRelationBaseController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Controller level method to edit an existing relation between 2 family members
     * @param adminCC ID number of the family administrator
     * @param memberACCNumber ID number of the first member of the relationship
     * @param memberBCCNumber ID number of the second member of the relationship
     * @param familyID ID number of the target family
     * @param relationDesignation Name of the relation
     * @param aIsParentOfB True if the first member has parental permissions over the second
     * @return True if the relation is successfully changed
     */
    public boolean changeRelation(String adminCC, String memberACCNumber, String memberBCCNumber, int familyID, String relationDesignation, boolean aIsParentOfB) {
        AddOrChangeRelationController changeRelationController = new AddOrChangeRelationController();
        return changeRelationController.addOrChangeRelation(ffmApplication, adminCC, memberACCNumber, memberBCCNumber, familyID, relationDesignation, aIsParentOfB);
    }

}
