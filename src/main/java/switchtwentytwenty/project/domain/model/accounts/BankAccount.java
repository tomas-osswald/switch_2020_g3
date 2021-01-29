package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.IBAN;

import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.List;

public class BankAccount implements Account {

    private AccountData accountData;
    private IBAN iban;
    private final AccountType accountType = new AccountType(AccountTypeEnum.BANKACCOUNT);

    /***** CONSTRUCTORS ******/
    /*
    public BankAccount(String description, double balance, int bankAccountID, String iban){
        if(!validateDescription(description)){
            description = "BankAccount"+" "+bankAccountID;
        }
        if(!validateBalance(balance)){
            throw new IllegalArgumentException("Inserir aproximação do balanço");
        }
        if(!validateID(bankAccountID)){
            throw new IllegalArgumentException("Inserir valor");
        }
        this.data = new AccountData(balance,description,bankAccountID);

        if(validateIBAN(iban)){
            IBAN ibann = new IBAN(iban);
            this.iban = ibann;
        }
    }

     */

    public BankAccount(String description, Double balance, Integer bankAccountID){
        if(!validateDescription(description)){
            description = "BankAccount"+" "+bankAccountID;
        }
        if(!validateBalance(balance)){
            balance = 0.00;
        }
        this.accountData = new AccountData(balance,description,bankAccountID);
    }

    /***** METHODS ******/
    // VALIDATORS
    public boolean validateDescription(String description){
        if(description == null || description.isEmpty() || description.trim().length()==0){
            return false;
        }
        return true;
    }

    public boolean validateBalance(Double balance){
        if( balance == null){
            return false;
        }
        return true;
    }

    /*
    public boolean validateIBAN(String iban){
        if( iban == null){
            return false;
        }
        return true;
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return accountData.equals(account.accountData);
    }

    public boolean equals2(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return this.getBalance() == account.getBalance() && this.getDescription() == account.getDescription() && this.getAccountID() == account.getAccountID();
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
     */

    // BUSINESS METHODS
    public double getBalance(){
        return accountData.getBalance();
    }

    public String getDescription(){
        return accountData.getDescription();
    }

    public int getAccountID(){
        return accountData.getAccountID();
    }

    public void changeBalance(double value){
        double newBalance = this.accountData.getBalance() + value;
        this.accountData.setBalance(newBalance);
    }
    /*
    public void changeBalance(Double value){
        if(value == null){
            throw new IllegalArgumentException("Inserir valor válido");
        }
        double newBalance = this.data.getBalance() + value;
        this.data.setBalance(newBalance);
    }

     */

    public boolean isIDOfThisAccount(int accountID){
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(double transferenceAmount ){
        return accountData.hasEnoughMoneyForTransaction(transferenceAmount);
    }

    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO){
        return true; // DONT HAVE MEANING IN THIS CLASS
        //return accountData.registerTransaction(targetAccount, category, transferenceDTO);
    }

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum){
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }
    
    public MoneyValue getMoneyBalance() {
        return this.accountData.getCurrentBalance();
    }

    /**
     * A method that returns the list of movements stored in this account's AccountData attribute
     * @return List of movements
     */
    public List<Transaction> getListOfMovements() {
        return this.accountData.getListOfMovements();
    }
}
