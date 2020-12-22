package switch2020.project.controllers;


import switch2020.project.model.Application;

public class AddEmailController {
    private Application FFMapp;

    public AddEmailController(Application app) {
        this.FFMapp = app;
    }

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd     String of the email address to add
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyMemberID) {
        return this.FFMapp.addEmail(emailToAdd, familyMemberID);
    }


}
