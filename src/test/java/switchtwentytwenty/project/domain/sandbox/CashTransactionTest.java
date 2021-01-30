package switchtwentytwenty.project.domain.sandbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CashTransactionTest {
    Date date = new Date();
    Category category = new StandardCategory("lel", null, 2);
    TransactionData transactionData = new TransactionData("test", 2.2, date, category);
    Account cashAccount = new CashAccount("test", 2.2, 2);
    //Transaction Data
    int familyID = 2;
    String familyMemberCC = "000000000BC4";
    int accountID = 2;
    double transactionAmmount = 2.2;
    int categoryID = 2;


    TransferenceDTO dto = new TransferenceDTO(familyID, familyMemberCC, accountID, transactionAmmount, categoryID, "test", date);


    @Test
    void cashTransactionConstructorTest() {

        CashTransaction cashTransaction = new CashTransaction( cashAccount, category, dto);

        Assertions.assertNotNull(cashTransaction);
    }



    @Test
    void getTransactionData() {

        CashTransaction cashTransaction = new CashTransaction(cashAccount, category, dto);
        TransactionData result = cashTransaction.getTransactionData();
        assertNotNull(result);
    }
}