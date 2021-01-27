package switch2020.project.domain.sandbox;

import switch2020.project.domain.model.StandardCategory;

import java.util.Date;

public class TransactionData {
    private Date transactionDate;
    private Date registrationDate;
   // private Account destinationAccount;
    private double ammount; //Currency?
    private StandardCategory category;
    private String designation;

    public TransactionData(String designation, double ammount, Date transactionDate, StandardCategory category) {
        this.transactionDate = transactionDate;
        this.registrationDate = new Date();
        this.ammount = ammount;
        this.category = category;
        this.designation = designation;
    }


}
