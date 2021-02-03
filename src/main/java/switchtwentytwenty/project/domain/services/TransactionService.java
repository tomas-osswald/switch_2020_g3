package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.transactions.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionService {

    public boolean registerPaymentMyCashAccount(Account targetAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO) {
        CashAccount targetCashAccount = (CashAccount) targetAccount;
        boolean credit = false;
        MoneyValue transferAmount = new MoneyValue(familyCashTransferDTO.getTransferAmount(), familyCashTransferDTO.getCurrency());
        if (targetAccount.hasEnoughMoneyForTransaction(transferAmount)) {
            targetCashAccount.debit(transferAmount);
            MoneyValue remainingBalance = targetCashAccount.getMoneyBalance();
            targetCashAccount.registerTransaction(null, category, credit, remainingBalance, familyCashTransferDTO);
            return true;
        } else {
            throw new IllegalArgumentException("Not enough balance");
        }
    }

    /**
     * A method that returns a list of movements registered in an account that occurred between two given dates.
     *
     * @param anAccount given account
     * @param startDate first date
     * @param endDate   last date
     * @return the list of transactions between said dates
     */
    public List<TransactionDataDTO> createListOfMovementsBetweenDates(Account anAccount, Date startDate, Date endDate) {
        List<Transaction> listOfMovements = anAccount.getListOfMovements();
        List<TransactionDataDTO> listOfMovementsBetweenDates = new ArrayList<>();

        for (Transaction transaction : listOfMovements)
            if (checkIfMovementBetweenDates(transaction, startDate, endDate)) {
                TransactionDataDTO transactionDTO = new TransactionDataDTO(transaction.getTransactionData());
                listOfMovementsBetweenDates.add(transactionDTO);
            }

        return listOfMovementsBetweenDates;
    }

    /**
     * A method that returns true if a given transaction occurred between two given dates
     *
     * @param aTransaction given transaction
     * @param startDate    first date
     * @param endDate      last date
     * @return true if between given dates, else false
     */
    private boolean checkIfMovementBetweenDates(Transaction aTransaction, Date startDate, Date endDate) {

        // Switch dates if endDate is earlier than startDate
        if (startDate.after(endDate)) {
            Date temp = (Date) startDate.clone();
            startDate = endDate;
            endDate = temp;
        }

        boolean isBetweenDates = false;
        Date transactionDate = aTransaction.getTransactionDate();

        if (transactionDate.after(startDate) && transactionDate.before(endDate)) {
            isBetweenDates = true;
        }
        return isBetweenDates;
    }

    public boolean registerCashTransfer(CashAccount originAccount, CashAccount destinationAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO) {

        MoneyValue remainingBalanceOrigin = originAccount.getMoneyBalance();
        MoneyValue remainingBalanceDestination = destinationAccount.getMoneyBalance();
        originAccount.registerTransaction(destinationAccount, category, false,remainingBalanceOrigin, familyCashTransferDTO);
        destinationAccount.registerTransaction(originAccount, category, true,remainingBalanceDestination, familyCashTransferDTO);
        return true;
    }

}
