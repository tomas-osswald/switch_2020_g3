package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.List;

public interface Account {

    public int getAccountID();

    public double getBalance();

    public void changeBalance(double value);

    public boolean isIDOfThisAccount(int accountID);

    public boolean hasEnoughMoneyForTransaction(MoneyValue value );

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum);

    public String getDescription();

    public MoneyValue getMoneyBalance();

    public boolean checkCurrency(CurrencyEnum currency);

    public List<Transaction> getListOfMovements();

    public void debit(MoneyValue value);

    public void credit(MoneyValue value);

}
