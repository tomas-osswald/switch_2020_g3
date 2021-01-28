package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddBankAccountController {

    private final Application ffmApplication;

    public AddBankAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addBankAccount(String accountName, int familyID, String memberCC, Double balance) {

            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(memberCC);
            AccountService accountService = this.ffmApplication.getAccountService();
            try{
                return accountService.addBankAccount(targetMember, accountName, balance);
            }catch(Exception e){
                return false;
            }


    }
}
