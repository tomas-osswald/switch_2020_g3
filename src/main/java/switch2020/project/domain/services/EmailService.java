package switch2020.project.domain.services;

import switch2020.project.domain.model.FamilyMember;

public class EmailService {




    public boolean addEmail(String emailToAdd, FamilyMember targetMember) {
        return targetMember.addEmail(emailToAdd);
    }


}
