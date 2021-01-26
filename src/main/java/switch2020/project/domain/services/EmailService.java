package switch2020.project.domain.services;

import switch2020.project.domain.model.EmailAddress;
import switch2020.project.domain.model.FamilyMember;

import java.util.ArrayList;
import java.util.List;

public class EmailService {


    public EmailService() {

    }



    public boolean addEmail(String emailToAdd, FamilyMember targetMember) {
        return targetMember.addEmail(emailToAdd);
    }


}
