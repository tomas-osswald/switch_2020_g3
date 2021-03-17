package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.EmailService;

public class AddEmailController {
    private final Application ffmApplication;

    public AddEmailController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
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
        EmailService emailService = this.ffmApplication.getEmailService();
        boolean result = false;
        try {
            result = emailService.addEmail(emailToAdd, familyID, ccNumber);
        } catch (Exception exception) {
        }
        return result;
    }


}
