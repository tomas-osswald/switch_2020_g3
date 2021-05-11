package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountJPATest {

    AccountIDJPA accountIDJPA = new AccountIDJPA(123456L);
    Long balance = 3L;
    PersonIDJPA ownerIDJPA = new PersonIDJPA("tonyze@latinlover.com");
    String designation = "Conta do Ze";
    String accountType = "Current";

    AccountIDJPA accountIDJPATwo = new AccountIDJPA(999999L);

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
    void equalsAccountJPAEqualAccountJPATest() {
        AccountJPA accountJPAOne = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);
        AccountJPA accountJPATwo = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        assertEquals(accountJPAOne, accountJPATwo);
        assertNotSame(accountJPAOne, accountJPATwo);
    }
    @Test
    void equalsAccountJPAIsSameAccountJPA(){
        AccountJPA accountJPAOne = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);
        AccountJPA accountJPATwo = accountJPAOne;

        assertEquals(accountJPAOne, accountJPATwo);
        assertSame(accountJPAOne, accountJPATwo);
    }
    @Test
    void equalsAccountJPADifferentAccountJPATest() {
        AccountJPA accountJPAOne = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);
        AccountJPA accountJPATwo = new AccountJPA(accountIDJPATwo, balance, ownerIDJPA, designation, accountType);

        assertNotEquals(accountJPAOne, accountJPATwo);
    }
    @Test
    void equalsAccountJPADifferentClassTest() {
        AccountJPA accountJPAOne = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        assertNotEquals(accountJPAOne, accountIDJPA);
    }
    @Test
    void equalsAccountJPADifferentFromNullTest() {
        AccountJPA accountJPAOne = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);
        String nullString = null;

        assertNotEquals(accountJPAOne, nullString);
    }
    @Test
    void hashCodeAccountJPAIsEquals(){
        AccountJPA accountJPAOne = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);
        AccountJPA accountJPATwo = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);

        assertEquals(accountJPAOne.hashCode(), accountJPATwo.hashCode());
        assertNotSame(accountJPAOne, accountJPATwo);
    }
    @Test
    void hashCodeAccountJPAIsDifferent(){
        AccountJPA accountJPAOne = new AccountJPA(accountIDJPA, balance, ownerIDJPA, designation, accountType);
        AccountJPA accountJPATwo = new AccountJPA(accountIDJPATwo, balance, ownerIDJPA, designation, accountType);

        assertNotEquals(accountJPAOne.hashCode(), accountJPATwo.hashCode());
    }
}
