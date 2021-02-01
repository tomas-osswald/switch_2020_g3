package switchtwentytwenty.project.domain.sandbox;

import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;

import java.util.Date;

public class CashTransaction implements Transaction {

    private TransactionData transactionData;
    private Account otherAccount;

    public CashTransaction(Account targetAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO) {
        this.otherAccount = targetAccount;
        String designation = familyCashTransferDTO.getTransactionDesignation();
        double transferedValue = familyCashTransferDTO.getTransferAmount();
        Date transactionDate = familyCashTransferDTO.getTransactionDate();
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
