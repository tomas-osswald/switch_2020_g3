package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddBankAccountController {

    private final Application ffmApplication;

    public AddBankAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addBankAccount(AddBankAccountDTO addBankAccountDTO) {
        AccountService accountService = new AccountService();
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(addBankAccountDTO.getFamilyID()).getFamilyMember(addBankAccountDTO.getFamilyMemberID());
            return accountService.addBankAccount(addBankAccountDTO, targetMember);
        } catch (Exception e) {
            return false;
        }
    }
    /*public boolean addBankAccount(String accountName, int familyID, String memberCC, Double balance) {
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(memberCC);
            AccountService accountService = this.ffmApplication.getAccountService();
            accountService.addBankAccount(targetMember, accountName, balance);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     */
}
