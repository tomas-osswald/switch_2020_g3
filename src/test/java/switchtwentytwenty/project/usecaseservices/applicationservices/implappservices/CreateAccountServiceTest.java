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
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Monetary;
import switchtwentytwenty.project.domain.valueobject.OwnerID;
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
class CreateAccountServiceTest {

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

    @Mock
    Designation designation;

    @Mock
    Monetary initialAmount;

    @Mock
    OwnerID ownerID;

    @InjectMocks
    CreateAccountService createAccountService;

    CreateAccountDTO createAccountDTO = new CreateAccountDTO();

    @Disabled
    @Test
    void createAccountSuccessTest() {

        Mockito.when(accountInputDTOAssembler.toInputDTO(createAccountDTO)).thenReturn(inputAccountDTO);
        Mockito.when(accountRepository.add(account)).thenReturn(savedAccount);
        Mockito.when(accountDTODomainAssembler.toDTO(savedAccount)).thenReturn(outputAccountDTO);

        OutputAccountDTO expected = new OutputAccountDTO();

        OutputAccountDTO result = createAccountService.createAccount(inputAccountDTO);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

   /* @Disabled
    @Test
    void createCashAccountFamilyFailWhenFamilyAlreadyHasOneCashAccount() {

        Mockito.when(accountInputDTOAssembler.toInputDTO(createAccountDTO)).thenReturn(inputAccountDTO);
        Mockito.doThrow(AccountAlreadyRegisteredException.class).when(accountRepository.add(account));
        Mockito.when(accountDTODomainAssembler.toDTO(savedAccount)).thenReturn(outputAccountDTO);

        assertThrows(AccountAlreadyRegisteredException.class, () -> createAccountService.createAccount(inputAccountDTO));
    }

    @Disabled
    @Test
    void  getDesignationFromInputAccountDTOSuccess() {

        Mockito.when(accountDTODomainAssembler.designationToDomain(inputAccountDTO)).thenReturn(designation);

        Designation expected = new Designation("balelas");
        Designation result = accountDTODomainAssembler.designationToDomain(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Disabled
    @Test
    void  getInitialAmmountFromInputAccountDTOSuccess() {

        Mockito.when(accountDTODomainAssembler.initialAmountToDomain(inputAccountDTO)).thenReturn(initialAmount);

        Monetary expected = new Monetary("EUR", 10.00);
        Monetary result = accountDTODomainAssembler.initialAmountToDomain(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Disabled
    @Test
    void  geOwnerIDFromInputAccountDTOSuccess() {

        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(inputAccountDTO)).thenReturn(ownerID);

        OwnerID expected = new OwnerID("tonyze@latinlover.com");
        OwnerID result = accountDTODomainAssembler.ownerIDToDomain(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Disabled
    @Test
    void  geOwnerIDPersonFromInputAccountDTOSuccessWhenFamilyIDIsPassedFail() {

        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(inputAccountDTO)).thenReturn(ownerID);

        OwnerID expected = new OwnerID("tonyze@latinlover.com");
        OwnerID result = accountDTODomainAssembler.ownerIDToDomain(inputAccountDTO);

        assertEquals(expected, result);

    }*/


}