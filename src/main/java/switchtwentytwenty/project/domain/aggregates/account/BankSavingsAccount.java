package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.List;


@Component
@NoArgsConstructor
@AllArgsConstructor
public class BankSavingsAccount extends AbNonCashAccount {

    private AccountID accountID;

    private OwnerID ownerID;

    private Designation designation;

    private Balance balance;

    private List<Movement> movements;


    @Override
    public AccountID id() {
        return null;
    }

    @Override
    public boolean hasID(AccountID id) {
        return false;
    }

    @Override
    public OwnerID getOwnerId() {
        return null;
    }

    @Override
    public Designation getDesignation() {
        return null;
    }

    @Override
    public Balance getBalance() {
        return null;
    }

    @Override
    public String getAccountType() {
        return null;
    }

    @Override
    public void setAccountID(AccountID accountID) {
        this.accountID = accountID;
    }

    @Override
    public void setOwner(OwnerID ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    @Override
    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    @Override
    public void addMovement(Movement movement) {
        this.movements.add(movement);
    }
}