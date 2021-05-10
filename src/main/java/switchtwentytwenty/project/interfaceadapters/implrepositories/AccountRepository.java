package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.domain.aggregates.account.Account;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateAccountService;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

@Repository
public class AccountRepository implements IAccountRepository {

    private ICreateAccountService createAccountService;

    private IAccountDataDomainAssembler accountDataDomainAssembler;

    public Account add(Account Account){
        return null;
    }

    public Account getById(AccountID accountID){
        return retrieveAccountById(accountID);
    }

    private Account retrieveAccountById(AccountID accountID){
        AccountIDJPA accountIDJPA = accountDataDomainAssembler.toData(accountID);
    }
}
