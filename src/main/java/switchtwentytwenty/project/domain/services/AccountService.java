package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.*;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.*;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.List;

import static switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum.CASHACCOUNT;

public class AccountService {
    private static final String INVALID_CURRENCY = "Invalid currency";
    private FamilyService familyService;


    public AccountService(FamilyService familyService) {
        this.familyService = familyService;

    }

    public AccountService() {

    }

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
        Account newCashAccount = new CashAccount(accountDesignation, initialBalance, 0, CurrencyEnum.EURO);
        if (!targetFamily.hasCashAccount()) {
            targetFamily.addCashAccount(newCashAccount);
            return true;
        } else {
            throw new IllegalArgumentException("This Family already has a Cash Account");
        }
    }

    /**
     * Method to add a Bank Account to a specific Family Member
     *
     * @param addBankAccountDTO DTO containing the required information(e.g. description, balance...) to create a bank account
     * @return return true if nothing was throw
     */
    public boolean addBankAccount(AddBankAccountDTO addBankAccountDTO) {
        FamilyMember targetMember = this.familyService.getFamily(addBankAccountDTO.getFamilyID()).getFamilyMember(addBankAccountDTO.getFamilyMemberID());
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

    /**
     * A method that calls a method to generate a unique ID for the account to be created and calls the BankSavingsAccount constructor.
     * Lastly, it adds the account to a given FamilyMember.
     *
     * @param addBankSavingsAccountDTO DTO that holds all necessary information for the creation of a BankSavingsAccount
     * @return true if account created, null if the given FamilyMember is null.
     */
    public boolean addBankSavingsAccount(AddBankSavingsAccountDTO addBankSavingsAccountDTO) {
        Family targetFamily = this.familyService.getFamily(addBankSavingsAccountDTO.getFamilyID());
        FamilyMember targetMember = targetFamily.getFamilyMember(addBankSavingsAccountDTO.getFamilyMemberID());
        if (targetMember == null) {
            return false;
        }
        int accountID = generateID(targetMember);
        Account bankSavingsAccount = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);
        targetMember.addAccount(bankSavingsAccount);
        return true;
    }

    /**
     * Method that transfers money from a family account to any members family account.
     *
     * @param family                family whose cashAccount is the source of the transfer
     * @param familyMember          familyMember whose cashAccount is the destination of the transfer
     * @param familyCashTransferDTO dto containing the relevant information for the transaction including transferred amount and its currency
     * @return true if the money transfer can occur, false if there's not enough money for the transaction
     */
    public boolean transferCashFromFamilyToFamilyMember(Family family, FamilyMember familyMember, FamilyCashTransferDTO familyCashTransferDTO) {
        if (!family.hasCashAccount()) throw new IllegalArgumentException("Family has no account");
        Account familyAccount = family.getFamilyCashAccount();
        double transferValue = familyCashTransferDTO.getTransferAmount();
        CurrencyEnum currency = familyCashTransferDTO.getCurrency();
        MoneyValue transferAmount = new MoneyValue(transferValue, currency);
        if (!familyAccount.hasEnoughMoneyForTransaction(transferAmount)) return false;
        if (!familyAccount.checkCurrency(currency)) throw new IllegalArgumentException(INVALID_CURRENCY);
        int memberAccountID = familyCashTransferDTO.getAccountID();
        Account targetCashAccount = familyMember.getAccount(memberAccountID);
        if (targetCashAccount == null) {
            int familyMemberAccountID = generateID(familyMember);
            double initialBalance = 0.00;
            String accountDesignation = "Cash account for " + familyMember.getName();
            targetCashAccount = new CashAccount(accountDesignation, initialBalance, familyMemberAccountID, currency);
        }
        if (!targetCashAccount.checkCurrency(currency)) throw new IllegalArgumentException(INVALID_CURRENCY);
        familyAccount.debit(transferAmount);
        targetCashAccount.credit(transferAmount);
        return true;
    }

    /**
     * @param originFamilyMember
     * @param destinationFamilyMember
     * @param cashTransferDTO
     * @return
     */
    public boolean transferCashBetweenFamilyMembersCashAccounts(FamilyMember originFamilyMember, FamilyMember destinationFamilyMember, CashTransferDTO cashTransferDTO) {
        int originFamilyMemberAccountID = cashTransferDTO.getOriginAccountID();
        int destinationFamilyMemberAccountID = cashTransferDTO.getDestinationAccountID();
        Account originFamilyMemberAccount = originFamilyMember.getAccount(originFamilyMemberAccountID);
        Account destinationFamilyMemberAccount = destinationFamilyMember.getAccount(destinationFamilyMemberAccountID);
        CurrencyEnum currency = cashTransferDTO.getCurrency();
        double transferredValue = cashTransferDTO.getTransferAmount();
        MoneyValue transferAmmount = new MoneyValue(transferredValue, currency);
        if (!originFamilyMemberAccount.hasEnoughMoneyForTransaction(transferAmmount)) return false;
        if (!originFamilyMemberAccount.checkCurrency(currency)) throw new IllegalArgumentException(INVALID_CURRENCY);
        if (!destinationFamilyMemberAccount.checkCurrency(currency))
            throw new IllegalArgumentException(INVALID_CURRENCY);
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
                AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = account.getAccountIDAndDescriptionDTO();
                accountIDAndDescriptionDTOS.add(accountIDAndDescriptionDTO);
            }
        }
        return accountIDAndDescriptionDTOS;
    }

    /**
     * @param familyMember Target Family Member
     * @param accountID    Account ID to get balance
     * @return MoneyValue with Balance and Currency of a Family Member Account
     */
    public MoneyValue getAccountBalance(FamilyMember familyMember, int accountID) {
        Account account = getAccount(familyMember, accountID);
        return account.getMoneyBalance();
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
     * Method to check the Balance of a Child Cash Account.
     * Verifies existence of given account. If not, throws exception.
     * Verifies type of the account. If it's not CashAccount throws exception
     *
     * @param accountID identifier of the target account
     * @param member    child to whom the account pertains
     * @return If both validations are true, returns the current Balance.
     */

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
