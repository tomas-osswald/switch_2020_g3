package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

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
}