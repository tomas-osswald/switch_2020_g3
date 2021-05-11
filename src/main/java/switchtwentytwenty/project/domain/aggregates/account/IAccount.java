package switchtwentytwenty.project.domain.aggregates.account;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.*;

@Component
public interface IAccount extends AggregateRoot<AccountID> {

    AccountID getId();

    OwnerID getOwnerId();

    Designation getDesignation();

    Balance getBalance();

    AccountType getAccountType();

}