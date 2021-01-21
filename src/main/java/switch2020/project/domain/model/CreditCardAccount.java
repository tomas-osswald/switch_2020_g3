package switch2020.project.domain.model;

public class CreditCardAccount implements Account {

    //Temporary Class



    // Attributes
    private int accountID;
    private double balance;
    private double withrawalLimit;

    public CreditCardAccount(int accountID, double withrawalLimit){
        this.accountID = accountID;
        this.balance = 0;
        this.withrawalLimit = withrawalLimit;
    }

    public int getCashAccountID(){ //Name can be changed
        return this.accountID;
    }

    public double getBalance(){
        return this.balance;
    }

    public void changeBalance(double value){
        if ((this.balance+value)<(withrawalLimit*-1)) throw new IllegalArgumentException("ultrapassa credito");
        this.balance = this.balance + value;
    }
}