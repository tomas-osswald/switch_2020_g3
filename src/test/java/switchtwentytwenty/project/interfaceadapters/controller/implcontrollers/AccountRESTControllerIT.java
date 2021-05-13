package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.AccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.domainjpa.OwnerIDJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.account.AccountFactory;
import switchtwentytwenty.project.domain.aggregates.account.BankAccount;
import switchtwentytwenty.project.domain.aggregates.account.CashAccount;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountInputDTOAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AccountDTODomainAssembler;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IAccountRESTController;
import switchtwentytwenty.project.interfaceadapters.implrepositories.AccountRepository;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateAccountService;
import switchtwentytwenty.project.usecaseservices.applicationservices.implappservices.CreateAccountService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@SpringBootTest
class AccountRESTControllerIT {

    @Mock
    AccountFactory repoAccountFactory;

    @Mock
    AccountDataDomainAssembler mockAccountDataDomainAssembler;

    @Mock
    IAccountRepositoryJPA mockRepositoryJPA;

    @InjectMocks
    AccountRepository accountRepository;

    @Autowired
    ICreateAccountService createAccountService;

    @Autowired
    IAccountInputDTOAssembler accountInputDTOAssembler;

    @Autowired
    AccountDTODomainAssembler accountDTODomainAssembler;

    @Autowired
    IAccountRESTController accountRESTController;

    @Autowired
    AccountFactory accountFactory;


    //Setup
    String designationString = "Conta do tonyZe";
    BigDecimal amount = BigDecimal.valueOf(3);
    String currency = "EUR";
    String ownerIDString = "tonyze@latinlover.com";
    String accountTypeString = "bank";
    String accountIDString = "3";
    AccountType accountType = new AccountType(accountTypeString);

    Long accountIDLong = 3L;
    AccountID accountID = new AccountID(accountIDLong);
    PersonID ownerID = new PersonID(ownerIDString);
    Designation designation = new Designation(designationString);

    CreateAccountDTO createBankAccountDTO = new CreateAccountDTO(designationString, amount, currency, ownerIDString, accountTypeString);

    InputAccountDTO inputAccountDTO = new InputAccountDTO(designationString, amount, currency, ownerIDString, accountTypeString);

    OutputAccountDTO outputAccountDTO = new OutputAccountDTO(designationString, ownerIDString, accountIDString);


    //AccountFactory accountFactory = new AccountFactory();

    Currency currencyObject = Currency.getInstance(currency);
    Monetary monetary = new Monetary(currency, amount);

    IAccount account = new BankAccount(ownerID, designation);

    //JPA

    String personAsOwnerIDJPA = "tonyze@latinlover.com";

    //AccountIDJPA accountIDJPA = new AccountIDJPA(accountIDLong);
    OwnerIDJPA ownerIDJPA = new OwnerIDJPA(personAsOwnerIDJPA);
    Long accountIDJPALong = accountIDLong;

    AccountJPA accountJPA = new AccountJPA(accountIDJPALong, ownerIDJPA, designationString, accountTypeString);
    AccountJPA accountJPATwo = new AccountJPA(accountIDJPALong, ownerIDJPA, designationString, accountTypeString);

    String familyOwnerIDString = "@tonyze@latinlover.com";
    OwnerID familyOwnerID = new FamilyID(familyOwnerIDString);
    String cashAccountType = "cash";
    List emptyMovements = new ArrayList();
    OwnerIDJPA familyAsOwnerIDJPA = new OwnerIDJPA(familyOwnerIDString);
    IAccount familyCashAccount = new CashAccount(accountID, familyOwnerID, designation, emptyMovements);
    AccountJPA familyAccountJPA = new AccountJPA(accountIDJPALong, familyAsOwnerIDJPA, designationString, cashAccountType);


