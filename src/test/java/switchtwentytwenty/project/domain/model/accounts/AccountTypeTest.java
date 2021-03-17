package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTypeTest {

    @Test
    void getAccountTypeAssertNotNull() {
        AccountType accountType = AccountType.CASHACCOUNT;
        assertNotNull(accountType);
    }




}