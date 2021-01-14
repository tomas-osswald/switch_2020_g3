package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;

public class AddRelationController {
    private Application ffmApplication;

    public AddRelationController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     *
     * @param selfCCNumber
     * @param otherCCNumber
     * @param relationDesignation
     * @param familyID
     * @return
     */

    public boolean createRelation(String selfCCNumber, String otherCCNumber, String relationDesignation, int familyID) {
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            return familyService.createRelation(selfCCNumber, otherCCNumber, relationDesignation, familyID);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
