package switchtwentytwenty.project.domain.ledger;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.LedgerID;

import java.util.UUID;

public class Ledger implements AggregateRoot {

    private LedgerID id;

    public Ledger(UUID id) {
        this.id = new LedgerID(id);
    }
}
