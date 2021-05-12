package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.OwnerID;

import java.util.List;
import java.util.Objects;


@Component
@AllArgsConstructor
public class BankSavingsAccount extends AbNonCashAccount {

    private AccountID accountID;

    private OwnerID ownerID;

    private Designation designation;

    private List<Movement> movements;

    protected BankSavingsAccount() {

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankSavingsAccount)) return false;
        BankSavingsAccount that = (BankSavingsAccount) o;
        return Objects.equals(accountID, that.accountID) && Objects.equals(ownerID, that.ownerID) && Objects.equals(getDesignation(), that.getDesignation()) && Objects.equals(movements, that.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, ownerID, getDesignation(), movements);
    }
}