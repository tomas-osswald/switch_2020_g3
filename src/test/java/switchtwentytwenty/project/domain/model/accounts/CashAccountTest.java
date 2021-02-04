package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum.CASHACCOUNT;
import static switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum.CREDITCARDACCOUNT;

class CashAccountTest {

    CurrencyEnum currency = CurrencyEnum.EURO;

    @Test
    void constructorValidBalanceOne() {
        double balance = 1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorValidBalanceSevenPointTwoFive() {
        double balance = 7.25;
        String designation = "Second Cash Account";
        int cashAccountID = 1011;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorValidBalanceOneMillionPointSevenOne() {
        double balance = 1000000.71;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorInvalidBalanceMinusOne() {
        double balance = -1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        });
    }

    @Test
    void constructorInvalidBalanceMinusTwoHundredPointThree() {
        double balance = -200.03;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        });
    }

    @Test
    void constructorDesignationNull() {
        double balance = 12.5;
        String designation = null;
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorDesignationEmpty() {
        double balance = 12.5;
        String designation = "";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorDesignationBlank() {
        double balance = 12.5;
        String designation = "  ";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void getCashAccountIDGivenIDOneThousandAndOne() {
        double balance = 0;
        String designation = "Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        int expected = 1001;

        int result = cashAccountOne.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getCashAccountIDGivenIDOneThousandAndTwo() {
        double balance = 0;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountTwo = new CashAccount(designation, balance, cashAccountID, currency);
        int expected = 1002;

        int result = cashAccountTwo.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getBalance() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        double expected = 10;

        double result = cashAccountOne.getMoneyBalance().getValue();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceByFive() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        double expected = 15;

        cashAccountOne.credit(new MoneyValue(5.0, CurrencyEnum.EURO));
        double result = cashAccountOne.getMoneyBalance().getValue();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceByMinusFive() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        double expected = 5;

        cashAccountOne.debit(new MoneyValue(5.0, CurrencyEnum.EURO));
        double result = cashAccountOne.getMoneyBalance().getValue();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceInvalidNegativeBalance() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        assertThrows(IllegalStateException.class, () -> {
            cashAccountOne.debit(new MoneyValue(15.0, CurrencyEnum.EURO));
        });
    }

    @Test
    void equalsTrueItself() {
        CashAccount one = new CashAccount("Account", 1, 1, currency);

        assertEquals(one, one);
    }

    @Test
    void equalsFalseNotCashAccountObject() {
        CashAccount one = new CashAccount("Account", 1, 1, currency);
        FamilyService familyService = new FamilyService();

        assertNotEquals(one, familyService);
    }

    @Test
    void equalsTrueSameBalanceAndID() {
        CashAccount one = new CashAccount("Account", 1, 1, currency);
        CashAccount two = new CashAccount("Account", 1, 1, currency);

        assertEquals(one, two);
    }

    @Test
    void equalsFalseSameBalanceDifferentID() {
        CashAccount one = new CashAccount("Account", 1, 1, currency);
        CashAccount two = new CashAccount("Account", 5, 1, currency);

        assertNotEquals(one, two);
    }

    @Test
    void equalsFalseDifferentBalanceSameID() {
        CashAccount one = new CashAccount("Account", 1, 1, currency);
        CashAccount two = new CashAccount("Account", 1.01, 1, currency);

        assertNotEquals(one, two);
    }


    @Test
    void checkAccountType_CashAccount_ExpectingTrue() {
        //Arrange
        CashAccount cashAccount = new CashAccount("cash", 200.00, 1, currency);
        AccountTypeEnum expectedType = CASHACCOUNT;
        //Act
        boolean result = cashAccount.checkAccountType(expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void checkAccountType_CashAccount_ExpectingFalse() {
        //Arrange
        CashAccount cashAccount = new CashAccount("cash", 200.00, 1, currency);
        AccountTypeEnum expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = cashAccount.checkAccountType(expectedType);
        //Assert
        assertFalse(result);
    }

    @Test
    void checkAccountType_CashAccount_ExpectingFalseWithOtherType() {
        //Arrange
        CashAccount cashAccount = new CashAccount("cash", 200.00, 1, currency);
        AccountTypeEnum expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = cashAccount.checkAccountType(expectedType);
        //Assert
        assertFalse(result);
    }


    @Test
    void hasEnoughMoneyForTransaction() {
        MoneyValue transferenceAmount = new MoneyValue(10.0, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount("Acc", 50, 1, currency);
        assertTrue(cashAccount.hasEnoughMoneyForTransaction(transferenceAmount));
    }

    @Test
    void NotEnoughMoneyForTransaction() {
        MoneyValue transferenceAmount = new MoneyValue(100.0, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount("Acc", 50, 1, currency);
        assertFalse(cashAccount.hasEnoughMoneyForTransaction(transferenceAmount));
    }

    @Test
    void NotEnoughMoneyForTransaction_NegativeAmmount() {
        MoneyValue transferenceAmount = new MoneyValue(-10.0, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount("Acc", 50, 1, currency);
        assertThrows(IllegalArgumentException.class, () -> {
            cashAccount.hasEnoughMoneyForTransaction(transferenceAmount);
        });
    }

    @Test
    void testGetBalance() {
        CashAccount cashAccount = new CashAccount("Acc", 50.0, 1, currency);
        MoneyValue expected = new MoneyValue(50.0, CurrencyEnum.EURO);

        MoneyValue result = cashAccount.getMoneyBalance();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void checkCurrencyYen() {
        CashAccount cashAccount = new CashAccount("Bank", 20.00, 1, CurrencyEnum.YEN);
        assertTrue(cashAccount.checkCurrency(CurrencyEnum.YEN));
    }

    @Test
    void checkCurrencyFalse() {
        CashAccount cashAccount = new CashAccount("Bank", 20.00, 1, CurrencyEnum.EURO);

        assertFalse(cashAccount.checkCurrency(CurrencyEnum.YEN));
    }

    @Test
    void hasEnoughMoneyForTransactionTrue() {
        AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(10.00, "Cash", "0000000000ZY4", 1, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount(addCashAccountDTO, 1);
        assertTrue(cashAccount.hasEnoughMoneyForTransaction(new MoneyValue(8.00, CurrencyEnum.EURO)));
    }

    @Test
    void hasEnoughMoneyForTransactionTrueZero() {
        AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(10.00, "Cash", "0000000000ZY4", 1, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount(addCashAccountDTO, 1);
        assertTrue(cashAccount.hasEnoughMoneyForTransaction(new MoneyValue(10.00, CurrencyEnum.EURO)));
    }

    @Test
    void hasEnoughMoneyForTransactionThrowNegativeValue() {
        AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(10.00, "Cash", "0000000000ZY4", 1, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount(addCashAccountDTO, 1);
        assertThrows(Exception.class, () -> cashAccount.hasEnoughMoneyForTransaction(new MoneyValue(-0.01, CurrencyEnum.EURO)));
    }

    @Test
    void hasEnoughMoneyForTransactionTrueZeroTwo() {
        AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(10.00, "Cash", "0000000000ZY4", 1, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount(addCashAccountDTO, 1);
        assertTrue(cashAccount.hasEnoughMoneyForTransaction(new MoneyValue(0.00, CurrencyEnum.EURO)));
    }

    @Test
    void registerTransaction() {
        AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(10.00, "Cash", "0000000000ZY4", 1, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount(addCashAccountDTO, 1);
        CashAccount cashAccountTwo = new CashAccount(addCashAccountDTO, 1);
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(1, "cc", 1, 2.00, CurrencyEnum.EURO, 1, "Shopping", new Date());
        MoneyValue remainingBalance = new MoneyValue(10.0,CurrencyEnum.EURO);

        assertTrue(cashAccount.registerTransaction(cashAccountTwo, new StandardCategory("Shopping", null, 2), true, remainingBalance, familyCashTransferDTO));
    }

    @Test
    void testHashCodeEqualObjects() {
        double balance = 1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;
        CashAccount expected = new CashAccount(designation, balance, cashAccountID, currency);
        CashAccount result = new CashAccount(designation, balance, cashAccountID, currency);
        assertEquals(result.hashCode(), expected.hashCode());
    }

    @Test
    void testHashCodeDifferentObjects() {
        double balance = 1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;
        CashAccount expected = new CashAccount(designation, balance, cashAccountID, currency);
        CashAccount result = new CashAccount(designation, balance, 1002, currency);
        assertNotEquals(result.hashCode(), expected.hashCode());
    }

    @Test
    void getAccountIDAndDescriptionDTO() {
        double balance = 1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);


        AccountIDAndDescriptionDTO expected = new AccountIDAndDescriptionDTO(cashAccountID, designation);

        AccountIDAndDescriptionDTO result = cashAccountOne.getAccountIDAndDescriptionDTO();


        assertEquals(expected, result);
        assertNotNull(result);
    }

    @Test
    void getAccountIDAndDescriptionDTONotEquals() {
        double balance = 1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);


        AccountIDAndDescriptionDTO expected = new AccountIDAndDescriptionDTO(2, designation);

        AccountIDAndDescriptionDTO result = cashAccountOne.getAccountIDAndDescriptionDTO();


        assertNotEquals(expected, result);
        assertNotNull(result);
    }

    @Test
    void getDescriptionNotNull() {
        double balance = 1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        assertNotNull(cashAccountOne.getDescription());
    }

    @Test
    void getDescriptionEmpty() {
        double balance = 1.00;
        String designation = "";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID, currency);
        String notExpected = "";

        assertNotNull(cashAccountOne.getDescription());
        assertNotEquals(cashAccountOne.getDescription(), notExpected);
    }

    @Test
    void checkIfCreditIsMadeInCashAccount() {
        double expected = 2.00;
        double balance = 1.00;
        MoneyValue money = new MoneyValue(1.00,currency);
        String designation = "Saco azul";
        int cashAccountID = 2;
        CashAccount cashAccount = new CashAccount(designation, balance,cashAccountID,currency );
        cashAccount.credit(money);
        double result = cashAccount.getMoneyBalance().getValue();
        assertEquals(expected, result);
    }

    @Test
    void checkIfDebitIsMadeInCashAccount() {
        double expected = 2.00;
        double balance = 5.00;
        MoneyValue money = new MoneyValue(3.00,currency);
        String designation = "Saco azul";
        int cashAccountID = 2;
        CashAccount cashAccount = new CashAccount(designation, balance,cashAccountID,currency );
        cashAccount.debit(money);
        double result = cashAccount.getMoneyBalance().getValue();
        assertEquals(expected, result);
    }
}