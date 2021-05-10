package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.account.Account;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AccountDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateAccountServiceTest {

    @Mock
    IAccountRepository accountRepository;

    @Mock
    AccountInputDTODomainAssembler accountInputDTODomainAssembler;

    @Mock
    InputAccountDTO inputAccountDTO;

    @Mock
    Account account;

    @Mock
    Account savedAccount;

    @Mock
    OutputAccountDTO outputAccountDTO;

    @InjectMocks
    CreateAccountService createAccountService;

    @Disabled
    @Test
    void createAccountSuccessTest() {

        Mockito.when()

    }


}