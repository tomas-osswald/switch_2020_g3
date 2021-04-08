package switchtwentytwenty.project.ONEdomain.aggregates.ledger;

import switchtwentytwenty.project.ONEdomain.valueobject.Movement;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

public class Tranfer implements Transaction {

    private Movement debit;
    private Movement credit;

    @Override
    public ID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}
