package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardAccountTest {

    //
    String familyMemberID = "000000000ZZ4";
    int familyID = 1;

    //Credit Card Account Data One
    double withdrawlLimitOne = 1000.00;
    String cardDescriptionOne = "Shopping";
    int idOne = 1;
    Double totalDebtOne = 100.00;
    Double interestDebtOne = 50.00;
    CurrencyEnum currencyEnumOne = CurrencyEnum.EURO;

    //Credit Card Account Data Two
    double withdrawlLimitTwo = 500.00;
    String cardDescriptionTwo = "Holidays";
    int idTwo = 2;


    //Credit Card Account Data One
    double withdrawlLimitThree = 1000.00;
    String cardDescriptionThree = "Shopping";
    int idThree = 1;
    Double totalDebtThree = 100.00;
    Double interestDebtThree = 50.00;
    CurrencyEnum currencyEnumThree = CurrencyEnum.EURO;

    @Test
    void aValidInstanceOfCreditCardAccount() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);

        assertNotNull(creditCardAccount);
    }

    @Test
    void aValidInstanceOfCreditCardAccountWithNullDescription() {
        String cardDescriptionNull = null;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionNull, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        String expected = "Credit Card Account - Account #1";

        assertNotNull(creditCardAccount);
        assertEquals(creditCardAccount.getDescription(), expected);
    }

    @Test
    void aValidInstanceOfCreditCardAccountWithEmptyDescription() {
        String cardDescriptionEmpty = "";
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionEmpty, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        String expected = "Credit Card Account - Account #1";

        assertNotNull(creditCardAccount);
        assertEquals(creditCardAccount.getDescription(), expected);
    }

    @Test
    void assertThrowWithdrawLimitInvalidLessThanZero() {
        double invalidWithdrawLimit = -1;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, invalidWithdrawLimit, totalDebtOne, interestDebtOne, currencyEnumOne);
        assertThrows(Exception.class, () -> new CreditCardAccount(addCreditCardAccountDTO, idOne));
    }

    @Test
    void assertThrowWithdrawLimitInvalidNull() {
        Double invalidWithdrawLimit = null;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, invalidWithdrawLimit, totalDebtOne, interestDebtOne, currencyEnumOne);
        assertThrows(Exception.class, () -> new CreditCardAccount(addCreditCardAccountDTO, idOne));
    }

    @Test
    void compareSameInstance() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        assertEquals(creditCardAccount, creditCardAccount);
        assertSame(creditCardAccount, creditCardAccount);
    }

    @Test
    void compareWithInstanceOfAnotherClass() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        String anotherInstance = "creditCardAccount";

        assertNotSame(creditCardAccount, anotherInstance);
        assertNotEquals(creditCardAccount, anotherInstance);
    }

    @Test
    void compareDiferentInstanceWithSameIDBalanceAndWithdrawalLimit() {
        AddCreditCardAccountDTO addCreditCardAccountDTOOne = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        AddCreditCardAccountDTO addCreditCardAccountDTOTwo = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionThree, withdrawlLimitThree, totalDebtThree, interestDebtThree, currencyEnumThree);
        CreditCardAccount creditCardAccountOne = new CreditCardAccount(addCreditCardAccountDTOOne, idThree);
        CreditCardAccount creditCardAccountTwo = new CreditCardAccount(addCreditCardAccountDTOTwo, idOne);

        assertEquals(creditCardAccountOne, creditCardAccountTwo);
        assertNotSame(creditCardAccountOne, creditCardAccountTwo);
    }

    @Test
    void compareDiferentInstanceWithSameBalanceAndWithdrawalLimit() {
        AddCreditCardAccountDTO addCreditCardAccountDTOOne = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        AddCreditCardAccountDTO addCreditCardAccountDTOTwo = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionThree, withdrawlLimitOne, totalDebtThree, interestDebtThree, currencyEnumThree);
        CreditCardAccount creditCardAccountOne = new CreditCardAccount(addCreditCardAccountDTOOne, idOne);
        CreditCardAccount creditCardAccountTwo = new CreditCardAccount(addCreditCardAccountDTOTwo, idTwo);

        assertNotEquals(creditCardAccountOne, creditCardAccountTwo);
        assertNotSame(creditCardAccountOne, creditCardAccountTwo);
    }
}