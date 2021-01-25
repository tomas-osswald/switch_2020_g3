package switch2020.project.domain.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.Family;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.model.Relation;

import java.util.Date;

class AccountServiceTest {

    AccountService accountService = new AccountService();
    FamilyService familyService = new FamilyService();

    // family1 data
    int family1ID = 5;
    String family1Name = "Silva";
    Family silva = new Family(family1Name, family1ID);

    // family1 member1 data
    String cc1 = "166699209ZY8";
    String name1 = "Ze";
    Date date1 = new Date(1970, 1, 2);
    int numero1 = 931456789;
    String email1 = "ze90@gmail.com";
    int nif1 = 231874316;
    String rua1 = "Rua dos Abracos";
    String codPostal1 = "4000-011";
    String local1 = "Porto";
    String city1 = "Porto";
    String relacao1 = "pai";
    Relation relation1 = new Relation(relacao1);
    boolean admin1 = true;

    // family1 member2 data
    String cc2 = "137476450ZX0";
    String name2 = "Maria";
    Date date2 = new Date(2001, 6, 12);
    int numero2 = 938036428;
    String email2 = "maria303@gmail.com";
    int nif2 = 299525295;
    String rua2 = "Rua dos Carqueijais";
    String codPostal2 = "4000-181";
    String local2 = "Porto";
    String city2 = "Porto";
    String relacao2 = "filha";
    Relation relation2 = new Relation(relacao2);
    boolean admin2 = false;

    // add member1 and member2 to family
    FamilyMember ze = new FamilyMember(cc1, name1, date1, numero1, email1, nif1, rua1, codPostal1, local1, city2, admin1);
    FamilyMember maria = new FamilyMember(cc1, name1, date1, numero1, email1, nif1, rua1, codPostal1, local1, city2, admin1);

    @Test
    void createPersonalCreditCardAccountTrue() {
        //arrange
       silva.addFamilyMember(ze);
       assertTrue(accountService.createPersonalCreditCardAccount(ze,"Conta do Ze", 5000));
    }

    @Test
    void createPersonalCreditCardAccountAssertThrowInvalidWithrawalLimit() {
        silva.addFamilyMember(maria);
        assertThrows(Exception.class, () -> accountService.createPersonalCreditCardAccount(maria,"Conta da Maria", -100));
    }
}