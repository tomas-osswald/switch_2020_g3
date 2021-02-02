package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    // BankAccount
    String description = "BankAccount do Ze Manel";
    Double balance = 500.00;
    int bankID = 1;
    CurrencyEnum currency = CurrencyEnum.EURO;
    BankAccount accountTest = new BankAccount(description, balance, bankID, currency);

    // FamilyMember
    int familyID = 1;
    String selfCC = "0000000000ZZ4";

    // Category
    StandardCategory parentStandard = new StandardCategory("root", null, 1);

    // CashTransaction
    double transferAmount =200.0;
    int categoryID = 2;
    String transactionDesignation = "Luz Novembro";
    Date transactionDate = new Date(2021, 1, 21);
    FamilyCashTransferDTO transacaoDTO1 = new FamilyCashTransferDTO(familyID, selfCC, bankID, transferAmount, currency, categoryID, transactionDesignation, transactionDate);

    /**
     * CONSTRUCTOR
     **/
    @Test
    void createBankAccount_SameObject() {
        BankAccount account = new BankAccount("BankAccount do Ze Manel", 500.00, 1, currency);
        assertTrue(account.equals(account));
    }

    @Test
    void createBankAccount_DifferentObjects() {
        BankAccount account = new BankAccount("BankAccount do Ze Manel", 500.00, 2, currency);
        assertFalse(accountTest.equals(account));
    }

    @Test
    void createBankAccount_DifferentObject() {
        BankAccount account = new BankAccount(description, balance, bankID, CurrencyEnum.EURO);
        assertNotSame(accountTest, account);
    }

    @Test
    void createBankAccount_SameObjectData() {
        BankAccount account = new BankAccount(description, balance, bankID, currency);
        assertTrue(accountTest.equals(account));
    }

    @Test
    void createBankAccount_NotSameObjectData() {
        BankAccount account = new BankAccount(description, balance, 2, CurrencyEnum.EURO);
        assertFalse(accountTest.equals(account));
    }

    /**
     * Description
     **/
    @Test
    void CreateBankAccount_NullDescription() {
        BankAccount account = new BankAccount(null, 100.0, 1, CurrencyEnum.EURO);
        String desc = "BankAccount 1";
        assertEquals(account.getDescription(), desc);
    }

    @Test
    void CreateBankAccount_EmptyDescription() {
        BankAccount account = new BankAccount("", 100.0, 1, CurrencyEnum.EURO);
        String desc = "BankAccount 1";
        assertEquals(account.getDescription(), desc);
    }

    @Test
    void CreateBankAccount_BlankDescription() {
        BankAccount account = new BankAccount("         ", 100.0, 1, CurrencyEnum.EURO);
        String desc = "BankAccount 1";
        assertEquals(account.getDescription(), desc);
    }

    /**
     * Balance
     **/
    @Test
    void CreateBankAccount_NullBalance() {
        BankAccount account = new BankAccount("Conta do Bito", null, 2, CurrencyEnum.EURO);
        Double expected = 0.00;
        assertEquals(expected, account.getMoneyBalance().getValue());
    }

    @Test
    void CreateBankAccount_NegativeBalance() {
        BankAccount account = new BankAccount("Conta do Bito", -10.00, 2, CurrencyEnum.EURO);
        Double expected = -10.00;
        assertEquals(expected, account.getMoneyBalance().getValue());
    }

    /**
     * BUSINESS METHODS
     **/
    @Test
    void getBalance() {
        BankAccount account = new BankAccount(description, 500.00, bankID, CurrencyEnum.EURO);
        Double result = account.getMoneyBalance().getValue();
        Double expected = 500.00;
        assertEquals(result, expected);
    }

    @Test
    void getDescription() {
        BankAccount account = new BankAccount("Conta do Bitó", balance, bankID, CurrencyEnum.EURO);
        String result = account.getDescription();
        String expected = "Conta do Bitó";
        assertEquals(result, expected);
    }

    @Test
    void getBankID() {
        BankAccount account = new BankAccount(description, balance, 2, CurrencyEnum.EURO);
        Integer result = account.getAccountID();
        Integer expected = 2;
        assertEquals(result, expected);
    }

    @Test
    void changeBalance() {
        BankAccount account = new BankAccount(description, balance, bankID, CurrencyEnum.EURO);
        account.changeBalance(30.00);
        Double result = account.getMoneyBalance().getValue();
        Double expected = 530.0;
        assertEquals(result, expected);
    }

    @Test
    void hasEnoughMoneyForTransaction() {
        assertTrue(accountTest.hasEnoughMoneyForTransaction(new MoneyValue(200.0, CurrencyEnum.EURO)));
    }

    @Test
    void NotEnoughMoneyForTransaction() {
        assertFalse(accountTest.hasEnoughMoneyForTransaction(new MoneyValue(2000.0, CurrencyEnum.EURO)));
    }

    @Test
    void NotEnoughMoneyForTransaction_NegaticeAmmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            accountTest.hasEnoughMoneyForTransaction(new MoneyValue(-200.0, CurrencyEnum.EURO));
        });
    }

    @Test
    void checkAccountType_isBankAccount() {
        assertTrue(accountTest.checkAccountType(AccountTypeEnum.BANKACCOUNT));
    }

    @Test
    void checkAccountType_NotCashAccount() {
        assertFalse(accountTest.checkAccountType(AccountTypeEnum.CASHACCOUNT));
    }

    @Test
    void checkAccountType_NotBankSavingsAccount() {
        assertFalse(accountTest.checkAccountType(AccountTypeEnum.BANKSAVINGSACCOUNT));
    }

    @Test
    void checkAccountType_NotCreditCardAccount() {
        assertFalse(accountTest.checkAccountType(AccountTypeEnum.CREDITCARDACCOUNT));
    }

    @Test
    void isIDOfThisAccount() {
        assertTrue(accountTest.isIDOfThisAccount(1));
    }

    @Test
    void NotIDOfThisAccount() {
        assertFalse(accountTest.isIDOfThisAccount(2));
    }

    @Test
    void getListOfMovements() {
        List<Transaction> expected = new ArrayList<>();
        List<Transaction> result = accountTest.getListOfMovements();
        assertEquals(expected, result);
    }

    // TODO: Encontrar o porquê de os hashCodes não serem iguais
    @Test
    void HashCode_SameContent() {
        BankAccount newAccount = new BankAccount(description, balance, bankID, currency);
        assertTrue(newAccount.hashCode() == accountTest.hashCode());
    }

    @Test
    void HashCode_DifferentContent() {
        BankAccount newAccount = new BankAccount("Xpto", 0.0, 2, CurrencyEnum.DOLLAR);
        assertNotEquals(newAccount.hashCode(), accountTest.hashCode());
    }

    @Test
    void Debit_SameBalance() {
        MoneyValue moneyValue = new MoneyValue(300.00, CurrencyEnum.EURO);
        accountTest.debit(moneyValue);
        Double result = accountTest.getMoneyBalance().getValue();
        Double expected = 200.00;
        assertEquals(expected, result);
    }

    @Test
    void Debit_SameObject() {
        MoneyValue moneyValue = new MoneyValue(300.00, CurrencyEnum.EURO);
        accountTest.debit(moneyValue);
        MoneyValue result = accountTest.getMoneyBalance();
        MoneyValue expected = new MoneyValue(200.00,currency);
        assertEquals(expected, result);
    }

    @Test
    void Debit_NegativeAmmountBecomePositive_Samebalances() {
        MoneyValue moneyValue = new MoneyValue(-300.00, CurrencyEnum.EURO);
        accountTest.debit(moneyValue);
        Double result = accountTest.getMoneyBalance().getValue();
        Double expected = 200.00;
        assertEquals(expected, result);
    }

    @Test
    void Debit_NegativeAmmountBecomePositive_SameObject() {
        MoneyValue moneyValue = new MoneyValue(-300.00, CurrencyEnum.EURO);
        accountTest.debit(moneyValue);
        MoneyValue result = accountTest.getMoneyBalance();
        MoneyValue expected = new MoneyValue(200.00,currency);
        assertEquals(expected, result);
    }

    @Test
    void Credit_SameBalance() {
        MoneyValue moneyValue = new MoneyValue(300.00, CurrencyEnum.EURO);
        accountTest.credit(moneyValue);
        Double result = accountTest.getMoneyBalance().getValue();
        Double expected = 800.00;
        assertEquals(expected, result);
    }

    @Test
    void Credit_SameObject() {
        MoneyValue moneyValue = new MoneyValue(300.00, CurrencyEnum.EURO);
        accountTest.credit(moneyValue);
        MoneyValue result = accountTest.getMoneyBalance();
        MoneyValue expected = new MoneyValue(800.00,currency);
        assertEquals(expected, result);
    }

    @Test
    void Credit_NegativeAmmountBecomePositive_Samebalances() {
        MoneyValue moneyValue = new MoneyValue(-300.00, CurrencyEnum.EURO);
        accountTest.credit(moneyValue);
        Double result = accountTest.getMoneyBalance().getValue();
        Double expected = 800.00;
        assertEquals(expected, result);
    }

    @Test
    void Credit_NegativeAmmountBecomePositive_SameObject() {
        MoneyValue moneyValue = new MoneyValue(-300.00, CurrencyEnum.EURO);
        accountTest.credit(moneyValue);
        MoneyValue result = accountTest.getMoneyBalance();
        MoneyValue expected = new MoneyValue(800.00,currency);
        assertEquals(expected, result);
    }

    @Test
    void checkCurrency() {

        boolean result = accountTest.checkCurrency(CurrencyEnum.EURO);

        Assertions.assertTrue(result);
    }

    @Test
    void createBankAccount_NegativeBalance() {
        AddBankAccountDTO dto = new AddBankAccountDTO(-100.00,description,"0000000000ZZ4",1);
        BankAccount account = new BankAccount(dto,1);
        assertTrue(account.equals(account));
    }

    @Test
    void createBankAccount_constructorWithNoCurrency() {
        BankAccount account = new BankAccount(description, 500.00,1);
        assertTrue(account.equals(account));
    }
    @Test
    void createBankAccount_constructorWithNoCurrencyNegativeBalance() {
        BankAccount account = new BankAccount(description, null,1);
        assertTrue(account.equals(account));
    }
    @Test
    void createBankAccount_constructorWithNoCurrencyNoDescription() {
        BankAccount account = new BankAccount("", -12.50,1);
        assertTrue(account.equals(account));
    }

}