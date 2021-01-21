package switch2020.project.domain.model;

public interface Account {

    public int getCashAccountID();

    public double getBalance();

    public void changeBalance(double value);

}
