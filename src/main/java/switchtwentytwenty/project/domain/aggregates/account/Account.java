package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
public interface Account extends AggregateRoot<AccountID> {

    AccountID getId();

    OwnerID getOwnerId();

    Designation getDesignation();

    Balance getBalance();

    AccountType getAccountType();

}