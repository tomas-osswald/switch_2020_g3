package switchtwentytwenty.project.domain.aggregates.futureTransaction;

import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.FutureTransactionID;
import switchtwentytwenty.project.domain.valueobject.InvoiceID;
import switchtwentytwenty.project.domain.valueobject.ID;

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
