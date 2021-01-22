package switch2020.project.domain.sandbox;

import switch2020.project.domain.model.FamilyMember;

import java.util.Date;

public class CashTransaction implements Transaction {

    private Date date;
    private double ammount;
    private FamilyMember payer;
    private FamilyMember recipient;
    private Category category;

    public CashTransaction(double ammount, Category category, FamilyMember payer, FamilyMember recipent) {
        this.date = new Date();
        this.ammount = ammount;
        this.payer = payer;
        this.recipient = recipent;
        this.category = category;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public double getAmmount() {
        return this.ammount;
    }

    @Override
    public Category getCategory() {
        return this.category;
    }
}
