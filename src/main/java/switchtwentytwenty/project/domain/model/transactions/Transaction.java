package switchtwentytwenty.project.domain.model.transactions;

import switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO;

import java.util.Date;

public interface Transaction {

    TransactionDataDTO createTransactionDataDTO();

    public boolean checkIfMovementBetweenDates(Date startDate, Date endDate);
}
