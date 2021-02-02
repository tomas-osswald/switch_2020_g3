package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Collections;
import java.util.List;

public class CheckCashAccountBalanceController {

    private final Application ffmapplication;

    public CheckCashAccountBalanceController(Application ffmapplication) {
        this.ffmapplication = ffmapplication;
    }

    /**
     * Method to get a List of Cash Accounts of a Family Member
     *
     * @param selfID   Administrator ID, to verify if is administrator
     * @param otherID  Family Member ID to get list
     * @param familyID Family ID of Administrator and Family Member
     * @return List of AccountIDAndDescriptionDTO
     */
    public List<AccountIDAndDescriptionDTO> getListOfCashAccountsOfAFamilyMember(String selfID, String otherID, int familyID) {
        FamilyService familyService = ffmapplication.getFamilyService();
        if (familyService.verifyAdministratorPermission(familyID, selfID)) {
            Family family = familyService.getFamily(familyID);
            FamilyMember familyMember = family.getFamilyMember(otherID);
            AccountService accountService = new AccountService();
            return accountService.getListOfCashAccountsOfAFamilyMember(familyMember);

        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Method to get Family Cash Account Balance
     *
     * @param selfID   Administrator ID, to verify if is administrator
     * @param familyID Family ID of Administrator Family to get Cash Account Balance
     * @return MoneyValeu with balance and currency of Family Cash Account
     */
    public MoneyValue checkFamilyCashAccountBalance(String selfID, int familyID) {
        FamilyService familyService = ffmapplication.getFamilyService();
        MoneyValue moneyValue;
        try {
            if (familyService.verifyAdministratorPermission(familyID, selfID)) { // verify if is Administrator
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

    /**
     * Method to get a Family Member Cash Account Balance
     *
     * @param selfID    Administrator ID, to verify if is administrator
     * @param otherID   Family Member ID to get Cash Balance
     * @param accountID AccountID to get Balance
     * @param familyID  FamilyID of Administrator and Family Member
     * @return MoneyValeu with balance and currency of a given Cash Account of a Family Member
     */
    public MoneyValue checkFamilyMemberCashAccountBalance(String selfID, String otherID, int accountID, int familyID) {
        FamilyService familyService = ffmapplication.getFamilyService();
        MoneyValue moneyValue;
        try {
            if (familyService.verifyAdministratorPermission(familyID, selfID)) { // verify if is Administrator
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
