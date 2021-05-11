package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.account.AbAccount;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AccountDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AccountInputDTOAssembler;
import switchtwentytwenty.project.exceptions.AccountAlreadyRegisteredException;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateIAccountServiceTest {

    @Mock
    IAccountRepository accountRepository;

    @Mock
    AccountInputDTOAssembler accountInputDTOAssembler;

    @Mock
    AccountDTODomainAssembler accountDTODomainAssembler;

    @Mock
    InputAccountDTO inputAccountDTO;

    @Mock
    AbAccount account;

    @Mock
    AbAccount savedAccount;

    @Mock
    OutputAccountDTO outputAccountDTO;

    @InjectMocks
    CreateAccountService createAccountService;

    CreateAccountDTO createAccountDTO = new CreateAccountDTO();


    @Disabled
    @Test
    void createAccountSuccessTest() {

        /*Mockito.when(accountInputDTOAssembler.toInputDTO(createAccountDTO)).thenReturn(inputAccountDTO);
        Mockito.when(accountRepository.add(account)).thenReturn(savedAccount);
        Mockito.when(accountDTODomainAssembler.toDTO(savedAccount)).thenReturn(outputAccountDTO);

        OutputAccountDTO expected = new OutputAccountDTO();

        OutputAccountDTO result = createAccountService.createAccount(inputAccountDTO);

        assertNotSame(expected, result);
        assertEquals(expected, result);*/
    }

    @Disabled
    @Test
    void createCashAccountFamilyFailWhenFamilyAlreadyHasOneCashAccount() {

        /*Mockito.when(accountInputDTOAssembler.toInputDTO(createAccountDTO)).thenReturn(inputAccountDTO);
        Mockito.doThrow(AccountAlreadyRegisteredException.class).when(accountRepository.add(account));
        Mockito.when(accountDTODomainAssembler.toDTO(savedAccount)).thenReturn(outputAccountDTO);

        assertThrows(AccountAlreadyRegisteredException.class, () -> createAccountService.createAccount(inputAccountDTO));*/
    }


}