package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccountDataTest {

    double balance = 200;
    String designation = "Cash Account";
    int accountID = 1001;
    AccountData accountData = new AccountData(balance, designation, accountID);

    @Test
    void isIDOfThisAccount_sameIDTrue() {

        int testedID = 1001;

        boolean result = accountData.isIDOfThisAccount(testedID);

        Assertions.assertTrue(result);
    }

    @Test
    void isIDOfThisAccount_sameIDFalse() {

        int testedID = 5000;

        boolean result = accountData.isIDOfThisAccount(testedID);

        Assertions.assertFalse(result);
    }


    @Test
    void hasEnoughMoneyForTransaction_True() {
        MoneyValue valueSpent = new MoneyValue(20.0, CurrencyEnum.EURO);

        boolean result = accountData.hasEnoughMoneyForTransaction(valueSpent);

        Assertions.assertTrue(result);
    }

    @Test
    void hasEnoughMoneyForTransaction_TrueAllMoneyinAccount() {
        MoneyValue valueSpent = new MoneyValue(200.0, CurrencyEnum.EURO);

        boolean result = accountData.hasEnoughMoneyForTransaction(valueSpent);

        Assertions.assertTrue(result);
    }

    @Test
    void hasEnoughMoneyForTransaction_FalseValueIsHigher() {
        MoneyValue valueSpent = new MoneyValue(2000.0, CurrencyEnum.EURO);

        boolean result = accountData.hasEnoughMoneyForTransaction(valueSpent);

        Assertions.assertFalse(result);
    }


    @Test
    void constructorForAccountData_UsingMoneyValue() {
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.EURO);

        Assertions.assertNotNull(accountDataEUR);
    }

    @Test
    void getCreationDate() {
        //Arrange
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.EURO);
        SimpleDateFormat expected = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        //Act
        SimpleDateFormat result = accountDataEUR.getCreationDate();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getMoneyValue() {
        //Arrange
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.EURO);
        MoneyValue expected = new MoneyValue(balance, CurrencyEnum.EURO);
        //Act
        MoneyValue result = accountDataEUR.getMoneyValue();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void setBalance() {
        //Arrange
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.EURO);
        double newAmmount = 5000.00;
        MoneyValue newBalance = new MoneyValue(newAmmount, CurrencyEnum.DOLLAR);
        MoneyValue expected = new MoneyValue(newAmmount, CurrencyEnum.DOLLAR);
        //Act
        accountDataEUR.setBalance(newBalance);
        MoneyValue result = accountDataEUR.getMoneyValue();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void setDescription() {
        //Arrange
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.DOLLAR);
        String newDescription = "Conta em Euros";
        //Act
        accountDataEUR.setDescription(newDescription);
        String result = accountDataEUR.getDescription();
        //Assert
        Assertions.assertEquals(newDescription, result);
    }

    @Test
    void accountDateWithNullCurrency() {
        CurrencyEnum currencyEnumNull = null;
        AccountData accountData = new AccountData(balance, designation, accountID, currencyEnumNull);

        Assertions.assertNotNull(accountData);
    }

    @Test
    void constructorForAccountData_UsingMoneyValueCurrencyNull() {
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, null);

        Assertions.assertNotNull(accountDataEUR);
    }

    @Test
    void testHashCodeEqualObjects() {
        AccountData expected = accountData;
        AccountData result = accountData;
        assertEquals(result.hashCode(), expected.hashCode());
    }

    @Test
    void testHashCodeDifferentObjects() {
        AccountData expected = new AccountData(balance, designation, 1002);
        AccountData result = accountData;
        assertNotEquals(result.hashCode(), expected.hashCode());
    }

    @Test
    void registerCashTransaction_TestSuccess() {
        //Arrange
        CashAccount cashAccount = null;
        Category category = new StandardCategory("Testing", null, 0);
        Date date = new Date();
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(1, "", 1, 25.00, CurrencyEnum.EURO, 1, "Transferencia de Teste", date);
        boolean credit = true;

        //Act
        boolean result = accountData.registerCashTransaction(cashAccount, category, familyCashTransferDTO, credit);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    void registerCashTransaction_TestAccountList() {
        //Arrange
        CashAccount cashAccount = null;
        Category category = new StandardCategory("Testing", null, 0);
        Date date = new Date();
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(1, "", 1, 25.00, CurrencyEnum.EURO, 1, "Transferencia de Teste", date);
        boolean credit = true;
        int expected = 1;
        //Act
        accountData.registerCashTransaction(cashAccount, category, familyCashTransferDTO, credit);
        int result = accountData.getListOfMovements().size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void hasEnoughMoneyForTransaction_TestThrow() {
        MoneyValue negativeValue = new MoneyValue(-200.00, CurrencyEnum.EURO);

        assertThrows(IllegalArgumentException.class, () ->
                accountData.hasEnoughMoneyForTransaction(negativeValue));
    }

    @Test
    void hasEnoughMoneyForTransaction_TestBoundaryNotThrow() {
        MoneyValue zeroValue = new MoneyValue(0.00, CurrencyEnum.EURO);

        assertDoesNotThrow(() -> accountData.hasEnoughMoneyForTransaction(zeroValue));
    }

    @Test
    void getMoneyValue_TestLimitCondition() {
        //Arrange
        AccountData accountDataEUR = new AccountData(0.00, designation, accountID, CurrencyEnum.EURO);
        MoneyValue expected = new MoneyValue(0.00, CurrencyEnum.EURO);
        //Act
        MoneyValue result = accountDataEUR.getMoneyValue();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getMoneyValue_TestLimitCondition_Negative() {
        //Arrange
        AccountData accountDataEUR = new AccountData(-10.00, designation, accountID, CurrencyEnum.EURO);
        MoneyValue expected = new MoneyValue(-10.00, CurrencyEnum.EURO);
        //Act
        MoneyValue result = accountDataEUR.getMoneyValue();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testEquals_sameObject() {
        AccountData expected = accountData;
        AccountData result = accountData;

        assertSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void testEquals_sameInfoDifferentObjects() {
        AccountData expected = accountData;
        AccountData result = new AccountData(balance, designation, accountID);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void testEquals_sameInfoDifferentObjects_NotEquals() {
        AccountData expected = accountData;
        AccountData result = new AccountData(1.00, designation, accountID);

        assertNotSame(expected, result);
        assertNotEquals(expected, result);
    }


}