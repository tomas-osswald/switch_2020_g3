package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.dtos.MoneyValue;

public class GetAccountBalanceController {
    private final Application fmmApplication;

    public GetAccountBalanceController(Application fmmApplication) {
        this.fmmApplication = fmmApplication;
    }

    public MoneyValue getAccountBalance(int familyID, String CCNumber, int accountID) {
        //family
        FamilyService familyService = this.fmmApplication.getFamilyService();
        Family family = familyService.getFamily(familyID);
        FamilyMember familyMember = family.getFamilyMember(CCNumber);

        //account
        AccountService accountService = new AccountService();
        Account account = accountService.getAccount(familyMember, accountID);

        //double accountBalance = account.getBalance();
        MoneyValue accountBalance = account.getMoneyBalance();

        return accountBalance;
    }
}
