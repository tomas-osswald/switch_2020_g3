package switch2020.project.controllers;

//import switch2020.project.domain.model.Application;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.FamilyService;

public class AddEmailController {
    private Application ffmApplication;

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
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(ccNumber);
            if (!familyService.checkIfEmailPresent(emailToAdd)) {
                return targetMember.addEmail(emailToAdd);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return false;
    }


}
