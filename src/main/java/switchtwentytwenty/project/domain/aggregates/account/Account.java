package switchtwentytwenty.project.domain.aggregates.account;

import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.*;

public interface Account extends AggregateRoot<AccountID> {

    AccountID getId();

    OwnerID getOwnerId();

    Designation getDesignation();

    Balance getBalance();

    AccountType getAccountType();
}