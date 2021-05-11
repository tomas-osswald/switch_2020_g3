package switchtwentytwenty.project.dto.accounts;

import switchtwentytwenty.project.domain.valueobject.AccountType;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.OwnerID;

import java.util.Objects;

public class InputAccountDTO {

    private final String designation;
    private final Integer initialAmount;
    private final String currency;
    private final String ownerID;
    private final String accountType;

    public InputAccountDTO(String designation, Integer initialAmount, String currency, String ownerID, String accountType) {
        this.designation = designation;
        this.initialAmount = initialAmount;
        this.currency = currency;
        this.ownerID = ownerID;
        this.accountType = accountType;
    }

    public String getDesignation() {
        return designation;
    }

    public Integer getInitialAmount() {
        return initialAmount;
    }


    public String getCurrency() {
        return currency;
    }


    public String getOwnerID() {
        return ownerID;
    }

    public String getAccountType() {
        return accountType;
    }
}


