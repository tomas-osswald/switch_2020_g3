package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
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
    int familyID = 1;

    Application ffmApp = new Application();
    EmailService emailService = ffmApp.getEmailService();
    FamilyService familyService = ffmApp.getFamilyService();
    AddFamilyMemberDTO memberDTO = new AddFamilyMemberDTO(cc,cc,name,date,numero,email,nif,rua,codPostal,local,city, familyID);
    Family family = new Family("Silva",familyID);

    @BeforeEach
    void setup(){
        family.addFamilyAdministrator(memberDTO);
        familyService.addFamily(family);
    }
    @Test
    void emailServiceConstructor() {
        EmailService emailService = new EmailService();

        Assertions.assertNotNull(emailService);
    }

    @Test
    void addEmail_ValidEmail() {
        String newEmail = "1120717@isep.ipp.pt";

        boolean result = emailService.addEmail(newEmail,familyID,cc);

        assertTrue(result);
    }

    @Test
    void addEmail_InvalidEmail() {
        String newEmail = "1120717@pt";

        assertFalse(emailService.addEmail(newEmail, familyID,cc));

    }

}