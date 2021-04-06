package switchtwentytwenty.project.ONEdomain.aggregates.ledger;

import switchtwentytwenty.project.ONEdomain.aggregates.AggregateRoot;
import switchtwentytwenty.project.ONEdomain.valueobject.LedgerID;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

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
