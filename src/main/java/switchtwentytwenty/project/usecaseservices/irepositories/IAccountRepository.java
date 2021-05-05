package switchtwentytwenty.project.usecaseservices.irepositories;

import switchtwentytwenty.project.domain.aggregates.account.Account;
import switchtwentytwenty.project.domain.valueobject.AccountID;

public interface IAccountRepository extends Repository<Account, AccountID> {

    Account add(Account account);
}
