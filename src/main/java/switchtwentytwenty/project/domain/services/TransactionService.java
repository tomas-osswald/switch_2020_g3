package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.CashTransaction;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.List;

public class TransactionService {

    public boolean registerPaymentMyCashAccount(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO){ // TODO: ALTERAR PARA GENERAL CATEGORY
        try{
            if ( targetAccount.hasEnoughMoneyForTransaction(transferenceDTO.getTransferedValue()) ){
                return targetAccount.registerTransaction(targetAccount,category,transferenceDTO);
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
}
