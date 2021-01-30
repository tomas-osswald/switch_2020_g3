package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

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
        double valueSpent = 20;

        boolean result = accountData.hasEnoughMoneyForTransaction(valueSpent);

        Assertions.assertTrue(result);
    }

    @Test
    void hasEnoughMoneyForTransaction_TrueAllMoneyinAccount() {
        double valueSpent = 200;

        boolean result = accountData.hasEnoughMoneyForTransaction(valueSpent);

        Assertions.assertTrue(result);
    }
    @Test
    void hasEnoughMoneyForTransaction_FalseValueIsHigher() {
        double valueSpent = 2000;

        boolean result = accountData.hasEnoughMoneyForTransaction(valueSpent);

        Assertions.assertFalse(result);
    }

    @Test
    void getListOfMovements() {
    }

    @Test
    void constructorForAccountData_UsingMoneyValue(){
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.EURO);

        Assertions.assertNotNull(accountDataEUR);
    }

    @Test
    void getCreationDate() {
        //Arrange
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.EURO);
        Date expected = new Date();
        //Act
        Date result = accountDataEUR.getCreationDate();
        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    void getMoneyValue() {
        //Arrange
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.EURO);
        MoneyValue expected = new MoneyValue(balance,CurrencyEnum.EURO);
        //Act
        MoneyValue result = accountDataEUR.getMoneyValue();
        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    void setBalance() {
        //Arrange
        AccountData accountDataEUR = new AccountData(balance, designation, accountID, CurrencyEnum.EURO);
        double newAmmount = 5000.00;
        MoneyValue newBalance = new MoneyValue(newAmmount,CurrencyEnum.DOLLAR);
        MoneyValue expected = new MoneyValue(newAmmount,CurrencyEnum.DOLLAR);
        //Act
        accountDataEUR.setBalance(newBalance);
        MoneyValue result = accountDataEUR.getMoneyValue();
        //Assert
        Assertions.assertEquals(expected,result);
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
        Assertions.assertEquals(newDescription,result);
    }
}