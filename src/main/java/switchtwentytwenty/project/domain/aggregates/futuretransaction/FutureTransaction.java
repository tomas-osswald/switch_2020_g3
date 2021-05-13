package switchtwentytwenty.project.domain.aggregates.futuretransaction;

import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.FutureTransactionID;
import switchtwentytwenty.project.domain.valueobject.InvoiceID;
import switchtwentytwenty.project.domain.valueobject.ID;

public class FutureTransaction implements AggregateRoot {


    @Override
    public ID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}
