package switchtwentytwenty.project.domain.sandbox;

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
    Category cat = new StandardCategory("lel", null, 2);
    TransactionData transactionData = new TransactionData("test", 2.2, date, cat);
    Account cashAccount = new CashAccount("test", 2.2, 2);
    TransferenceDTO dto = new TransferenceDTO(2, "ee", 2, 2.2, 2, "test", date);

    @Test
    void constructorTest() {


    }

    @Test
    void getTransactionData() {

        CashTransaction cashTransaction = new CashTransaction(cashAccount, cat, dto);
        TransactionData result = cashTransaction.getTransactionData();
        assertNotNull(result);
    }
}