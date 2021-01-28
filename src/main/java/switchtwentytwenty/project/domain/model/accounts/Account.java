package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

public interface Account {

    public int getAccountID();

    public double getBalance();

    public void changeBalance(double value);

    public boolean isIDOfThisAccount(int accountID);

    public boolean hasEnoughMoneyForTransaction(double transferenceAmount );

    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO);

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum);

}
