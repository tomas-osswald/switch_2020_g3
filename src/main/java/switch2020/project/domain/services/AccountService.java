package switch2020.project.domain.services;

import switch2020.project.domain.model.Account;
import switch2020.project.domain.model.FamilyMember;

import java.util.List;

public class AccountService {
    public boolean createPersonalCashAccount(FamilyService familyService, String accountName, int familyID, String memberCC, double balance) {
        FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(memberCC);
        int accountID = generateID(targetMember);
        return targetMember.createPersonalCashAccount(accountName, balance, accountID);
    }

    private int generateID(FamilyMember targetMember) {
        int max = 0;
        List<Account> tempList = targetMember.getAccounts();
        for (Account account : tempList) {
            if (max < account.getCashAccountID()) {
                max = account.getCashAccountID();
            }
        }
        return max + 1;
    }
}
