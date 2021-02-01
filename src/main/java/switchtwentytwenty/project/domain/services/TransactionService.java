package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionService {

    public boolean registerPaymentMyCashAccount(Account targetAccount, StandardCategory category, FamilyCashTransferDTO familyCashTransferDTO) { // TODO: ALTERAR PARA GENERAL CATEGORY
        try {
            if (targetAccount.hasEnoughMoneyForTransaction(familyCashTransferDTO.getTransferAmount())) {
                return targetAccount.registerTransaction(targetAccount, category, familyCashTransferDTO);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
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

    public boolean registerCashTransfer(Account familyAccount, Account targetCashAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO){

        //TODO: Fazer 2 métodos diferentes um para entradas e outro para saidas? ou deviamos passar o valor ou o sinal para registar as transações? B.T.
        return (familyAccount.registerTransaction(targetCashAccount, category, familyCashTransferDTO)||targetCashAccount.registerTransaction(familyAccount, category, familyCashTransferDTO));

    }

}
