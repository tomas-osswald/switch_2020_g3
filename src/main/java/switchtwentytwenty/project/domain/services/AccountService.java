package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.DTOs.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.DTOs.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.*;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;
import switchtwentytwenty.project.domain.utils.CashTransferDTO;

import java.util.ArrayList;
import java.util.List;

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
        return targetMember.addAccount(bankAccount);

    }

    public boolean createPersonalCreditCardAccount(AddCreditCardAccountDTO addCreditCardAccountDTO, FamilyMember targetMember) {
        int accountID = generateID(targetMember);

        Account creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, accountID);
        return targetMember.addAccount(creditCardAccount);
    }


    public boolean addBankSavingsAccount(FamilyMember targetMember, String accountName, Double balance, Double interestRate) {
        int accountID = generateID(targetMember);
        Account bankSavingsAccount = new BankSavingsAccount(accountID, accountName, balance, interestRate);
        targetMember.addAccount(bankSavingsAccount);
        return true;
    }

    public boolean transferCashFromFamilyToFamilyMember(Family family, FamilyMember familyMember, StandardCategory category, TransferenceDTO transferCashDTO) {

        Account familyAccount = family.getFamilyCashAccount();
        if (familyAccount == null) throw new IllegalArgumentException("Family has no account");
        double transferredValue = transferCashDTO.getTransferredValue();
        if (!familyAccount.hasEnoughMoneyForTransaction(transferredValue)) return false;
        //TODO: Discutir; Criar nova conta para family member que não a tenha? Processo de registo de transactions - usar Service?
        int accountID = transferCashDTO.getAccountID();
        Account targetCashAccount = familyMember.getAccount(accountID);
        //Pensar em forma de fazer undo??? criar um metodo para adicionar dinheiro e outro para remover dinheiro??
        familyAccount.changeBalance(transferredValue * -1);
        // Registar movimento gasto - Balance tem que ser negativo
        familyAccount.registerTransaction(targetCashAccount, category, transferCashDTO);
        targetCashAccount.changeBalance(transferredValue);
        //Registar movimento contrario - Balance tem que ser negativo
        targetCashAccount.registerTransaction(familyAccount, category, transferCashDTO);
        
        return true;
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
        List<AccountIDAndDescriptionDTO> accountIDAndDescriptionDTOS = createListOfCashAccounts(accounts);
        return accountIDAndDescriptionDTOS;
    }
/*
    public boolean verifyAccountType(Account account, AccountTypeEnum accountTypeEnum) {
        // acho que terás que usar o Check Account Type das Accounts
        return true; // for Batista, only returning true to compile
    }*/


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
            if (account.checkAccountType(AccountTypeEnum.CASHACCOUNT)) {
                AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(account.getAccountID(), account.getDescription());
                accountIDAndDescriptionDTOS.add(accountIDAndDescriptionDTO);
            }
        }
        return accountIDAndDescriptionDTOS;
    }

    public MoneyValue getFamilyCashAccountBalance(Family family) {
        Account cashAccount = family.getFamilyCashAccount();
        MoneyValue moneyValue = cashAccount.getMoneyBalance();
        return moneyValue;
    }

    public MoneyValue getFamilyMemberCashAccountBalance(FamilyMember familyMember, int accountID) {
        Account cashAccount = familyMember.getAccount(accountID);
        MoneyValue moneyValue = cashAccount.getMoneyBalance();
        return moneyValue;
    }
    /**
     * A method that obtains an account with a given ID belonging to a given FamilyMember
     * @param aFamilyMember account owner
     * @param accountID account unique ID
     * @return target account
     */
    public Account getAccount(FamilyMember aFamilyMember, int accountID) {
        return aFamilyMember.getAccount(accountID);
    }

    /**
     * Method to check the Balance of a Cash Account.
     * @param accountID
     * @param member
     * @return
     */

    //Só assinatura para escrever testes. Falta acrescentar a validação do tipo de conta e respetiva Exceção
    public MoneyValue checkCashAccountBalance (int accountID, FamilyMember member){
        MoneyValue donaldTrump = new MoneyValue(100.00, CurrencyEnum.EURO);
        return donaldTrump;
    }
}
