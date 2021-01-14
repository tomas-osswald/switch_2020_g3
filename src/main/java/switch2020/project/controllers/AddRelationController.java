package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;

public class AddRelationController {
    private Application ffmApplication;

    public AddRelationController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Method to add a Relation to a Family Member
     *
     * @param selfCCNumber Identificator of user that wants to create a Relation
     * @param otherCCNumber Identificator of the family member to assign a Relation
     * @param relationDesignation Designation of the Relation
     * @param familyID Identificator of the family of stakeholders
     * @return boolean If a Relation has been assign or not
     */

    public boolean createRelation(String selfCCNumber, String otherCCNumber, String relationDesignation, int familyID) {
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            return familyService.createRelation(selfCCNumber, otherCCNumber, relationDesignation, familyID);
        } catch (IllegalArgumentException exception) {
            //System.out.println(exception.getMessage());
            return false;
        }
    }
}
