package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.domain.aggregates.account.Account;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateAccountService;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

@Repository
public class AccountRepository implements IAccountRepository {

    private ICreateAccountService createAccountService;

    private IAccountDataDomainAssembler accountDataDomainAssembler;


    @Override
    public Account getByID(AccountID id) {
        return retrieveAccountById(id);
    }

    private Account retrieveAccountById(AccountID accountID){

        return null;
    }

    public Account add(Account Account){
        return null;
    }


}
