package switch2020.project.domain.model;

public interface Account {

    public int getCashAccountID(); //Name must be changed

    public double getBalance();

    public void changeBalance(double value);

}
