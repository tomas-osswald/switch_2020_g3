package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;

public class ChangeRelationBaseController {

    private final Application ffmApplication;


    public ChangeRelationBaseController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean changeRelation(String adminCC, String memberACCNumber, String memberBCCNumber, int familyID, String relationDesignation, boolean aIsParentOfB) {
        AddOrChangeRelationController changeRelationController = new AddOrChangeRelationController();
        return changeRelationController.addOrChangeRelation(ffmApplication, adminCC, memberACCNumber, memberBCCNumber, familyID, relationDesignation, aIsParentOfB);
    }

}
