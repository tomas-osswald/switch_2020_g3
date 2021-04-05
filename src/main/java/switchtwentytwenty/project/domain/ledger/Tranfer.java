package switchtwentytwenty.project.domain.ledger;

import switchtwentytwenty.project.shared.Movement;
import switchtwentytwenty.project.util.ID;

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
