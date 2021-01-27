package switch2020.project.domain.sandbox;

import java.util.List;

public class AccountType {

    private String designation;
    private List<AccountType> types;

    public AccountType (String type){
        this.designation = type;
    }

    public void bankSavingsType() {
        final AccountType bankSavings = new AccountType("Savings");
    }

    public void bankType() {
        AccountType bankSavings = new AccountType("Bank");
    }

    public void creditCardType() {
        AccountType bankSavings = new AccountType("Credit Card");
        types.add(bankSavings);
    }
}
