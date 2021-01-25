package switch2020.project.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    String description = "BankAccount do Ze Manel";
    Double balance = 500.00;
    int bankID = 1;
    BankAccount accountTest = new BankAccount(description, balance, bankID);

    /** CONSTRUCTOR **/
    @Test
    void createBankAccount_SameObject(){
        BankAccount account = new BankAccount("BankAccount do Ze Manel", 500.00, 1);
        assertTrue(account.equals(account));
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
    void NotCreateBankAccount_NullBalance(){
        assertThrows(IllegalArgumentException.class,()-> {
            BankAccount account = new BankAccount("Conta do Bito", null, 2);
        });
    }

    /** ID **/
    @Test
    void NotCreateBankAccount_NullBankAccountID(){
        assertThrows(IllegalArgumentException.class,()-> {
            BankAccount account = new BankAccount("Conta do Bito", 100.0, null);
        });
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
        BankAccount account = new BankAccount(description, balance,2);
        Integer result = account.getBankID();
        Integer expected = 2;
        assertEquals(result,expected);
    }

    @Test
    void changeBalance() {
        BankAccount account = new BankAccount(description, balance,bankID);
        account.changeBalance(30.00);
        Double result = account.getBalance();
        Double expected = 530.0;
        assertEquals(result,expected);
    }

    @Test
    void NotChangeBalance_NullValue() {
        BankAccount account = new BankAccount(description, balance,bankID);
        assertThrows(IllegalArgumentException.class,()->{
            account.changeBalance(null);
        });
    }
}