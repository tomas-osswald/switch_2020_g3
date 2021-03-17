package switchtwentytwenty.project.domain.dtos;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.NotSameCurrencyException;

import java.util.Objects;

public class MoneyValue {


    // Global variable // Constant
    static final String CURRENCYDIFFER = "Currency differ";
    private final Double value;
    private CurrencyEnum currency;


    public MoneyValue(Double value, CurrencyEnum currency) {
        this.value = value;
        if (currency == null) {
            this.currency = CurrencyEnum.EURO;
        } else {
            this.currency = currency;
        }

    }

    public double getValue() {
        return this.value.doubleValue();

    }

    public String getCurrency() {
        String symbol = getCurrencySymbol();
        return this.value + symbol;
    }

    private String getCurrencySymbol() {
        switch (this.currency.name()) {
            case "EURO":
                return "€";
            case "YEN":
                return "¥";
            case "DOLLAR":
                return "$";
            default:
                return "?";
        }
    }

    @Override
    public boolean equals(Object otherMoneyValue) {
        if (this == otherMoneyValue) return true;
        if (!(otherMoneyValue instanceof MoneyValue)) return false;
        MoneyValue other = (MoneyValue) otherMoneyValue;
        return Double.compare(other.getValue(), value) == 0 &&
                this.currency.equals(other.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CURRENCYDIFFER, value, currency);
    }


    public MoneyValue credit(MoneyValue moneyValue) {
        MoneyValue creditMoneyValue;
        if (sameCurrency(moneyValue))
            creditMoneyValue = new MoneyValue(this.value + Math.abs(moneyValue.value), this.currency);
        else
            throw new NotSameCurrencyException(CURRENCYDIFFER);
        return creditMoneyValue;
    }

    public MoneyValue debit(MoneyValue moneyValue) {
        MoneyValue debitMoneyValue;
        if (sameCurrency(moneyValue))
            debitMoneyValue = new MoneyValue(this.value - Math.abs(moneyValue.value), this.currency);
        else
            throw new NotSameCurrencyException(CURRENCYDIFFER);
        return debitMoneyValue;
    }

    private boolean sameCurrency(MoneyValue moneyValue) {
        return this.currency.equals(moneyValue.currency);
    }

    /**
     * Method to compare two Money Value
     *
     * @param moneyValue MoneyValue to compare
     * @return returns zero if is numerical the same, less than zero if this MoneyValue is less than another MoneyValue and greater than zero if this MoneyValue is greater than another Money Value
     * <p>
     * Throws an NotSameCurrencyException if this MoneyValue have diferent currency than another Money Value
     */
    public double compareTo(MoneyValue moneyValue) {
        if (sameCurrency(moneyValue))
            return this.value.compareTo(moneyValue.value);
        else
            throw new NotSameCurrencyException(CURRENCYDIFFER);
    }

    public CurrencyEnum getCurrencyType() {
        return this.currency;
    }
}
