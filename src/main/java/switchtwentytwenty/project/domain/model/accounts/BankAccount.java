package switchtwentytwenty.project.domain.model.accounts;


import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;

import switchtwentytwenty.project.domain.model.transactions.Transaction;

import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.List;
import java.util.Objects;

public class BankAccount implements Account {

    private final AccountType accountType = new AccountType(AccountTypeEnum.BANKACCOUNT);
    private AccountData accountData;

    /***** CONSTRUCTORS ******/

    public BankAccount(AddBankAccountDTO addBankAccountDTO, Integer bankAccountID) {
        Double balance = addBankAccountDTO.getBalance();

        if (!validateBalance(addBankAccountDTO.getBalance())) {
            balance = 0.00;
        }
        String description = addBankAccountDTO.getDescription();
        if (!validateDescription(description)){
            description = "BankAccount" + " " + bankAccountID;
        }
        this.accountData = new AccountData(balance, description, bankAccountID, addBankAccountDTO.getCurrency());
    }

    /***** METHODS ******/
    // VALIDATORS

    /**
     * Validate description
     * @param description
     * @return true if it is in correct format | false if it is null, empty or blank
     */
    public boolean validateDescription(String description) {
        return description != null && !description.isEmpty() && description.trim().length() != 0;
    }

    /**
     * Validate balance
     * @param balance
     * @return true if it is in correct format | false if it is null, empty or blank
     */
    public boolean validateBalance(Double balance) {
        return balance != null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountData.getMoneyValue().getValue(),accountData.getAccountID(),accountData.getDescription(),accountData.getListOfMovements());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return accountData.equals(account.accountData);
    }

    /**
     * Gets description
     * @return Gets description
     */
    public String getDescription() {
        return accountData.getDescription();
    }

    /**
     * Get account ID
     * @return accountID
     */
    public int getAccountID() {
        return accountData.getAccountID();
    }

    /**
     * Change balance
     * @param value
     */
    public void changeBalance(double value) { // TODO: adicionar CurrencyEnum como argumento
        MoneyValue newBalance = new MoneyValue(this.accountData.getMoneyValue().getValue() + value, CurrencyEnum.EURO); //this.accountData.getBalance() + value;
        this.accountData.setBalance(newBalance);
    }

    /**
     * Verify if the account exists
     * @param accountID
     * @return true if the is the account | false if it doesn't exists
     */
    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    /**
     * Check if it has enough balance
     * @param transferenceAmount
     * @return true if the account has enough balance | false if the account doesn't have enough balance
     */
    public boolean hasEnoughMoneyForTransaction(MoneyValue transferenceAmount) {
        return true;
    }

    /**
     * check the account type
     * @param accountTypeEnum
     * @return
     */
    public boolean checkAccountType(AccountTypeEnum accountTypeEnum) {
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }

    /**
     * get Money Value balance
     * @return balance
     */
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

    /**
     * Debit amount from the account
     * @param value
     */
    public void debit(MoneyValue value) {
        double saldo = this.accountData.getCurrentBalance().getValue();
        double cashout = Math.abs(value.getValue());
        this.accountData.setBalance(saldo-cashout);
    }

    /**
     * credit amount from the account
     * @param value
     */
    public void credit(MoneyValue value) {
        double saldo = this.accountData.getCurrentBalance().getValue();
        double cashin = Math.abs(value.getValue());
        this.accountData.setBalance(saldo+cashin);
    }

    /**
     * check the currency type
     * @param currency
     * @return
     */
    public boolean checkCurrency(CurrencyEnum currency){
        return accountData.checkCurrency(currency);
    }

    /**
     * get the Account ID and description DTO
     * @return the DTO
     */
    public AccountIDAndDescriptionDTO getAccountIDAndDescriptionDTO(){
        return new AccountIDAndDescriptionDTO(this.accountData.getAccountID(), accountData.getDescription());
    }
}
