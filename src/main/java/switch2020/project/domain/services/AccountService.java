package switch2020.project.domain.services;

import switch2020.project.domain.model.*;

import java.util.List;

public class AccountService {

    public boolean createPersonalCashAccount(FamilyMember targetMember, String accountName, double balance) {
        int accountID = generateID(targetMember);
        try {
            Account cashAccount = new CashAccount(accountName, balance, accountID);
            return targetMember.addAccount(cashAccount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private int generateID(FamilyMember targetMember) {
        int max = 0;
        List<Account> tempList = targetMember.getAccounts();
        for (Account account : tempList) {
            if (max < account.getAccountID()) {
                max = account.getAccountID();
            }
        }
        return max + 1;
    }

    public boolean createFamilyCashAccount(Family targetFamily, double balance) {
        Account newCashAccount = new CashAccount(0, balance);
        if (!targetFamily.hasCashAccount()) {
            targetFamily.addCashAccount(newCashAccount);
            return true;
        } else {
            throw new IllegalArgumentException("This Family already has a Cash Account");
        }
    }

    public boolean addBankAccount(FamilyMember targetMember, String accountName, double balance) {
        int accountID = generateID(targetMember);
        try {
            Account bankAccount = new BankAccount(accountName, balance, accountID);
            targetMember.addAccount(bankAccount);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
