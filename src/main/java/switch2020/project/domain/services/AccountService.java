package switch2020.project.domain.services;

import switch2020.project.domain.model.Account;
import switch2020.project.domain.model.FamilyMember;

import java.util.List;

public class AccountService {
    public boolean createPersonalCashAccount(FamilyMember targetMember, String accountName, double balance) {

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
