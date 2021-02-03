package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;

import switchtwentytwenty.project.domain.model.transactions.Transaction;

import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.List;
import java.util.Objects;

public class BankSavingsAccount implements Account {


    private final AccountType accountType = new AccountType(AccountTypeEnum.BANKSAVINGSACCOUNT);
    // Attributes
    private AccountData accountData;
    private final double interestRate;


    // Constructors
    public BankSavingsAccount(int accountID, String name, Double balance, Double interestRate) {
        try {
            if (!validateBalance(balance)) {
                balance = 0.00;
            }
            this.accountData = new AccountData(balance, name, accountID);
        } catch (InvalidAccountDesignationException exception) {
            String defaultDesignation = "Bank Savings Account with ID" + " " + accountID;
            this.accountData = new AccountData(balance, defaultDesignation, accountID);
        }

        if (!validateInterestRate(interestRate)) {
            interestRate = 0.00;
        }
        this.interestRate = interestRate;
    }


    // Business Methods

    private boolean validateBalance(Double balance) {
        boolean valid = true;
        if (balance == null) {
            valid = false;
        }
        return valid;
    }

    private boolean validateInterestRate(Double interestRate) {
        boolean valid = true;
        if (interestRate == null) {
            valid = false;
        }
        return valid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountData.getAccountID(), accountData.getDescription(), accountData.getListOfMovements(), accountData.getCurrentBalance().getValue(),
                accountData.getCurrentBalance().getCurrency(), interestRate);
    }

    public int getAccountID() {
        return this.accountData.getAccountID();
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankSavingsAccount that = (BankSavingsAccount) o;
        return Double.compare(that.interestRate, interestRate) == 0 && accountData.equals(that.accountData);
    }

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }


    public String getDescription() {
        return accountData.getDescription();
    }

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum) {
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }

    public MoneyValue getMoneyBalance() {
        return this.accountData.getCurrentBalance();
    }

    /**
     * A method that returns the list of movements stored in this account's AccountData attribute
     *
     * @return List of movements
     */
    public List<Transaction> getListOfMovements() {
        return this.accountData.getListOfMovements();
    }

    public AccountIDAndDescriptionDTO getAccountIDAndDescriptionDTO(){
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(this.accountData.getAccountID(), accountData.getDescription());
        return accountIDAndDescriptionDTO;
    }

    public void debit(MoneyValue value) { //expense
        accountData.debit(value);
    }

    public void credit(MoneyValue value) { //expense
        accountData.credit(value);
    }

    public boolean checkCurrency(CurrencyEnum currency) {
        return accountData.checkCurrency(currency);
    }

    /**
     * A method that always returns true, because there has no restrictions for this account type
     *
     * @param value
     * @return
     */
    public boolean hasEnoughMoneyForTransaction(MoneyValue value) {
        return true;
    }

}