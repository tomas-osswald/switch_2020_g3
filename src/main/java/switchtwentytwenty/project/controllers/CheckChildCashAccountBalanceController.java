package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.services.RelationService;

public class CheckChildCashAccountBalanceController {

    private final Application ffmAplication;

    public CheckChildCashAccountBalanceController (Application app){
        this.ffmAplication = app;
    }

    /**
     *
     * @param familyID
     * @param parentID
     * @param childID
     * @param accountID
     * @return If it has success returns current Balance from an account. If it fails, the catch will
     * define the current balance as -1, for test purposes, because the Cash Account Balance is supposed to never be negative
     */
    //Double para evitar para já enviar objeto de negócio para a UI
    public Double checkChildCashAccountBalance (int familyID, String parentID, String childID, int accountID){
        Double currentBalance;
        FamilyService familyService = ffmAplication.getFamilyService();
        try {
           Family targetFamily = familyService.getFamily(familyID);
           FamilyMember parent = targetFamily.getFamilyMemberByID(parentID);
           FamilyMember child = targetFamily.getFamilyMemberByID(childID);
           RelationService relationService = new RelationService();
           relationService.verifyParenthood(targetFamily, parent, child);
           AccountService accountService = new AccountService();
           MoneyValue accountValue = accountService.checkChildCashAccountBalance(accountID, child);
           currentBalance = accountValue.getValue();
        } catch (Exception exception) {
            currentBalance = - 1.00;
        }
        return currentBalance;
        }
    }








