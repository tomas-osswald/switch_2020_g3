package switchtwentytwenty.project.domain.sandbox;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;

import java.util.Date;

public class CashTransaction implements Transaction {

    private TransactionData transactionData;
    private Account otherAccount;

    public CashTransaction(Account targetAccount, Category category,boolean credit, FamilyCashTransferDTO familyCashTransferDTO) {
        this.otherAccount = targetAccount;
        String designation = familyCashTransferDTO.getTransactionDesignation();
        MoneyValue transferedValue = new MoneyValue(familyCashTransferDTO.getTransferAmount(),familyCashTransferDTO.getCurrency());
        Date transactionDate = familyCashTransferDTO.getTransactionDate();
        this.transactionData = new TransactionData(designation, transferedValue,credit, transactionDate, category);
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
