package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.services.FamilyService;

import java.util.Date;

public class RegisterPaymentMyCashAccountController {

    private final Application ffmApplication;

    public RegisterPaymentMyCashAccountController(Application ffmApplication){
        this.ffmApplication = ffmApplication;
    }

    public boolean RegisterPaymentMyCashAccount(int familyID, String selfCC, int accountID, Date paymentDate, double ammount, Category category) {
        FamilyService famService = this.ffmApplication.getFamilyService();
        FamilyMember myself = famService.getFamily(familyID).getFamilyMember(selfCC);
        CashAccount myCashAccount = myself.getAccount(accountID);
    }

}
