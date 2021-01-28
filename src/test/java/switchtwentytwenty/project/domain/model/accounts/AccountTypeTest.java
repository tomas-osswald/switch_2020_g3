package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTypeTest {

    @Test
    void getAccountTypeAssertNotNull() {
        AccountType accountType = new AccountType(AccountTypeEnum.CASHACCOUNT);
        assertNotNull(accountType);
    }

    @Test
    void getAccountTypeAssertReturnNotNull() {
        AccountType accountType = new AccountType(AccountTypeEnum.CASHACCOUNT);
        AccountTypeEnum accountTypeEnum = accountType.getAccountType();
        assertNotNull(accountTypeEnum);
    }


}