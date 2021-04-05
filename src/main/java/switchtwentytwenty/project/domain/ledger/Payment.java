package switchtwentytwenty.project.domain.ledger;

import switchtwentytwenty.project.shared.InvoiceID;
import switchtwentytwenty.project.shared.Movement;
import switchtwentytwenty.project.util.ID;

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
