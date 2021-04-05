package switchtwentytwenty.project.domain.ledger;

import switchtwentytwenty.project.util.AggregateRoot;
import switchtwentytwenty.project.shared.LedgerID;
import switchtwentytwenty.project.util.ID;

import java.util.UUID;

public class Ledger implements AggregateRoot {

    private LedgerID id;

    public Ledger(UUID id) {
        this.id = new LedgerID(id);
    }

    @Override
    public ID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}
