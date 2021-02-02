package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.EmailService;
import switchtwentytwenty.project.domain.services.FamilyService;

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
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(ccNumber);
            if (familyService.checkIfEmailAlreadyRegisteredInApp(emailToAdd)) {
                throw new IllegalArgumentException("Email Already Present");
            }
            return emailService.addEmail(emailToAdd, targetMember);

        } catch (Exception exception) {
            return false;
        }
    }


}
