package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.account.Account;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

@Repository
public class AccountRepository implements IAccountRepository {

    private IAccountRepositoryJPA accountRepositoryJPA;

    private IAccountDataDomainAssembler accountDataDomainAssembler;

    @Autowired
    public AccountRepository(IAccountRepositoryJPA accountRepositoryJPA, IAccountDataDomainAssembler accountDataDomainAssembler) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.accountRepositoryJPA = accountRepositoryJPA;
        this.accountDataDomainAssembler = accountDataDomainAssembler;
    }

    @Autowired


    @Override
    public Account getByID(AccountID id) {
        return retrieveAccountById(id);
    }

    private Account retrieveAccountById(AccountID accountID){

        return null;
    }

    public Account add(Account account){
        AccountJPA accountJPA = accountDataDomainAssembler.toData(account);
        accountRepositoryJPA.save(accountJPA);
        Account savedAccount = accountDataDomainAssembler.toDomain(accountJPA);
        return savedAccount;
    }


}
