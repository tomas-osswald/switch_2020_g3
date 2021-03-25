package switchtwentytwenty.project.domain.futureTransaction;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.FutureTransactionID;
import switchtwentytwenty.project.shared.InvoiceID;

public class FutureTransaction implements AggregateRoot {


    private FutureTransactionID id;
    private InvoiceID invoice;
}
