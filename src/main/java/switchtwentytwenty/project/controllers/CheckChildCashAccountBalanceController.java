package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class CheckChildCashAccountBalanceController {

    private final Application ffmAplication;

    public CheckChildCashAccountBalanceController(Application app) {
        this.ffmAplication = app;
    }

    /**
     * Method to obtain the Cash Account Balance of a Child.
     * First finds the family through the familyID, then, will find the FamilyMembers.
     * It will verify in both moments if Family and both FamilyMembers do exist in the respective Service and Family.
     * Verifies the Relation between both FamilyMembers looking for parental permission.
     * Looks for respective account and verifies if it is a CashAccount.
     *
     * @param familyID
     * @param parentID
     * @param childID
     * @param accountID
     * @return If it has success returns current Balance from an account. If it fails, the catch will
     * define the current balance as -1, for test purposes, because the Cash Account Balance is supposed to never be negative
     */
    public Double checkChildCashAccountBalance(int familyID, String parentID, String childID, int accountID) {
        Double currentBalance;
        try {
            AccountService accountService = ffmAplication.getAccountService();
            MoneyValue accountValue = accountService.checkChildCashAccountBalance(accountID, familyID, parentID, childID);
            currentBalance = accountValue.getValue();
        } catch (Exception exception) {
            currentBalance = -1.00;
        }
        return currentBalance;
    }
}








