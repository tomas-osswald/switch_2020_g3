package switchtwentytwenty.project.dto.accounts;


public class AccountInputDTO {

    private final String designation;
    private final Integer initialAmount;
    private final String currency;
    private final String ownerID;
    private final String accountType;

    public AccountInputDTO (String designation, Integer initialAmount, String currency, String ownerID, String accountType){
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
