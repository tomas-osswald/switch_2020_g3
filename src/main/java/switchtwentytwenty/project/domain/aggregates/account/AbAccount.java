package switchtwentytwenty.project.domain.aggregates.account;

import switchtwentytwenty.project.domain.valueobject.*;

import java.util.List;

public abstract class AbAccount implements IAccount {

    private Designation designation;

    private Balance balance;

    private AccountID accountID;

    private List<Movement> movements;


}