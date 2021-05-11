package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class CashAccount extends AbCashAccount{

    private AccountID accountID;

    private OwnerID ownerID;

    private Designation designation;

    private Balance balance;

    private List<Movement> movements = new ArrayList<>();


    public CashAccount(AccountID accountID, OwnerID ownerID, Designation designation, Balance balance, Movement movement) {
        this.accountID = accountID;
        this.ownerID = ownerID;
        this.designation = designation;
        this.balance = balance;
        movements.add(movement);
    }

    @Override
    public AccountID id() {
        return this.accountID;
    }

    @Override
    public OwnerID getOwnerId() {
        return this.ownerID;
    }

    @Override
    public Designation getDesignation() {
        return this.designation;
    }

    @Override
    public Balance getBalance() {
        return this.balance;
    }

    @Override
    public AccountType getAccountType() {
        return null;
    }


    @Override
    public boolean hasID(AccountID id) {
        return false;
    }
}