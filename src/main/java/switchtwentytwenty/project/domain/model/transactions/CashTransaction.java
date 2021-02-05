package switchtwentytwenty.project.domain.model.transactions;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.CashTransferDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.Category;

import java.util.Date;

public class CashTransaction implements Transaction {

    private final TransactionData transactionData;
    private final Account otherAccount;

    public CashTransaction(Account targetAccount, Category category, boolean credit, MoneyValue remainingBalance, FamilyCashTransferDTO familyCashTransferDTO) {
        this.otherAccount = targetAccount;
        String designation = familyCashTransferDTO.getTransactionDesignation();
        MoneyValue transferedValue = new MoneyValue(familyCashTransferDTO.getTransferAmount(), familyCashTransferDTO.getCurrency());
        Date transactionDate = familyCashTransferDTO.getTransactionDate();
        this.transactionData = new TransactionData(designation, transferedValue, credit, remainingBalance, transactionDate, category);
    }

    public CashTransaction(Account targetAccount, Category category, boolean credit, MoneyValue remainingBalance, CashTransferDTO cashTransferDTO) {
        this.otherAccount = targetAccount;
        String designation = cashTransferDTO.getTransactionDesignation();
        MoneyValue transferedValue = new MoneyValue(cashTransferDTO.getTransferAmount(), cashTransferDTO.getCurrency());
        Date transactionDate = cashTransferDTO.getTransactionDate();
        this.transactionData = new TransactionData(designation, transferedValue, credit, remainingBalance, transactionDate, category);
    }

    /**
     * A method that returns the date of a transaction
     *
     * @return transaction date
     */
    public Date getTransactionDate() {
        return transactionData.getTransactionDate();
    }

    /**
     * A method that returns the TransactionData instance that is an attribute in this object.
     *
     * @return TransactionData object.
     */
    public TransactionData getTransactionData() {
        return this.transactionData;
    }

}
