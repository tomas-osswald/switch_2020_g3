package switchtwentytwenty.project.ONEdomain.aggregates.invoice;

import switchtwentytwenty.project.ONEdomain.aggregates.AggregateRoot;
import switchtwentytwenty.project.ONEdomain.valueobject.InvoiceID;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

public class Invoice implements AggregateRoot {

    private InvoiceID id;

    @Override
    public ID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}
