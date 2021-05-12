package switchtwentytwenty.project.domain.aggregates.account;

import switchtwentytwenty.project.domain.valueobject.*;

import java.security.acl.Owner;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    Long id = 66L;
    AccountID accountID = new AccountID(id);
    OwnerID personID = new PersonID("tonyze@latinlover.com");
    OwnerID familyID = new FamilyID("@tonyze@latinlover.com");
    Designation designation = new Designation("Noitadas");

}