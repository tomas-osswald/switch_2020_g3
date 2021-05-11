package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class CashAccount extends AbCashAccount{

    private AccountID accountID;

    private OwnerID ownerID;

    private Designation designation;

    private Monetary balance;

    private List<Movement> movements = new ArrayList<>();


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
    public Monetary getBalance() {
        return this.balance;
    }

    @Override
    public String getAccountType() {
        return "Cash Account";
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
    public void addMovement(Movement movement){
        movements.add(movement);
    }

    @Override
    public boolean hasID(AccountID id) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CashAccount)) return false;
        CashAccount that = (CashAccount) o;
        return Objects.equals(accountID, that.accountID) && Objects.equals(ownerID, that.ownerID) && Objects.equals(getDesignation(), that.getDesignation()) && Objects.equals(getBalance(), that.getBalance()) && Objects.equals(movements, that.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, ownerID, getDesignation(), getBalance(), movements);
    }

}