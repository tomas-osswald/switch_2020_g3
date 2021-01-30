package switchtwentytwenty.project.domain.sandbox;

import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

public class CashTransaction implements Transaction {

    private TransactionData transactionData;
    private Account otherAccount;

    public CashTransaction(Account targetAccount, Category category, TransferenceDTO transferenceDTO) {
        this.otherAccount = targetAccount;
        String designation = transferenceDTO.getTransactionDesignation();
        double transferedValue = transferenceDTO.getTransferredValue();
        Date transactionDate = transferenceDTO.getTransactionDate();
        this.transactionData = new TransactionData(designation, transferedValue, transactionDate, category);
    }

    /**
     * A method that returns the date of a transaction
     * @return transaction date
     */
    public Date getTransactionDate() {
        return transactionData.getTransactionDate();
    }

    /**
     * A method that returns the TransactionData instance that is an attribute in this object.
     * @return TransactionData object.
     */
    public TransactionData getTransactionData() {
        return this.transactionData;
    }

}
