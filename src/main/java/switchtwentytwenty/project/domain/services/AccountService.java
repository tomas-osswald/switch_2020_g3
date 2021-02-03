package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.*;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.*;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.List;

import static switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum.CASHACCOUNT;

public class AccountService {

    public boolean createPersonalCashAccount(FamilyMember targetMember, AddCashAccountDTO addCashAccountDTO) {
        int accountID = generateID(targetMember);
        try {
            Account cashAccount = new CashAccount(addCashAccountDTO, accountID);
            targetMember.addAccount(cashAccount);
            return true;
        } catch (Exception e) {
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
        Account newCashAccount = new CashAccount(accountDesignation, initialBalance, 0, CurrencyEnum.EURO);
        if (!targetFamily.hasCashAccount()) {
            targetFamily.addCashAccount(newCashAccount);
            return true;
        } else {
            throw new IllegalArgumentException("This Family already has a Cash Account");
        }
    }


    public boolean addBankAccount(AddBankAccountDTO addBankAccountDTO, FamilyMember targetMember) {
        int accountID = generateID(targetMember);

        Account bankAccount = new BankAccount(addBankAccountDTO, accountID);
        targetMember.addAccount(bankAccount);
        return true;
    }

    /**
     * Method to create a Personal Credit Card Account
     *
     * @param addCreditCardAccountDTO DTO with information to create a Credit Card Account instance
     * @param targetMember            Target Member to add a Credit Card Account
     * @return return true if nothing was throw
     */
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
        double transferValue = familyCashTransferDTO.getTransferAmount();
        CurrencyEnum currency = familyCashTransferDTO.getCurrency();
        MoneyValue transferAmount = new MoneyValue(transferValue, currency);
        if (!familyAccount.hasEnoughMoneyForTransaction(transferAmount)) return false;
        if (!familyAccount.checkCurrency(currency)) throw new IllegalArgumentException("Invalid currency");
        int memberAccountID = familyCashTransferDTO.getAccountID();
        Account targetCashAccount = familyMember.getAccount(memberAccountID);
        if (targetCashAccount == null) {
            int familyMemberAccountID = generateID(familyMember);
            double initialBalance = 0.00;
            String accountDesignation = "Cash account for " + familyMember.getName();
            targetCashAccount = new CashAccount(accountDesignation, initialBalance, familyMemberAccountID, currency);
        }
        familyAccount.debit(transferAmount);
        targetCashAccount.credit(transferAmount);
        return true;
    }

    public boolean transferCashBetweenFamilyMembersCashAccounts(Family family, FamilyMember originFamilyMember, FamilyMember destinationFamilyMember, StandardCategory category, CashTransferDTO cashTransferDTO) {
        int originFamilyMemberAccountID = cashTransferDTO.getOriginAccountID();
        int destinationFamilyMemberAccountID = cashTransferDTO.getDestinationAccountID();
        Account originFamilyMemberAccount = originFamilyMember.getAccount(originFamilyMemberAccountID);
        Account destinationFamilyMemberAccount = destinationFamilyMember.getAccount(destinationFamilyMemberAccountID);

        double transferredValue = cashTransferDTO.getTransferedValue();
        MoneyValue transferAmmount = new MoneyValue(transferredValue, null);
        originFamilyMemberAccount.debit(transferAmmount);
        destinationFamilyMemberAccount.credit(transferAmmount);
        return true;
    }

    /**
     * Method to return a List of Cash Account of a given Family Member
     *
     * @param familyMember Given Family Member
     * @return List of Cash Accounts (AccountIDAndDescriptionDTO)
     */
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

    /**
     * Method to create a list of Cash Account of a List of Accounts
     *
     * @param listOfAccounts List of Accounts
     * @return List with Cash Accounts (AccountIDAndDescriptionDTO)
     */
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

    /**
     * Method to get a Family Cash Account Balance
     *
     * @param family Target Family
     * @return MoneyValue with Balance and Currency of Family Cash Account
     */
    public MoneyValue getFamilyCashAccountBalance(Family family) {
        Account cashAccount = family.getFamilyCashAccount();
        return cashAccount.getMoneyBalance();
    }

    /**
     * Method to get a Family Member Cash Account Balance
     *
     * @param familyMember Target Family Member
     * @param accountID    Account ID to get balance
     * @return MoneyValue with Balance and Currency of a Family Member Cash Account
     */
    public MoneyValue getFamilyMemberCashAccountBalance(FamilyMember familyMember, int accountID) {
        Account cashAccount = getAccount(familyMember, accountID);
        if (cashAccount.checkAccountType(CASHACCOUNT)) // verify if is a Cash Account
            return cashAccount.getMoneyBalance();
        else
            throw new IllegalArgumentException("Not a Cash Account");
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
    public MoneyValue checkChildCashAccountBalance(int accountID, FamilyMember member) {
        MoneyValue currentBalance;
        Account targetAccount = member.getAccount(accountID);
        if (targetAccount == null) {
            throw new IllegalArgumentException("No account with such ID");
        }
        if (!targetAccount.checkAccountType(CASHACCOUNT)) {
            throw new IllegalArgumentException("Not a Cash Account");
        }
        currentBalance = targetAccount.getMoneyBalance();
        return currentBalance;
    }

    public Account getFamilyCashAccount(Family family) {
        return family.getFamilyCashAccount();
    }
}
