package switchtwentytwenty.project.domain.model.accounts;


import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.sandbox.Transaction;
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
    public boolean validateDescription(String description) {
        return description != null && !description.isEmpty() && description.trim().length() != 0;
    }

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



    // BUSINESS METHODS
    public String getDescription() {
        return accountData.getDescription();
    }

    public int getAccountID() {
        return accountData.getAccountID();
    }

    public void changeBalance(double value) { // TODO: adicionar CurrencyEnum como argumento
        MoneyValue newBalance = new MoneyValue(this.accountData.getMoneyValue().getValue() + value, CurrencyEnum.EURO); //this.accountData.getBalance() + value;
        this.accountData.setBalance(newBalance);
    }

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(MoneyValue transferenceAmount) {
        if (transferenceAmount.getValue() < 0)
            throw new IllegalArgumentException("The transaction ammount needs to be a positive value");
        return ((this.getMoneyBalance().getValue() - transferenceAmount.getValue()) >= 0);
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

    public void debit(MoneyValue value) {
        double saldo = this.accountData.getCurrentBalance().getValue();
        double cashout = Math.abs(value.getValue());
        this.accountData.setBalance(saldo-cashout);
    }

    public void credit(MoneyValue value) {
        double saldo = this.accountData.getCurrentBalance().getValue();
        double cashin = Math.abs(value.getValue());
        this.accountData.setBalance(saldo+cashin);
    }

    public boolean checkCurrency(CurrencyEnum currency){
        return accountData.checkCurrency(currency);
    }

    public AccountIDAndDescriptionDTO getAccountIDAndDescriptionDTO(){
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(this.accountData.getAccountID(), accountData.getDescription());
        return accountIDAndDescriptionDTO;
    }
}
