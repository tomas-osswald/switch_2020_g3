package switchtwentytwenty.project.domain.model.transactions;

import java.util.Date;

public interface Transaction {

    public Date getTransactionDate();

    TransactionData getTransactionData();
}
