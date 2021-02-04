package switchtwentytwenty.project.domain.sandbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.model.transactions.CashTransaction;
import switchtwentytwenty.project.domain.model.transactions.TransactionData;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CashTransactionTest {
    Date date = new Date();
    Category category = new StandardCategory("lel", null, 2);
    MoneyValue remainingBalance = new MoneyValue(243.0, CurrencyEnum.EURO);
    TransactionData transactionData = new TransactionData("test", new MoneyValue(2.2, CurrencyEnum.EURO), true, remainingBalance, date, category);
    Account cashAccount = new CashAccount("test", 2.2, 2, CurrencyEnum.EURO);
    //Transaction Data
    int familyID = 2;
    String familyMemberCC = "000000000BC4";
    int accountID = 2;
    double transferAmount = 2.2;
    CurrencyEnum currency = CurrencyEnum.EURO;
    int categoryID = 2;


    FamilyCashTransferDTO dto = new FamilyCashTransferDTO(familyID, familyMemberCC, accountID, transferAmount, currency, categoryID, "test", date);


    @Test
    void cashTransactionConstructorTest_credit() {
        boolean credit = true;
        CashTransaction cashTransaction = new CashTransaction(cashAccount, category, credit, remainingBalance, dto);
        Assertions.assertNotNull(cashTransaction);
    }

    @Test
    void cashTransactionConstructorTest_debit() {
        boolean credit = false;
        CashTransaction cashTransaction = new CashTransaction(cashAccount, category, credit, remainingBalance, dto);
        Assertions.assertNotNull(cashTransaction);
    }


    @Test
    void getTransactionData() {
        boolean credit = true;
        CashTransaction cashTransaction = new CashTransaction(cashAccount, category, credit, remainingBalance, dto);
        TransactionData result = cashTransaction.getTransactionData();
        assertNotNull(result);
    }
}