package switchtwentytwenty.project.domain.invoice;

import switchtwentytwenty.project.shared.AggregateRoot;
import switchtwentytwenty.project.shared.InvoiceID;
import switchtwentytwenty.project.shared.ID;

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
