package switch2020.project.domain.services;

import switch2020.project.domain.model.EmailAddress;
import switch2020.project.domain.model.FamilyMember;

import java.util.ArrayList;
import java.util.List;

public class EmailService {

    private List<EmailAddress> emails = new ArrayList<>();

    public EmailService() {

    }

    private boolean checkIfEmailPresent(String emailToAdd) {
        for (EmailAddress email : emails) {
            if (emailToAdd.equalsIgnoreCase(email.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmail(String emailToAdd, FamilyMember targetMember) {
        if (!checkIfEmailPresent(emailToAdd)) {
            emails.add(new EmailAddress(emailToAdd));
            return targetMember.addEmail(emailToAdd);
        }
        return false;
    }
}
