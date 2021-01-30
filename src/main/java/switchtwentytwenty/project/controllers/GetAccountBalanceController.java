package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class GetAccountBalanceController {
    private final Application fmmApplication;

    public GetAccountBalanceController(Application fmmApplication) {
        this.fmmApplication = fmmApplication;
    }

    public double getAccountBalance(int familyID, String CCNumber, int accountID) {
        FamilyService familyService = this.fmmApplication.getFamilyService();
        Family family = familyService.getFamily(familyID);
        AccountService accountService = new AccountService();
        FamilyMember familyMember = family.getFamilyMember(CCNumber);
        Account account = accountService.getAccount(familyMember, accountID);

        double accountBalance = account.getBalance();
        //MoneyValue accountBalance = account.getMoneyBalance().getValue();

        return accountBalance;
    }
}
