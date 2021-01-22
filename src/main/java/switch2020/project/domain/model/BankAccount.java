package switch2020.project.domain.model;

import java.util.Objects;

public class BankAccount {

    private AccountData data;
    private IBAN iban;

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
            throw new IllegalArgumentException("Inserir aproximação do balanço");
        }
        if(!validateID(bankAccountID)){
            throw new IllegalArgumentException("Inserir valor");
        }
        this.data = new AccountData(balance,description,bankAccountID);
    }

    /***** METHODS ******/
    // VALIDATORS
    public boolean validateDescription(String description){
        if(description == null){
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

    public boolean validateID(Integer bankAccountID){
        if( bankAccountID == null){
            return false;
        }
        return true;
    }

    public boolean validateIBAN(String iban){
        if( iban == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return Objects.equals(data, account.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    // BUSINESS METHODS
    public double getBalance(){
        return data.getBalance();
    }

    public String getDescription(){
        return data.getDescription();
    }

    public int getBankID(){
        return data.getAccountID();
    }

    public void changeBalance(Double value){
        if(value == null){
            throw new IllegalArgumentException("Inserir valor válido");
        }
        double newBalance = this.data.getBalance() + value;
        this.data.setBalance(newBalance);
    }

}
