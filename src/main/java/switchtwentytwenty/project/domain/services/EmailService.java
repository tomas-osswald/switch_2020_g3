package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.model.FamilyMember;

public class EmailService {




    public boolean addEmail(String emailToAdd, FamilyMember targetMember) {
        return targetMember.addEmail(emailToAdd);
    }


}
