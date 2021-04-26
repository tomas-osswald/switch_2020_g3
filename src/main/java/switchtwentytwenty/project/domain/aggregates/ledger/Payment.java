package switchtwentytwenty.project.domain.aggregates.ledger;

import switchtwentytwenty.project.domain.valueobject.InvoiceID;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.ID;

public class Payment implements Transaction {

    private Movement debit;
    private InvoiceID invoice;

    @Override
    public ID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}