    @Test
    @DisplayName("Integration test with success creating an account")
    void createAccount() {
        CreateAccountService createAccountService = new CreateAccountService(accountRepository, accountDTODomainAssembler, accountFactory);
        AccountRESTController accountRESTController = new AccountRESTController(createAccountService, accountInputDTOAssembler);

       /* List<Movement> movements = new ArrayList<>();
        movements.add(new Movement(new Monetary("EUR", BigDecimal.valueOf(20.00))));


        */
        IAccount account = new BankAccount();
        account.setAccountID(accountID);
        account.setDesignation(designation);
        //account.setMovements(movements);
        account.setOwner(ownerID);

        when(mockAccountDataDomainAssembler.toData(any(IAccount.class))).thenReturn(accountJPA);
        when(mockRepositoryJPA.save(any(AccountJPA.class))).thenReturn(accountJPATwo);
        when(mockAccountDataDomainAssembler.createAccountID(any(AccountJPA.class))).thenReturn(accountID);
        when(mockAccountDataDomainAssembler.createAccountType(any(AccountJPA.class))).thenReturn(accountType);
        when(mockAccountDataDomainAssembler.createDesignation(any(AccountJPA.class))).thenReturn(designation);
        when(mockAccountDataDomainAssembler.createOwnerID(any(AccountJPA.class))).thenReturn(ownerID);
        when(mockAccountDataDomainAssembler.createMovements(any(AccountJPA.class))).thenReturn(new ArrayList<>());
        when(repoAccountFactory.createAccount(any(), any(), any(), any(), any())).thenReturn(account);


        OutputAccountDTO expectedOutputDTO = new OutputAccountDTO(accountIDString, ownerIDString, designationString);
        Link link = linkTo(methodOn(AccountRESTController.class).getAccount(accountIDString)).withSelfRel();
        expectedOutputDTO.add(link);

        ResponseEntity expected = new ResponseEntity(expectedOutputDTO, HttpStatus.CREATED);

        ResponseEntity result = accountRESTController.createAccount(createBankAccountDTO);

        assertEquals(expected.getBody().toString(), result.getBody().toString());
        assertEquals(expected.getStatusCode(), result.getStatusCode());

    }

   /* @Test
    @DisplayName("Integration test expecting account already registered exception")
    void failToCreateAccountWhenProvidingAlreadyExistingAccount() {
        CreateAccountService createAccountService = new CreateAccountService(accountRepository, accountDTODomainAssembler, accountFactory);
        AccountRESTController accountRESTController = new AccountRESTController(createAccountService, accountInputDTOAssembler);

        Optional<AccountJPA> optionalAccountJPA = Optional.of(accountJPA);

        when(mockAccountDataDomainAssembler.toData(any(IAccount.class))).thenReturn(familyAccountJPA);
        when(mockRepositoryJPA.save(any(AccountJPA.class))).thenThrow(AccountAlreadyRegisteredException.class);
        /*when(mockAccountDataDomainAssembler.createAccountID(any(AccountJPA.class))).thenReturn(accountID);
        when(mockAccountDataDomainAssembler.createAccountType(any(AccountJPA.class))).thenReturn(accountType);
        when(mockAccountDataDomainAssembler.createDesignation(any(AccountJPA.class))).thenReturn(designation);
        when(mockAccountDataDomainAssembler.createOwnerID(any(AccountJPA.class))).thenReturn(ownerID);
        when(mockAccountDataDomainAssembler.createMovements(any(AccountJPA.class))).thenReturn(new ArrayList<>());
        when(repoAccountFactory.createAccount(any(), any(), any(), any(), any())).thenReturn(account);
        */

        /*
        OutputAccountDTO expectedOutputDTO = new OutputAccountDTO(accountIDString, ownerIDString, designationString);
        Link link = linkTo(methodOn(AccountRESTController.class).getAccount(accountIDString)).withSelfRel();
        expectedOutputDTO.add(link);
         */

        //assertThrows(AccountAlreadyRegisteredException.class, () -> accountRESTController.createAccount(createBankAccountDTO));

        /*ResponseEntity expected = new ResponseEntity(expectedOutputDTO, HttpStatus.CREATED);

        ResponseEntity result = accountRESTController.createAccount(createBankAccountDTO);

        assertEquals(expected.getBody().toString(), result.getBody().toString());
        assertEquals(expected.getStatusCode(), result.getStatusCode());
        */

    }

