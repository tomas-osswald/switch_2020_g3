package switch2020.project.domain.sandbox;

import java.util.Date;

public class TransactionData {
    private Date date;
    private double ammount;
    private Category category;

    public TransactionData(double ammount, Category category) {
        this.date = new Date();
        this.ammount = ammount;
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public double getAmmount() {
        return ammount;
    }

    public Category getCategory() {
        return category;
    }

}
