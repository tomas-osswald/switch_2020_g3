package switchtwentytwenty.project.domain.model.accounts;

public class AccountType {
    private AccountTypeEnum accountType;

    public AccountType(AccountTypeEnum accountTypeEnum){
        this.accountType = accountTypeEnum;
    }

    public AccountTypeEnum getAccountType() {
        return this.accountType;
    }
}
