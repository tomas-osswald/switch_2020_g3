package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    // BankAccount
    String description = "BankAccount do Ze Manel";
    Double balance = 500.00;
    int bankID = 1;
    BankAccount accountTest = new BankAccount(description, balance, bankID);

    // FamilyMember
    int familyID = 1;
    String selfCC = "0000000000ZZ4";

    // Category
    StandardCategory parentStandard = new StandardCategory("root",null,1);

    // CashTransaction
    double transferedValue = 200;
    int categoryID = 2;
    String transactionDesignation = "Luz Novembro";
    Date transactionDate = new Date(2021,1,21);
    TransferenceDTO transacaoDTO1 = new TransferenceDTO(familyID,selfCC,bankID,transferedValue,categoryID,transactionDesignation,transactionDate);

    /** CONSTRUCTOR **/
    @Test
    void createBankAccount_SameObject(){
        BankAccount account = new BankAccount("BankAccount do Ze Manel", 500.00, 1);
        assertTrue(account.equals(account));
    }

    @Test
    void createBankAccount_DifferentObjects(){
        BankAccount account = new BankAccount("BankAccount do Ze Manel", 500.00, 2);
        assertFalse(accountTest.equals(account));
    }

    @Test
    void createBankAccount_NotSameObject(){
        BankAccount account = new BankAccount(description, balance, bankID);
        assertNotSame(accountTest,account);
    }

    @Test
    void createBankAccount_SameObjectData(){
        BankAccount account = new BankAccount("BankAccount do Ze Manel", 500.00, 1);
        assertTrue(accountTest.equals2(account));
    }

    @Test
    void createBankAccount_NotSameObjectData(){
        BankAccount account = new BankAccount(description, balance, 2);
        assertFalse(accountTest.equals2(account));
    }

    /** Description **/
    @Test
    void CreateBankAccount_NullDescription(){
        BankAccount account = new BankAccount(null, 100.0, 1);
        String desc = "BankAccount 1";
        assertEquals(account.getDescription(),desc);
    }

    @Test
    void CreateBankAccount_EmptyDescription(){
        BankAccount account = new BankAccount("", 100.0, 1);
        String desc = "BankAccount 1";
        assertEquals(account.getDescription(),desc);
    }

    @Test
    void CreateBankAccount_BlankDescription(){
        BankAccount account = new BankAccount("         ", 100.0, 1);
        String desc = "BankAccount 1";
        assertEquals(account.getDescription(),desc);
    }

    /** Balance **/
    @Test
    void CreateBankAccount_NullBalance(){
        BankAccount account = new BankAccount("Conta do Bito", null, 2);
        Double expected = 0.00;
        assertEquals(expected, account.getBalance());
    }

    @Test
    void CreateBankAccount_NegativeBalance(){
        BankAccount account = new BankAccount("Conta do Bito", -10.00, 2);
        Double expected = -10.00;
        assertEquals(expected, account.getBalance());
    }

    /** BUSINESS METHODS **/
    @Test
    void getBalance() {
        BankAccount account = new BankAccount(description, 500.00, bankID);
        Double result = account.getBalance();
        Double expected = 500.00;
        assertEquals(result, expected);
    }

    @Test
    void getDescription() {
        BankAccount account = new BankAccount("Conta do Bitó", balance, bankID);
        String result = account.getDescription();
        String expected = "Conta do Bitó";
        assertEquals(result, expected);
    }

    @Test
    void getBankID() {
        BankAccount account = new BankAccount(description,balance,2);
        Integer result = account.getAccountID();
        Integer expected = 2;
        assertEquals(result,expected);
    }

    @Test
    void changeBalance() {
        BankAccount account = new BankAccount(description,balance,bankID);
        account.changeBalance(30.00);
        Double result = account.getBalance();
        Double expected = 530.0;
        assertEquals(result,expected);
    }

    @Test
    void hasEnoughMoneyForTransaction() {
        assertTrue(accountTest.hasEnoughMoneyForTransaction(200));
    }

    @Test
    void NotEnoughMoneyForTransaction() {
        assertFalse(accountTest.hasEnoughMoneyForTransaction(2000));
    }

    @Test
    void NotEnoughMoneyForTransaction_NegaticeAmmount() {
        assertThrows(IllegalArgumentException.class,()->{
            accountTest.hasEnoughMoneyForTransaction(-200);
        });
    }

    @Test
    void registerTransaction() { // Teste para encher chouriços
        assertTrue(accountTest.registerTransaction(accountTest,parentStandard,transacaoDTO1));
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

    /*
    @Test
    void NotChangeBalance_NullValue() {
        BankAccount account = new BankAccount(description, balance,bankID);
        assertThrows(IllegalArgumentException.class,()->{
            account.changeBalance(null);
        });
    }
     */
}