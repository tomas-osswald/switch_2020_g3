package switch2020.project.controllers;

import switch2020.project.domain.model.Application;

public class AddRelationBaseController {

    private final Application ffmApplication;




    public AddRelationBaseController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addRelation(String adminCC, String memberACCNumber, String memberBCCNumber, int familyID, String relationDesignation, boolean aIsParentOfB) {
        AddOrChangeRelationController addRelationController = new AddOrChangeRelationController();
        return addRelationController.addOrChangeRelation(ffmApplication, adminCC, memberACCNumber, memberBCCNumber, familyID, relationDesignation, aIsParentOfB);
    }

}
