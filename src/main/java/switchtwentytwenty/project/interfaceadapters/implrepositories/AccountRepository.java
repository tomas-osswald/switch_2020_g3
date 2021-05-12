package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.account.AccountFactory;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.OwnerID;
import switchtwentytwenty.project.exceptions.AccountNotRegisteredException;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository implements IAccountRepository {

    private IAccountRepositoryJPA accountRepositoryJPA;
    private AccountFactory accountFactory;
    private IAccountDataDomainAssembler accountDataDomainAssembler;

    @Autowired
    public AccountRepository(IAccountRepositoryJPA accountRepositoryJPA, AccountFactory accountFactory, IAccountDataDomainAssembler accountDataDomainAssembler) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.accountRepositoryJPA = accountRepositoryJPA;
        this.accountDataDomainAssembler = accountDataDomainAssembler;
        this.accountFactory = accountFactory;
    }

    @Override
    public IAccount getByID(AccountID id) {
        return retrieveAccountById(id);
    }

    private IAccount retrieveAccountById(AccountID accountID){
        AccountIDJPA accountIDJPA = new AccountIDJPA(accountID.getAccountID());
        Optional<AccountJPA> accountJPA = accountRepositoryJPA.findById(accountIDJPA);
        IAccount account;
        if (accountJPA.isPresent()){
            account = createAccount(accountJPA.get());
            return account;
        } else {
            throw new AccountNotRegisteredException();
        }
    }

    //este método também serve como update, certo?
    public IAccount add(IAccount account){
        AccountJPA accountJPA = accountDataDomainAssembler.toData(account);
        AccountJPA savedAccountJPA = accountRepositoryJPA.save(accountJPA);
        IAccount savedAccount = createAccount(savedAccountJPA);
        return savedAccount;
    }

    public IAccount createAccount(AccountJPA accountJPA){
        AccountID accountID = accountDataDomainAssembler.createAccountID(accountJPA);
        OwnerID ownerID = accountDataDomainAssembler.createOwnerID(accountJPA);
        Designation designation = accountDataDomainAssembler.createDesignation(accountJPA);
        List<Movement> movements = accountDataDomainAssembler.createMovements(accountJPA);
        String accountType = accountJPA.getAccountType();
        IAccount account = accountFactory.createAccount(accountID, movements, ownerID, designation, accountType);
        return account;
    }


}