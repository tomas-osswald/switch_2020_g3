package switch2020.project.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankSavingsAccountTest {

    @Test
    void ConstructorSuccessPositiveInterestRate() {
        String name = "Bank Savings Account";
        double balance = 1.23;
        double interestRate = 3;

        BankSavingsAccount accountOne = new BankSavingsAccount(name , balance, interestRate);
        BankSavingsAccount accountTwo = new BankSavingsAccount(name , balance, interestRate);

        assertNotNull(accountOne);
        assertEquals(accountOne, accountTwo);
        assertNotSame(accountOne, accountTwo);
    }

    @Test
    void ConstructorSuccessNegativeInterestRate() {
    }

    @Test
    void ContructorInvalidNameChangedToDefault() {
    }

    @Test
    void ConstructorInvalidNameChangedToDefaultTwo() {
    }

    @Test
    void ConstructorInvalidInterestRateChangedToDefault() {
    }

    @Test
    void ConstructorInvalidBalanceChangedToDefault() {
    }

    @Test
    void getInterestRatePositiveInterestRate() {
        String name = "Bank Savings Account";
        double balance = 1.23;
        double interestRate = 3;
        BankSavingsAccount account = new BankSavingsAccount(name , balance, interestRate);
        double expected = 3;

        double result = account.getInterestRate();

        assertEquals(expected, result, 0.01);
    }

    @Test
    void getInterestRateNegativeInterestRate() {
    }

    @Test
    void getInterestRateZeroInterestRate() {
    }

    @Test
    void equalsTrueSameAccount() {

    }

    @Test
    void equalsTrueDifferentAccounts() {

    }

    @Test
    void equalsFalseNotSameInstance() {

    }

    @Test
    void equalsFalseDifferentAccount() {

    }

}