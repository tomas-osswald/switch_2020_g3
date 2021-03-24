package switchtwentytwenty.project.domain.ledger;

import switchtwentytwenty.project.shared.InvoiceID;
import switchtwentytwenty.project.shared.Movement;

public class Payment implements Transaction {

    private Movement debit;
    private InvoiceID invoice;
}
