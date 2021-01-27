package switch2020.project.domain.services;

import switch2020.project.domain.model.*;
import switch2020.project.domain.model.accounts.*;

import java.util.List;

public class AccountService {
    public boolean createPersonalCashAccount(FamilyMember targetMember, String accountDesignation, double initialBalance) {
        int accountID = generateID(targetMember);
        try {
            Account cashAccount = new CashAccount(accountDesignation, initialBalance, accountID);
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

    /**
     * Method to create a family cash account for a family object
     *
     * @param targetFamily       identifier of the family object
     * @param accountDesignation designation for the family cash account
     * @param initialBalance     initial balance for the account
     * @return returns true if an account was created and stored by the family object
     */

    public boolean createFamilyCashAccount(Family targetFamily, String accountDesignation, double initialBalance) {
        //if (accountDesignation==null||accountDesignation.isBlank()||accountDesignation.isEmpty()) accountDesignation = ("Conta da familia " + targetFamily.getFamilyName());
        Account newCashAccount = new CashAccount(accountDesignation, initialBalance, 0);
        if (!targetFamily.hasCashAccount()) {
            targetFamily.addCashAccount(newCashAccount);
            return true;
        } else {
            throw new IllegalArgumentException("This Family already has a Cash Account");
        }
    }

    public boolean addBankAccount(FamilyMember targetMember, String accountName, Double balance) {
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

    public boolean createPersonalCreditCardAccount(FamilyMember targetMember, String accountName,
                                                   double withdrawalLimit) {
        int accountID = generateID(targetMember);

        Account creditCardAccount = new CreditCardAccount(withdrawalLimit, accountName, accountID);
        return targetMember.addAccount(creditCardAccount);
    }


    public boolean addBankSavingsAccount(FamilyMember targetMember, String accountName, Double balance, Double interestRate) {
        int accountID = generateID(targetMember);
        Account bankSavingsAccount = new BankSavingsAccount(accountID, accountName, balance, interestRate);
        targetMember.addAccount(bankSavingsAccount);
        return true;
    }

}
