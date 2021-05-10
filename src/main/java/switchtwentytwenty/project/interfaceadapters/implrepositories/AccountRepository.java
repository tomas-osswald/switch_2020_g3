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

    @Override
    public Account getByID(AccountID id) {
        return null; // retrieveAccountById(id);;
    }

    /*
    private Account retrieveAccountById(AccountID accountID){
        AccountIDJPA accountIDJPA = new AccountIDJPA(accountID.getAccountID());
        Optional<AccountJPA> accountJPA = accountRepositoryJPA.findById(accountIDJPA);
        Account account;
        if (accountJPA.isPresent()){
            account = accountDataDomainAssembler.toDomain(accountJPA);
            return account;
        } else {
            throw new AccountNotRegisteredException();
        }
    }

     */

    public Account add(Account account){
        AccountJPA accountJPA = accountDataDomainAssembler.toData(account);
        accountRepositoryJPA.save(accountJPA);
        Account savedAccount = accountDataDomainAssembler.toDomain(accountJPA);
        return savedAccount;
    }


}
