package switch2020.project.domain.sandbox;

import switch2020.project.domain.model.FamilyMember;

import java.util.Date;

public class CashTransaction implements Transaction {

    private TransactionData transactionData;
    private FamilyMember payer;
    private FamilyMember recipient;


    public CashTransaction(double ammount, Category category, FamilyMember payer, FamilyMember recipent) {
        this.transactionData = new TransactionData(ammount, category);
        this.payer = payer;
        this.recipient = recipent;
    }

    @Override
    public Date getDate() {
        return this.transactionData.getDate();
    }

    @Override
    public double getAmmount() {
        return this.transactionData.getAmmount();
    }

    @Override
    public Category getCategory() {
        return this.transactionData.getCategory();
    }
}
