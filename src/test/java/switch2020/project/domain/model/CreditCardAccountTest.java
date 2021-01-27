package switch2020.project.domain.model;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.accounts.CreditCardAccount;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardAccountTest {

    //Credit Card Account Data One
    double withdrawlLimitOne = 1000.00;
    String cardDescriptionOne = "Shopping";
    int idOne = 1;

    //Credit Card Account Data Two
    double withdrawlLimitTwo = 500.00;
    String cardDescriptionTwo = "Holidays";
    int idTwo = 2;

    //Credit Card Account Data One
    double withdrawlLimitThree = 1000.00;
    String cardDescriptionThree = "Shopping";
    int idThree = 1;

    @Test
    void aValidInstanceOfCreditCardAccount() {
        CreditCardAccount creditCardAccount = new CreditCardAccount(withdrawlLimitOne, cardDescriptionOne, idOne);

        assertNotNull(creditCardAccount);
    }

    @Test
    void aValidInstanceOfCreditCardAccountWithNullDescription() {
        String cardDescriptionNull = null;
        CreditCardAccount creditCardAccount = new CreditCardAccount(withdrawlLimitOne, cardDescriptionNull, idOne);
        String expected = "Credit Card Account - Account #1";

        assertNotNull(creditCardAccount);
        assertEquals(creditCardAccount.getDescription(), expected);
    }

    @Test
    void aValidInstanceOfCreditCardAccountWithEmptyDescription() {
        String cardDescriptionNull = "";
        CreditCardAccount creditCardAccount = new CreditCardAccount(withdrawlLimitOne, cardDescriptionNull, idOne);
        String expected = "Credit Card Account - Account #1";

        assertNotNull(creditCardAccount);
        assertEquals(creditCardAccount.getDescription(), expected);
    }

    @Test
    void assertThrowWithdrawLimitInvalidLessThanZero() {
        double invalidWithdrawLimit = -1;
        assertThrows(Exception.class, () -> new CreditCardAccount(invalidWithdrawLimit, cardDescriptionOne, idOne));
    }

    @Test
    void assertThrowWithdrawLimitInvalidNull() {
        Double invalidWithdrawLimit = null;
        assertThrows(Exception.class, () -> new CreditCardAccount(invalidWithdrawLimit, cardDescriptionOne, idOne));
    }

    @Test
    void compareSameInstance() {
        CreditCardAccount creditCardAccount = new CreditCardAccount(withdrawlLimitOne, cardDescriptionOne, idOne);
        assertEquals(creditCardAccount, creditCardAccount);
        assertSame(creditCardAccount, creditCardAccount);
    }

    @Test
    void compareWithInstanceOfAnotherClass() {
        CreditCardAccount creditCardAccount = new CreditCardAccount(withdrawlLimitOne, cardDescriptionOne, idOne);
        String anotherInstance = "creditCardAccount";

        assertNotSame(creditCardAccount, anotherInstance);
        assertNotEquals(creditCardAccount, anotherInstance);
    }

    @Test
    void compareDiferentInstanceWithSameIDBalanceAndWithdrawalLimit() {
        CreditCardAccount creditCardAccountOne = new CreditCardAccount(withdrawlLimitThree, cardDescriptionThree, idThree);
        CreditCardAccount creditCardAccountTwo = new CreditCardAccount(withdrawlLimitOne, cardDescriptionOne, idOne);

        assertEquals(creditCardAccountOne, creditCardAccountTwo);
        assertNotSame(creditCardAccountOne, creditCardAccountTwo);
    }

    @Test
    void compareDiferentInstanceWithSameBalanceAndWithdrawalLimit() {
        CreditCardAccount creditCardAccountOne = new CreditCardAccount(withdrawlLimitOne, cardDescriptionOne, idOne);
        CreditCardAccount creditCardAccountTwo = new CreditCardAccount(withdrawlLimitOne, cardDescriptionOne, idTwo);

        assertNotEquals(creditCardAccountOne, creditCardAccountTwo);
        assertNotSame(creditCardAccountOne, creditCardAccountTwo);
    }
}