package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.user_data.EmailAddress;

public class EmailService {
    private FamilyService familyService;

    public EmailService(FamilyService familyService){
        this.familyService = familyService;
    }

    public EmailService(){

    }

    public boolean addEmail(String emailToAdd, int familyID, String ccNumber) {
        FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(ccNumber);
        EmailAddress email = new EmailAddress(emailToAdd);
        familyService.checkIfEmailIsUnique(emailToAdd);
        return targetMember.addEmail(email);
    }


}
