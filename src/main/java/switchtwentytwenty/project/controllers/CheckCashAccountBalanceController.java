package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.DTOs.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.AccountData;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.List;

public class CheckCashAccountBalanceController {

    private final Application ffmapplication;

    public CheckCashAccountBalanceController(Application ffmapplication) {
        this.ffmapplication = ffmapplication;
    }

    public List<AccountIDAndDescriptionDTO> getListOfCashAccountsOfAFamilyMember(String selfID, String otherID, int familyID) {
        FamilyService familyService = ffmapplication.getFamilyService();
        if (familyService.verifyAdministratorPermission(familyID, selfID)) {
            Family family = familyService.getFamily(familyID);
            FamilyMember familyMember = family.getFamilyMember(otherID);
            AccountService accountService = new AccountService();
            return accountService.getListOfCashAccountsOfAFamilyMember(familyMember);

        } else {
            List<AccountIDAndDescriptionDTO> emptyList = new ArrayList<>();
            return emptyList;
        }
    }

    public MoneyValue checkFamilyCashAccountBalance(String selfID, int familyID) {
        FamilyService familyService = ffmapplication.getFamilyService();
        MoneyValue moneyValue;
        try {
            if (familyService.verifyAdministratorPermission(familyID, selfID)) {
                Family family = familyService.getFamily(familyID);
                AccountService accountService = new AccountService();
                moneyValue = accountService.getFamilyCashAccountBalance(family);
            } else { // Not an Administrator
                moneyValue = new MoneyValue(0.00, CurrencyEnum.EURO); //empty money value, isto tem que ser melhorado!!!!!
            }
        } catch (Exception e) { // Family Does Not Exist
            moneyValue = new MoneyValue(0.00, CurrencyEnum.EURO); //empty money value, isto tem que ser melhorado!!!!!

        }
        return moneyValue;
    }

    public MoneyValue checkFamilyMemberCashAccountBalance(String selfID, String otherID, int accountID, int familyID) {
        FamilyService familyService = ffmapplication.getFamilyService();
        MoneyValue moneyValue;
        try {
            if (familyService.verifyAdministratorPermission(familyID, selfID)) {
                Family family = familyService.getFamily(familyID);
                FamilyMember familyMember = family.getFamilyMember(otherID);
                AccountService accountService = new AccountService();
                moneyValue = accountService.getFamilyMemberCashAccountBalance(familyMember, accountID);
            } else {
                moneyValue = new MoneyValue(0.00, CurrencyEnum.EURO); //empty money value, isto tem que ser melhorado!!!!!
            }
        } catch (Exception e) {
            moneyValue = new MoneyValue(0.00, CurrencyEnum.EURO); //empty money value, isto tem que ser melhorado!!!!!
        }
        return moneyValue;
    }
}
