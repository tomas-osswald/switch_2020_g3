package switch2020.project.domain.model;

import switch2020.project.domain.sandbox.Category;
import switch2020.project.domain.utils.TransferenceDTO;

public interface Account {

    public int getAccountID();

    public double getBalance();

    public void changeBalance(double value);

    public boolean isIDOfThisAccount(int accountID);

    public boolean hasEnoughMoneyForTransaction(double transferenceAmount );

    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO);

}
