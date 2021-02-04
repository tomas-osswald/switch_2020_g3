package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.CashTransferDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.transactions.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionService {

    /**
     * Register Payment in 1 CashAccount
     * @param targetAccount
     * @param category
     * @param familyCashTransferDTO
     * @return true if the payment is registered | false if the payment is not registed | throws error if there is not enough balance or different currency type
     */

    public boolean registerPaymentMyCashAccount(Account targetAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO) {
        CashAccount targetCashAccount = (CashAccount) targetAccount;
        boolean credit = false;
        MoneyValue transferAmount = new MoneyValue(familyCashTransferDTO.getTransferAmount(), familyCashTransferDTO.getCurrency());
        if (transferAmount.getCurrencyType() == targetCashAccount.getMoneyBalance().getCurrencyType()){
            if (targetAccount.hasEnoughMoneyForTransaction(transferAmount)) {
                targetCashAccount.debit(transferAmount);
                MoneyValue remainingBalance = targetCashAccount.getMoneyBalance();
                targetCashAccount.registerTransaction(null, category, credit, remainingBalance, familyCashTransferDTO);
                return true;
            } else {
                throw new IllegalArgumentException("Not enough balance");
            }
        } else {
            throw new IllegalArgumentException("Insert same currency of this account");
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
     * A method that returns true if a given transaction occurred between two given dates.
     * If the dates are switched, the method will switch them back around.
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

    public boolean registerCashTransferOther(CashAccount originAccount, CashAccount destinationAccount, Category category, CashTransferDTO cashTransferDTO) {
         MoneyValue remainingBalanceOrigin = originAccount.getMoneyBalance();
        MoneyValue remainingBalanceDestination = destinationAccount.getMoneyBalance();
        originAccount.registerTransaction(destinationAccount, category, false,remainingBalanceOrigin, cashTransferDTO);
        destinationAccount.registerTransaction(originAccount, category, true,remainingBalanceDestination, cashTransferDTO);
        return true;
    }

}
