package switchtwentytwenty.project.domain.aggregates.account;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.List;

@Component
public interface IAccount extends AggregateRoot<AccountID> {

    OwnerID getOwnerId();

    Designation getDesignation();

    Monetary getBalance();

    String getAccountType();

    void setAccountID(AccountID accountID);

    void setOwner(OwnerID ownerID);

    void setDesignation(Designation designation);

    void setMovements(List<Movement> movements);

    void addMovement(Movement movement);

}