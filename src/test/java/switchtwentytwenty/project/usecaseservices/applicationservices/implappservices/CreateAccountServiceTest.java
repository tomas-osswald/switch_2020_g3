package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.account.*;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AccountDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateAccountServiceTest {

    @Mock
    IAccountRepository accountRepository;

    @Mock
    IAccountRepositoryJPA accountRepositoryJPA;

    @Mock
    AccountDTODomainAssembler accountDTODomainAssembler;

    @Mock
    AccountFactory accountFactory;

    @InjectMocks
    CreateAccountService createAccountService;

    CreateAccountDTO createAccountDTO = new CreateAccountDTO();

    InputAccountDTO inputAccountDTO = new InputAccountDTO("balelas", BigDecimal.valueOf(10), "EUR", "tonyze@latinlover.com", "CashAccount");
    Designation designation = new Designation(inputAccountDTO.getDesignation());
    Monetary initialAmount = new Monetary(inputAccountDTO.getCurrency(), inputAccountDTO.getInitialAmount());
    OwnerID ownerID = new PersonID(inputAccountDTO.getOwnerID());
    String accountType = inputAccountDTO.getAccountType();
    AccountID accountID = new AccountID(123L);

    OutputAccountDTO outputAccountDTO = new OutputAccountDTO("123", "tonyze@latinlover.com", "balelas");
    IAccount personalCashAccount = new CashAccount(accountID, ownerID, designation, null);

    @Test
    void createAccountSuccessTest() {

        IAccount account = new CashAccount(accountID, ownerID, designation, null);
        IAccount savedAccount = new CashAccount(accountID, ownerID, designation, null);

        Mockito.when(accountDTODomainAssembler.designationToDomain(any(InputAccountDTO.class))).thenReturn(designation);
        Mockito.when(accountDTODomainAssembler.initialAmountToDomain(any(InputAccountDTO.class))).thenReturn(initialAmount);
        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(any(InputAccountDTO.class))).thenReturn(ownerID);
        Mockito.when(accountDTODomainAssembler.accountTypeToDomain(any(InputAccountDTO.class))).thenReturn(accountType);
        Mockito.when(accountFactory.createAccount(any(Designation.class), any(Monetary.class), any(OwnerID.class), any(String.class))).thenReturn(account);
        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);
        Mockito.when(accountDTODomainAssembler.toDTO(any(IAccount.class))).thenReturn(outputAccountDTO);

        OutputAccountDTO expected = new OutputAccountDTO("123", "tonyze@latinlover.com", "balelas");

        OutputAccountDTO result = createAccountService.createAccount(inputAccountDTO);

        assertEquals(expected, result);
        assertNotSame(expected, result);

    }

    /*@Test
    void createCashAccountFamilyFailWhenFamilyAlreadyHasOneCashAccount() {

        IAccount account = new CashAccount(accountID, ownerID, designation, null);
        Mockito.when(accountInputDTOAssembler.toInputDTO(any(CreateAccountDTO.class))).thenReturn(inputAccountDTO);
        Mockito.doThrow(AccountAlreadyRegisteredException.class).when(accountRepository.add(account));

        assertThrows(AccountAlreadyRegisteredException.class, () -> createAccountService.createAccount(inputAccountDTO));
    }*/

    @Test
    void getDesignationFromInputAccountDTOSuccess() {

        Mockito.when(accountDTODomainAssembler.designationToDomain(any(InputAccountDTO.class))).thenReturn(designation);

        Designation expected = new Designation("balelas");
        Designation result = accountDTODomainAssembler.designationToDomain(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Test
    void getInitialAmountFromInputAccountDTOSuccess() {

        Mockito.when(accountDTODomainAssembler.initialAmountToDomain(inputAccountDTO)).thenReturn(initialAmount);

        Monetary expected = new Monetary("EUR", BigDecimal.valueOf(10));
        Monetary result = accountDTODomainAssembler.initialAmountToDomain(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Test
    void getOwnerIDFromInputAccountDTOSuccess() {

        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(inputAccountDTO)).thenReturn(ownerID);

        OwnerID expected = new PersonID("tonyze@latinlover.com");
        OwnerID result = accountDTODomainAssembler.ownerIDToDomain(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Test
    void addCashAccountToRepositorySuccessCase() {

        IAccount account = new CashAccount(accountID, ownerID, designation, null);
        IAccount savedAccount = new CashAccount(accountID, ownerID, designation, null);

        Mockito.when(accountDTODomainAssembler.designationToDomain(any(InputAccountDTO.class))).thenReturn(designation);
        Mockito.when(accountDTODomainAssembler.initialAmountToDomain(any(InputAccountDTO.class))).thenReturn(initialAmount);
        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(any(InputAccountDTO.class))).thenReturn(ownerID);
        Mockito.when(accountDTODomainAssembler.accountTypeToDomain(any(InputAccountDTO.class))).thenReturn(accountType);
        Mockito.when(accountFactory.createAccount(any(Designation.class), any(Monetary.class), any(OwnerID.class), any(String.class))).thenReturn(account);
        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);
        Mockito.when(accountDTODomainAssembler.toDTO(any(IAccount.class))).thenReturn(outputAccountDTO);

        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);

        OutputAccountDTO expected = new OutputAccountDTO("123", "tonyze@latinlover.com", "balelas");

        OutputAccountDTO result = createAccountService.createAccount(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Test
    void addCreditCardAccountToRepositorySuccessCase() {
        IAccount account = new CreditCardAccount(accountID, ownerID, designation, null);
        IAccount savedAccount = new CreditCardAccount(accountID, ownerID, designation, null);

        Mockito.when(accountDTODomainAssembler.designationToDomain(any(InputAccountDTO.class))).thenReturn(designation);
        Mockito.when(accountDTODomainAssembler.initialAmountToDomain(any(InputAccountDTO.class))).thenReturn(initialAmount);
        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(any(InputAccountDTO.class))).thenReturn(ownerID);
        Mockito.when(accountDTODomainAssembler.accountTypeToDomain(any(InputAccountDTO.class))).thenReturn(accountType);
        Mockito.when(accountFactory.createAccount(any(Designation.class), any(Monetary.class), any(OwnerID.class), any(String.class))).thenReturn(account);
        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);
        Mockito.when(accountDTODomainAssembler.toDTO(any(IAccount.class))).thenReturn(outputAccountDTO);

        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);

        OutputAccountDTO expected = new OutputAccountDTO("123", "tonyze@latinlover.com", "balelas");

        OutputAccountDTO result = createAccountService.createAccount(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Test
    void addBankAccountToRepositorySuccessCase() {
        IAccount account = new BankAccount(accountID, ownerID, designation, null);
        IAccount savedAccount = new BankAccount(accountID, ownerID, designation, null);

        Mockito.when(accountDTODomainAssembler.designationToDomain(any(InputAccountDTO.class))).thenReturn(designation);
        Mockito.when(accountDTODomainAssembler.initialAmountToDomain(any(InputAccountDTO.class))).thenReturn(initialAmount);
        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(any(InputAccountDTO.class))).thenReturn(ownerID);
        Mockito.when(accountDTODomainAssembler.accountTypeToDomain(any(InputAccountDTO.class))).thenReturn(accountType);
        Mockito.when(accountFactory.createAccount(any(Designation.class), any(Monetary.class), any(OwnerID.class), any(String.class))).thenReturn(account);
        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);
        Mockito.when(accountDTODomainAssembler.toDTO(any(IAccount.class))).thenReturn(outputAccountDTO);

        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);

        OutputAccountDTO expected = new OutputAccountDTO("123", "tonyze@latinlover.com", "balelas");

        OutputAccountDTO result = createAccountService.createAccount(inputAccountDTO);

        assertEquals(expected, result);

    }

    @Test
    void addBankSavingsAccountToRepositorySuccessCase() {
        IAccount account = new BankSavingsAccount(accountID, ownerID, designation, null);
        IAccount savedAccount = new BankSavingsAccount(accountID, ownerID, designation, null);

        Mockito.when(accountDTODomainAssembler.designationToDomain(any(InputAccountDTO.class))).thenReturn(designation);
        Mockito.when(accountDTODomainAssembler.initialAmountToDomain(any(InputAccountDTO.class))).thenReturn(initialAmount);
        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(any(InputAccountDTO.class))).thenReturn(ownerID);
        Mockito.when(accountDTODomainAssembler.accountTypeToDomain(any(InputAccountDTO.class))).thenReturn(accountType);
        Mockito.when(accountFactory.createAccount(any(Designation.class), any(Monetary.class), any(OwnerID.class), any(String.class))).thenReturn(account);
        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);
        Mockito.when(accountDTODomainAssembler.toDTO(any(IAccount.class))).thenReturn(outputAccountDTO);

        Mockito.when(accountRepository.add(any(IAccount.class))).thenReturn(savedAccount);

        OutputAccountDTO expected = new OutputAccountDTO("123", "tonyze@latinlover.com", "balelas");

        OutputAccountDTO result = createAccountService.createAccount(inputAccountDTO);

        assertEquals(expected, result);

    }

   /* @Test
    void addFamilyCashAccountToRepositorySuccessCase() {

        Mockito.when(accountRepository.add(account)).thenReturn(savedAccount);

        IAccount expected = new CashAccount(accountID, ownerID, designation, null);

        IAccount result = accountRepository.add(personalCashAccount);

        assertEquals(expected, result);

    }*/

    /*@Test
    void geOwnerIDPersonFromInputAccountDTOSuccessWhenFamilyIDIsPassedFail() {

        Mockito.when(accountDTODomainAssembler.ownerIDToDomain(inputAccountDTO)).thenReturn(ownerID);

        OwnerID expected = new FamilyID("admin@latinlover.com");
        OwnerID result = accountDTODomainAssembler.ownerIDToDomain(inputAccountDTO);

        assertEquals(expected, result);

    }*/


}