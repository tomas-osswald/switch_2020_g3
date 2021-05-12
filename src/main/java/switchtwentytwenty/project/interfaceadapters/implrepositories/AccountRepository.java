package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
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

    private IAccountDataDomainAssembler accountDataDomainAssembler;

    @Autowired
    public AccountRepository(IAccountRepositoryJPA accountRepositoryJPA, IAccountDataDomainAssembler accountDataDomainAssembler) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.accountRepositoryJPA = accountRepositoryJPA;
        this.accountDataDomainAssembler = accountDataDomainAssembler;
    }

    @Override
    public IAccount getByID(AccountID id) {
        return retrieveAccountById(id);
    }

    private IAccount retrieveAccountById(AccountID accountID){
        AccountIDJPA accountIDJPA = new AccountIDJPA(accountID.getAccountID());
        Optional<AccountJPA> accountJPA = accountRepositoryJPA.findById(accountIDJPA);
        IAccount account = null;
        if (accountJPA.isPresent()){
            //TODO: Descomentar assim que der e eliminar o null acima
            //account = accountDataDomainAssembler.toDomain(accountJPA);
            return account;
        } else {
            throw new AccountNotRegisteredException();
        }
    }

    //este método também serve como update, certo?
    public IAccount add(IAccount account){
        AccountJPA accountJPA = accountDataDomainAssembler.toData(account);
        accountRepositoryJPA.save(accountJPA);
        IAccount savedAccount = createAccount(accountJPA);
        return savedAccount;
    }

    public IAccount createAccount(AccountJPA accountJPA){
        AccountID accountID = accountDataDomainAssembler.createAccountID(accountJPA);
        OwnerID ownerID = accountDataDomainAssembler.createOwnerID(accountJPA);
        Designation designation = accountDataDomainAssembler.createDesignation(accountJPA);
        List<Movement> movements = accountDataDomainAssembler.createMovements(accountJPA);

        IAccount account = null;
        return account;
    }


}