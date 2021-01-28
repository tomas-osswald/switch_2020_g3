package switchtwentytwenty.project.domain.services;

import switch2020.project.domain.model.Account;

public class TransactionService {

    public boolean TransferMoneyBetweenCashAccount(Account originAccount, Account destinationAccount, double amount){
        double originAmount = amount * -1;
        double destinationAmount = amount;
        originAccount.changeBalance(originAmount);
        destinationAccount.changeBalance(destinationAmount);
        return true;

    }
}
