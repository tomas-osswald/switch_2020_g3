package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.DTOs.input.CashTransferDTO;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.*;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;

import java.util.ArrayList;
import java.util.List;

import static switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum.CASHACCOUNT;

public class AccountService {

    public boolean createPersonalCashAccount(FamilyMember targetMember, AddCashAccountDTO addCashAccountDTO) {
        int accountID = generateID(targetMember);
        try {
            Account cashAccount = new CashAccount(addCashAccountDTO, accountID);
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
        //if (accountDesignation==null||accountDesignation.trim().length()==0||accountDesignation.isEmpty()) accountDesignation = ("Conta da familia " + targetFamily.getFamilyName());
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
        Account bankAccount = new BankAccount(accountName, balance, accountID);
        targetMember.addAccount(bankAccount);
        return true;
    }

    public boolean createPersonalCreditCardAccount(AddCreditCardAccountDTO addCreditCardAccountDTO, FamilyMember targetMember) {
        int accountID = generateID(targetMember);

        Account creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, accountID);
        targetMember.addAccount(creditCardAccount);
        return true;
    }


    public boolean addBankSavingsAccount(FamilyMember targetMember, String accountName, Double balance, Double interestRate) {
        if (targetMember == null) {
            return false;
        }
        int accountID = generateID(targetMember);
        Account bankSavingsAccount = new BankSavingsAccount(accountID, accountName, balance, interestRate);
        targetMember.addAccount(bankSavingsAccount);
        return true;
    }

    public boolean transferCashFromFamilyToFamilyMember(Family family, FamilyMember familyMember, Category category, FamilyCashTransferDTO familyCashTransferDTO) {

        Account familyAccount = family.getFamilyCashAccount();
        if (familyAccount == null) throw new IllegalArgumentException("Family has no account");
        double transferAmount = familyCashTransferDTO.getTransferAmount();
        //CurrencyEnum currency = familyCashTransferDTO.getCurrency();
        if (!familyAccount.hasEnoughMoneyForTransaction(transferAmount)) return false;
        //if (!familyAccount.checkCurrency(currency)) throw new IllegalArgumentException("Invalid currency")
        int memberAccountID = familyCashTransferDTO.getAccountID();
        Account targetCashAccount = familyMember.getAccount(memberAccountID);
        if(targetCashAccount==null) {
            int familyMemberAccountID = generateID(familyMember);
            double initialBalance = 0.00;
            String accountDesignation = "Cash account for " + familyMember.getName();
            targetCashAccount = new CashAccount(accountDesignation,initialBalance,familyMemberAccountID);
        }
        familyAccount.changeBalance(transferAmount * -1);
        targetCashAccount.changeBalance(transferAmount);

        TransactionService transactionService = new TransactionService();
        return transactionService.registerCashTransfer(familyAccount,targetCashAccount,category,familyCashTransferDTO);
    }

    public boolean transferCashBetweenFamilyMembersCashAccounts(Family family,FamilyMember originFamilyMember, FamilyMember destinationFamilyMember, StandardCategory category, CashTransferDTO cashTransferDTO) {
        int originFamilyMemberAccountID = cashTransferDTO.getOriginAccountID();
        int destinationFamilyMemberAccountID = cashTransferDTO.getDestinationAccountID();
        Account originFamilyMemberAccount = originFamilyMember.getAccount(originFamilyMemberAccountID);
        Account destinationFamilyMemberAccount = destinationFamilyMember.getAccount(destinationFamilyMemberAccountID);
        double transferredValue = cashTransferDTO.getTransferedValue();
        originFamilyMemberAccount.changeBalance(transferredValue * -1);
        destinationFamilyMemberAccount.changeBalance(transferredValue);
        return true;
    }

    public List<AccountIDAndDescriptionDTO> getListOfCashAccountsOfAFamilyMember(FamilyMember familyMember) {
        List<Account> accounts = familyMember.getAccounts();
        return createListOfCashAccounts(accounts);
    }


    public boolean verifyAccountType(Account account, AccountTypeEnum accountTypeEnum) {
        boolean isSameType = false;
        if (account.checkAccountType(accountTypeEnum)) {
            isSameType = true;
        }
        return isSameType;
    }

    private List<AccountIDAndDescriptionDTO> createListOfCashAccounts(List<Account> listOfAccounts) {
        List<AccountIDAndDescriptionDTO> accountIDAndDescriptionDTOS = new ArrayList<>();
        for (Account account : listOfAccounts) {
            if (account.checkAccountType(CASHACCOUNT)) {
                AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(account.getAccountID(), account.getDescription());
                accountIDAndDescriptionDTOS.add(accountIDAndDescriptionDTO);
            }
        }
        return accountIDAndDescriptionDTOS;
    }

    public MoneyValue getFamilyCashAccountBalance(Family family) {
        Account cashAccount = family.getFamilyCashAccount();
        return cashAccount.getMoneyBalance();
    }

    public MoneyValue getFamilyMemberCashAccountBalance(FamilyMember familyMember, int accountID) {
        Account cashAccount = familyMember.getAccount(accountID);
        return cashAccount.getMoneyBalance();
    }

    /**
     * A method that obtains an account with a given ID belonging to a given FamilyMember. If account returned is null, it does not exist and an exception will be thrown.
     *
     * @param aFamilyMember account owner
     * @param accountID     account unique ID
     * @return target account
     */
    public Account getAccount(FamilyMember aFamilyMember, int accountID) {
        Account account = aFamilyMember.getAccount(accountID);
        if (account == null) {
            throw new IllegalArgumentException("Account does not exist");
        }
        return account;
    }

    /**
     * Method to check the Balance of a Cash Account.
     *
     * @param accountID
     * @param member
     * @return
     */

    //TODO: Verificar origem da não-cobertura do NullPointer (Teste de throw está a passar)

    public MoneyValue checkChildCashAccountBalance(int accountID, FamilyMember member){
        MoneyValue currentBalance;
        Account targetAccount = member.getAccount(accountID);
        if (targetAccount == null) {
            throw new NullPointerException("No account with such ID");
        }
        if (!targetAccount.checkAccountType(CASHACCOUNT)){
            throw new IllegalArgumentException("Not a Cash Account");
        }
        currentBalance = targetAccount.getMoneyBalance();
        return currentBalance;
    }
}
