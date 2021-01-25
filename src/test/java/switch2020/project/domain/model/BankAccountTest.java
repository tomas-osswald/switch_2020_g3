package switch2020.project.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    String description = "BankAccount do Ze Manel";
    Double balance = 500.00;
    int bankID = 1;
    BankAccount accountTest = new BankAccount(description, balance, bankID);

    /*
    @Test
    void createBankAccount(){
        BankAccount account = new BankAccount("Conta do Bito", 10, 2);
        assertTrue(accountTest.equals(account));
    }
     */
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

    @Test
    void getBalance() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void getBankID() {
    }

    @Test
    void changeBalance() {
    }
}