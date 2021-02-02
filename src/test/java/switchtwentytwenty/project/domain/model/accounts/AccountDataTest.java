package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void hasEnoughMoneyForTransaction_NegativeValue() {
        MoneyValue valueSpent = new MoneyValue(-200.0, CurrencyEnum.EURO);
        assertThrows(IllegalArgumentException.class,()->{
            accountData.hasEnoughMoneyForTransaction(valueSpent);
        });
    }

    @Test
    void getListOfMovements() {
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
}