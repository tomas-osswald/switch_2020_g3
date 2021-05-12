package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.account.AccountFactory;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.exceptions.AccountNotRegisteredException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountRepositoryTest {

    @Mock
    IAccountRepositoryJPA accountRepositoryJPA;

    @Mock
    AccountFactory accountFactory;

    @Mock
    IAccountDataDomainAssembler accountDataDomainAssembler;

    @Mock
    IAccount account;

    @Mock
    AccountJPA accountJPA;

    @Mock
    AccountJPA savedAccountJPA;

    @Mock
    IAccount savedAccount;

    @InjectMocks
    AccountRepository accountRepository;

    Long id = 3L;
    String currency = "EUR";
    BigDecimal amount = new BigDecimal("3");
    Monetary monetary = new Monetary(currency, amount);
    String email = "tonyZe@gamil.com";
    String desig = "x";
    String accType = "CashAccount";

    AccountID accountID = new AccountID(id);
    //Movement movement = new Movement(monetary);
    List<Movement> movements = new ArrayList<>();
    PersonID ownerID = new PersonID(email);
    Designation designation = new Designation(desig);
    AccountType accountType = new AccountType(accType);

    @DisplayName("Test if AccountRepository adds the Account")
    @Test
    void addAccountSucess(){
        when(accountDataDomainAssembler.toData(account)).thenReturn(accountJPA);
        when(accountRepositoryJPA.save(accountJPA)).thenReturn(savedAccountJPA);
        when(accountDataDomainAssembler.createAccountID(savedAccountJPA)).thenReturn(accountID);
        when(accountDataDomainAssembler.createMovements(savedAccountJPA)).thenReturn(movements);
        when(accountDataDomainAssembler.createOwnerID(savedAccountJPA)).thenReturn(ownerID);
        when(accountDataDomainAssembler.createDesignation(savedAccountJPA)).thenReturn(designation);
        when(accountDataDomainAssembler.createAccountType(savedAccountJPA)).thenReturn(accountType);
        when(accountFactory.createAccount( accountID, movements, ownerID, designation, accType )).thenReturn(savedAccount);

        assertDoesNotThrow(()->accountRepository.add(account));

    }

    @DisplayName("Check if Account Exists - Throws error, Account does not exists")
    @Test
    void getByIdFailure(){
        when(accountRepositoryJPA.findById(any(AccountIDJPA.class))).thenThrow(AccountNotRegisteredException.class);

        assertThrows(AccountNotRegisteredException.class,()->accountRepository.getByID(accountID));

    }

}