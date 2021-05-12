package switchtwentytwenty.project.domain.valueobject;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Monetary {

    private Currency currency;
    private BigDecimal amount;

    public Monetary(String currency, BigDecimal amount) {
        this.currency = validateCurrency(currency);
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monetary)) return false;
        Monetary monetary = (Monetary) o;
        return Objects.equals(getCurrency(), monetary.getCurrency()) && Objects.equals(getAmount(), monetary.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrency(), getAmount());
    }

    private Currency validateCurrency(String currencyToCheck) {
        Currency currency;
        if (checkNull(currencyToCheck) || checkBlank(currencyToCheck)) {
            currency = Currency.getInstance("EUR");
        } else {
            currency = Currency.getInstance(currencyToCheck);
        }
        return currency;
    }

    private boolean checkBlank (String currency){
        boolean isBlank = false;
        if (currency.trim().length() == 0){
            isBlank = true;
        }
        return isBlank;
    }

    private boolean checkNull (String currency){
        boolean isNull = false;
        if (currency == null){
            isNull = true;
        }
        return isNull;
    }
}
