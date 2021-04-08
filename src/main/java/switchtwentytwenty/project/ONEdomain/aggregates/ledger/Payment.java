package switchtwentytwenty.project.ONEdomain.aggregates.ledger;

import switchtwentytwenty.project.ONEdomain.valueobject.InvoiceID;
import switchtwentytwenty.project.ONEdomain.valueobject.Movement;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

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
