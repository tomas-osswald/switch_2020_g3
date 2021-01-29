package switchtwentytwenty.project.domain.sandbox;

import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

public class CashTransaction implements Transaction {

    private TransactionData transactionData;
    private Account otherAccount;

    public CashTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO) {
        this.otherAccount = targetAccount;
        String designation = transferenceDTO.getTransactionDesignation();
        double transferedValue = transferenceDTO.getTransferredValue();
        Date transactionDate;
        if (transferenceDTO.getTransactionDate() == null) {
            transactionDate = new Date();
        } else {
            transactionDate = transferenceDTO.getTransactionDate();
        }
        this.transactionData = new TransactionData(designation, transferedValue, transactionDate, category);

    }

}
