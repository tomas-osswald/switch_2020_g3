package switchtwentytwenty.project.domain.aggregates.account;

import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.PersonID;

public abstract class AbNonCashAccount extends AbAccount {

    private PersonID personID;

    public AbNonCashAccount(PersonID personID, Designation designation) {
        super(designation);
        this.personID = personID;
    }

    public AbNonCashAccount() {
        super();
    }
}