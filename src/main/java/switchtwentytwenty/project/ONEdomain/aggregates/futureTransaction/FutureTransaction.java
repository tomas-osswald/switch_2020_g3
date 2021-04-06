package switchtwentytwenty.project.ONEdomain.aggregates.futureTransaction;

import switchtwentytwenty.project.ONEdomain.aggregates.AggregateRoot;
import switchtwentytwenty.project.ONEdomain.valueobject.FutureTransactionID;
import switchtwentytwenty.project.ONEdomain.valueobject.InvoiceID;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

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
