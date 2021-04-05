package switchtwentytwenty.project.domain.invoice;

import switchtwentytwenty.project.util.AggregateRoot;
import switchtwentytwenty.project.shared.InvoiceID;
import switchtwentytwenty.project.util.ID;

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
