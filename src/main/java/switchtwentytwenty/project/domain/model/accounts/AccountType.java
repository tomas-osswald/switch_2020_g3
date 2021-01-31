package switchtwentytwenty.project.domain.model.accounts;

public class AccountType {
    private AccountTypeEnum accountTypeEnum;

    public AccountType(AccountTypeEnum accountTypeEnum){
        this.accountTypeEnum = accountTypeEnum;
    }

    public AccountTypeEnum getAccountType() {
        return this.accountTypeEnum;
    }
}
