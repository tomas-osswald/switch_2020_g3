package switch2020.project.controllers;

//import switch2020.project.model.Application;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;

public class AddEmailController {
    private Application ffmApp;

    public AddEmailController(Application app) {
        this.ffmApp = app;
    }

    /*
    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd     String of the email address to add
     * @param familyID       Integer representing the family's ID
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyID, String ccNumber) {
        try {
            FamilyService familyService = this.ffmApp.getFamilyService();
            return familyService.addEmail(emailToAdd, familyID, ccNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }


}
