package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.FamilyMember;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailServiceTest {

    String cc = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    @Test
    void emailServiceConstructor() {
        EmailService emailService = new EmailService();

        Assertions.assertNotNull(emailService);
    }

    @Test
    void addEmail_ValidEmail() {
        String newEmail = "1120717@isep.ipp.pt";
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        EmailService emailService = new EmailService();

        boolean result = emailService.addEmail(newEmail, diogo);

        assertTrue(result);
    }

    @Test
    void addEmail_InvalidEmail() {
        String newEmail = "1120717@pt";
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        EmailService emailService = new EmailService();
        assertFalse(emailService.addEmail(newEmail, diogo));

    }

}