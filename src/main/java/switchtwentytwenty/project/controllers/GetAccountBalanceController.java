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

    /**
     * Method that obtains the FFMapp that has the FamilyService and AccountService as
     * its attribute. Using the familyID it iterates through the families on FamilyService
     * and after finding the correct family iterates through the list of
     * family members to find the family member. It then finds the corresponding account and returns
     * its balance.
     * @param familyID representing the unique ID given to each family
     * @param ccNumber representing the unique ID from each family member
     * @param accountID representing the unique ID given to each account belonging to a family member
     * @return
     */
    public MoneyValue getAccountBalance(int familyID, String ccNumber, int accountID) {
        //family
        FamilyService familyService = this.fmmApplication.getFamilyService();
        Family family = familyService.getFamily(familyID);
        FamilyMember familyMember = family.getFamilyMember(ccNumber);

        //account
        AccountService accountService = this.fmmApplication.getAccountService();
        MoneyValue currentBalance = accountService.getAccountBalance(familyMember, accountID);

        return currentBalance;
    }
}
