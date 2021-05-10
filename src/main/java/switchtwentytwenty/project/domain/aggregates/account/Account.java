package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.AccountID;

@Component
@NoArgsConstructor
@AllArgsConstructor
public interface Account extends AggregateRoot<AccountID> {

    private AccountID accountID;



}