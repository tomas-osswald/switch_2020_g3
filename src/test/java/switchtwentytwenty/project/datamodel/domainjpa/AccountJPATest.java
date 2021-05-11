package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountJPATest {

    AccountIDJPA accountIDJPA = new AccountIDJPA(123456L);
    Long balance = 3L;
    PersonIDJPA ownerIDJPA = new PersonIDJPA("tonyze@latinlover.com");
    String designation = "Conta do Ze";
    String accountType = "Current";

    @Test
    void getAccountIDTest() {
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        AccountIDJPA expectedAccountIDJPA = new AccountIDJPA(123456L);
        AccountIDJPA result = accountJPA.getId();

        assertEquals(expectedAccountIDJPA, result);
    }

    @Test
    void getBalanceTest() {
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        Long expectedBalance = 3L;
        Long result = accountJPA.getBalance();

        assertEquals(expectedBalance, result);
    }
    @Test
    void getOwnerIDTest() {
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        String expectedOwnerID = "tonyze@latinlover.com";

        String result = accountJPA.getOwnerID().toString();

        assertEquals(expectedOwnerID, result);
    }
    @Test
    void getDesignationTest() {
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        String expectedDesignation = "Conta do Ze";

        String result = accountJPA.getDesignation();

        assertEquals(expectedDesignation, result);
    }
    @Test
    void getTestAccountTypeTest() {
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        String expectedAccountType = "Current";

        String result = accountJPA.getAccountType();

        assertEquals(expectedAccountType, result);
    }
    @Test
    void AccountJPAEqualsTest() {
        AccountJPA accountJPAOne = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);
        AccountJPA accountJPATwo = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        assertEquals(accountJPAOne, accountJPATwo);
        assertNotSame(accountJPAOne, accountJPATwo);
    }
}
