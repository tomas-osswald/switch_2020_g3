package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.IOwnerID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Component
public class BankAccount extends AbNonCashAccount {


   public BankAccount(IOwnerID ownerID, Designation designation) {
       super(ownerID, designation);
    }

    public BankAccount(){
       super();
    }

    public BankAccount(AccountID id, IOwnerID ownerID, Designation designation, List<Movement> movements) {
        super(id, ownerID, designation, movements);
    }

    @Override
    public boolean hasID(AccountID id) {
        return super.hasID(id);
    }

    @Override
    public AccountID id() {
        return super.id();
    }

    @Override
    public IOwnerID getOwnerId() {
        return super.getOwnerId();
    }

    @Override
    public void setDesignation(Designation designation) {
        super.setDesignation(designation);
    }

    @Override
    public String getAccountType() {
        return "bank";
    }

    @Override
    public Designation getDesignation() {
        return super.getDesignation();
    }

    @Override
    public void setAccountID(AccountID accountID) {
        super.setAccountID(accountID);
    }

    @Override
    public void setOwner(IOwnerID ownerID) {
        super.setOwner(ownerID);
    }
    @Override
    public List<Movement> getListOfMovements() {
        List<Movement> copyMovements = new ArrayList<>();
        if (!super.getListOfMovements().isEmpty()) {
            copyMovements.addAll(super.getListOfMovements());
        }
        return copyMovements;
    }

    @Override
    public void setMovements(List<Movement> movements) {

        super.setMovements(Collections.unmodifiableList(movements));
    }

    @Override
    public void addMovement(Movement movement) {
        super.addMovement(movement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(super.id(), that.id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.id(), super.getOwnerId());
    }
}