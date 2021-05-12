package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.domain.valueobject.AccountType;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.PersonID;

class AccountDataDomainAssemblerTest {
    AccountDataDomainAssembler accountDataDomainAssembler = new AccountDataDomainAssembler();

    @Test
    void createAccountID() {
        AccountIDJPA accountIDJPA = new AccountIDJPA(1L);
        PersonIDJPA personIDJPA = new PersonIDJPA("email@email.com");
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, personIDJPA, "account", "cash");

        AccountID result = accountDataDomainAssembler.createAccountID(accountJPA);
        AccountID expected = new AccountID(1L);

        Assertions.assertNotNull(result);
        Assertions.assertNotSame(expected, result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void createPersonID() {
        AccountIDJPA accountIDJPA = new AccountIDJPA(1L);
        PersonIDJPA personIDJPA = new PersonIDJPA("email@email.com");
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, personIDJPA, "account", "cash");

        PersonID result = accountDataDomainAssembler.createPersonID(accountJPA);
        PersonID expected = new PersonID("email@email.com");

        Assertions.assertNotNull(result);
        Assertions.assertNotSame(expected, result);
        Assertions.assertEquals(expected, result);

    }

    @Test
    void createDesignation() {
        AccountIDJPA accountIDJPA = new AccountIDJPA(1L);
        PersonIDJPA personIDJPA = new PersonIDJPA("email@email.com");
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, personIDJPA, "account", "cash");

        Designation result = accountDataDomainAssembler.createDesignation(accountJPA);
        Designation expected = new Designation("account");

        Assertions.assertNotNull(result);
        Assertions.assertNotSame(expected, result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void createAccountType() {
        AccountIDJPA accountIDJPA = new AccountIDJPA(1L);
        PersonIDJPA personIDJPA = new PersonIDJPA("email@email.com");
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, personIDJPA, "account", "cash");

        AccountType result = accountDataDomainAssembler.createAccountType(accountJPA);
        AccountType expected = new AccountType("cash");

        Assertions.assertNotNull(result);
        Assertions.assertNotSame(expected, result);
        Assertions.assertEquals(expected, result);
    }
}