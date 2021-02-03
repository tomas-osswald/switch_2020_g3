package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.services.TransactionService;

import java.util.Date;
import java.util.List;

public class GetListOfMovementsBetweenDatesController {

    private final Application ffmApplication;

    public GetListOfMovementsBetweenDatesController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public List<TransactionDataDTO> getListOfMovementsBetweenDates(int familyID, String ccNumber, int accountID, Date startDate, Date endDate) {
        AccountService accountService = ffmApplication.getAccountService();
        TransactionService transactionService = ffmApplication.getTransactionService();
        List<TransactionDataDTO> exceptionList = null;
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            Family targetFamily = familyService.getFamily(familyID);
            FamilyMember targetMember = targetFamily.getFamilyMember(ccNumber);
            Account anAccount = accountService.getAccount(targetMember, accountID);
            exceptionList = transactionService.createListOfMovementsBetweenDates(anAccount, startDate, endDate);
            return  exceptionList;
        } catch (Exception exception) {
            return exceptionList;
        }
    }
}
