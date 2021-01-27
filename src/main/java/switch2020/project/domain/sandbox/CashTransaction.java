package switch2020.project.domain.sandbox;

import switch2020.project.domain.model.Account;
import switch2020.project.domain.model.categories.StandardCategory;
import switch2020.project.domain.utils.TransferenceDTO;

import java.util.Date;

public class CashTransaction implements Transaction {

    private TransactionData transactionData;
    private Account otherAccount;

    public CashTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO) {
        this.otherAccount = targetAccount;
        String designation = transferenceDTO.getTransactionDesignation();
        double transferedValue = transferenceDTO.getTransferedValue();
        Date transactionDate;
        if (transferenceDTO.getTransactionDate() == null) {
            transactionDate = new Date();
        } else {
            transactionDate = transferenceDTO.getTransactionDate();
        }

        this.transactionData = new TransactionData(designation, transferedValue, transactionDate, category);

    }

}
