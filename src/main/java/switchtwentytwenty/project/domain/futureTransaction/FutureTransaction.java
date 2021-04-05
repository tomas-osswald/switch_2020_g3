package switchtwentytwenty.project.domain.futureTransaction;

import switchtwentytwenty.project.util.AggregateRoot;
import switchtwentytwenty.project.shared.FutureTransactionID;
import switchtwentytwenty.project.shared.InvoiceID;
import switchtwentytwenty.project.util.ID;

public class FutureTransaction implements AggregateRoot {


    private FutureTransactionID id;
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
