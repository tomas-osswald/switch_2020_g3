package switch2020.project.domain.model.accounts;

import switch2020.project.domain.sandbox.IBAN;

public class BankAccount implements Account {

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
            balance = 0.00;
        }
        this.data = new AccountData(balance,description,bankAccountID);
    }

    /***** METHODS ******/
    // VALIDATORS
    public boolean validateDescription(String description){
        if(description == null || description.isEmpty() || description.isBlank()){
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

    public boolean validateIBAN(String iban){
        if( iban == null){
            return false;
        }
        return true;
    }

    /**  **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return data.equals(account.data);
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
        return data.getBalance();
    }

    public String getDescription(){
        return data.getDescription();
    }

    public int getAccountID(){
        return data.getAccountID();
    }

    public void changeBalance(double value){
        double newBalance = this.data.getBalance() + value;
        this.data.setBalance(newBalance);
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

}
