package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

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

    @Test
    void getInterestDebt() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        MoneyValue expected = new MoneyValue(50.0, CurrencyEnum.EURO);
        MoneyValue result = creditCardAccount.getInterestDebt();
        assertEquals(expected, result);
    }

    @Test
    void getAccountID() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        int expected = 1;
        int result = creditCardAccount.getAccountID();
        assertEquals(expected, result);
    }

    @Test
    void getBallance() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        double expected = 100.0;
        double result = creditCardAccount.getBalance();
        assertEquals(expected, result);
    }

    @Test
    void isIDOfThisAccount() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        assertTrue(creditCardAccount.isIDOfThisAccount(1));
    }

    @Test
    void hasEnoughMoneytestFalse() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        assertFalse(creditCardAccount.hasEnoughMoneyForTransaction(1000.1));
    }

    @Test
    void getListOfMovements() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        int expected = 0;
        int result = creditCardAccount.getListOfMovements().size();
        assertEquals(expected, result);

    }

    @Test
    void getMoneyBalance() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        MoneyValue expected = new MoneyValue(100.0, CurrencyEnum.EURO);
        MoneyValue result = creditCardAccount.getMoneyBalance();
        assertEquals(expected, result);

    }

    @Test
    void changeBalanceMoneyValueSuccess() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        MoneyValue balanceChange = new MoneyValue(1.0, CurrencyEnum.EURO);
        creditCardAccount.changeBalance(balanceChange);
        MoneyValue expected = new MoneyValue(101.0, CurrencyEnum.EURO);
        MoneyValue result = creditCardAccount.getMoneyBalance();
        assertEquals(expected, result);

    }

    @Test
    void changeBalanceDoubleSuccess() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        //MoneyValue balanceChange = new MoneyValue(100.0, CurrencyEnum.EURO);
        creditCardAccount.changeBalance(1.0);
        double expected = 99.0;
        double result = creditCardAccount.getMoneyBalance().getValue();
        assertEquals(expected, result);

    }

    @Test
    void changeBalanceMoneyValueFail() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        MoneyValue balanceChange = new MoneyValue(1000000.0, CurrencyEnum.EURO);

        assertThrows(IllegalArgumentException.class, () -> {
            creditCardAccount.changeBalance(balanceChange);
        });

    }

    @Test
    void changeBalanceDoubleFail() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        //MoneyValue balanceChange = new MoneyValue(1000000.0, CurrencyEnum.EURO);

        assertThrows(IllegalArgumentException.class, () -> {
            creditCardAccount.changeBalance(10000000.0);
        });

    }

    @Test
    void creditCardAccountNullInterestDebt() {
        Double nullInterestDebt = null;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, nullInterestDebt, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);

        MoneyValue expected = new MoneyValue(0.00, currencyEnumOne);

        MoneyValue result = creditCardAccount.getInterestDebt();

        assertEquals(expected, result);
    }

    @Test
    void creditCardAccountLessThanZeroInterestDebt() {
        Double nullInterestDebt = -0.01;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, nullInterestDebt, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);

        MoneyValue expected = new MoneyValue(0.00, currencyEnumOne);

        MoneyValue result = creditCardAccount.getInterestDebt();

        assertEquals(expected, result);
    }

    @Test
    void creditCardAccountNullWithdrawalLimit() {
        Double nullWithdrawlLimitOne = null;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, nullWithdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        assertThrows(IllegalArgumentException.class, () -> new CreditCardAccount(addCreditCardAccountDTO, idOne));
    }

    @Test
    void creditCardAccountLessThanZeroInterestDebtTwo() {
        Double nullInterestDebt = 0.01;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, nullInterestDebt, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);

        MoneyValue expected = new MoneyValue(0.01, currencyEnumOne);

        MoneyValue result = creditCardAccount.getInterestDebt();

        assertEquals(expected, result);
    }

    @Test
    void hasEnoughMoneyForTransactionTrue() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        Double transferenceAmount = 10.00;

        assertTrue(creditCardAccount.hasEnoughMoneyForTransaction(transferenceAmount));
    }

    @Test
    void creditCardAccountEqualsZeroInterestDebt() {
        Double zeroInterestDebt = 0.00;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, zeroInterestDebt, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);

        MoneyValue expected = new MoneyValue(0.00, currencyEnumOne);

        MoneyValue result = creditCardAccount.getInterestDebt();

        assertEquals(expected, result);
    }

    @Test
    void changeBalanceMoneyValueInsuccess() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        MoneyValue balanceChange = new MoneyValue(10000.0, CurrencyEnum.EURO);
        assertThrows(IllegalArgumentException.class, () -> creditCardAccount.changeBalance(balanceChange));
    }

    @Test
    void changeBalanceMoneyValueSuccessTwo() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        MoneyValue balanceChange = new MoneyValue(900.00, CurrencyEnum.EURO);
        creditCardAccount.changeBalance(balanceChange);
        MoneyValue expected = new MoneyValue(1000.00, CurrencyEnum.EURO);
        MoneyValue result = creditCardAccount.getMoneyBalance();
        assertEquals(expected, result);

    }

    @Test
    void validInstanceOfCreditCardAccountWithInterestDebtZero() {
        Double zeroInterestDebt = 0.00;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, zeroInterestDebt, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);

        assertNotNull(creditCardAccount);
    }

    @Test
    void interestDebtLessThanTotalDebtTrue() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, interestDebtOne, currencyEnumOne);

        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);

        assertNotNull(creditCardAccount);
    }

    @Test
    void interestDebtLessThanTotalDebtFalse() {
        Double invalidInterestDebt = 5000.00;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, invalidInterestDebt, currencyEnumOne);

        assertThrows(IllegalArgumentException.class, () -> new CreditCardAccount(addCreditCardAccountDTO, idOne));
    }

    @Test
    void registerTransaction() {
        Double zeroInterestDebt = 0.00;
        TransferenceDTO transferenceDto = new TransferenceDTO(3, "sim", 2, 2.2, 0, "test", new Date());
        Category category = new StandardCategory("test", null, 2);
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyID, cardDescriptionOne, withdrawlLimitOne, totalDebtOne, zeroInterestDebt, currencyEnumOne);
        CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, idOne);
        assertTrue(creditCardAccount.registerTransaction(creditCardAccount, category, transferenceDto));
    }
}