package switchtwentytwenty.project.domain.dtos;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.NotSameCurrencyException;

public class MoneyValue {


    // Global variable // Constant
    static final String CURRENCYDIFFER = "Currency differ";
    private final Double value;
    private CurrencyEnum currency;

    /*
    private double euroToDollarExchangeRate;
    private double yenToDollarExchangeRate;
    private double dollarToEuroExchangeRate;
    private double dollarToYenExchangeRate;
    */

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
        }
        return "?";
    }

    @Override
    public boolean equals(Object otherMoneyValue) {
        if (this == otherMoneyValue) return true;
        if (otherMoneyValue == null || !(otherMoneyValue instanceof MoneyValue)) return false;
        MoneyValue other = (MoneyValue) otherMoneyValue;
        return Double.compare(other.getValue(), value) == 0 &&
                this.currency.equals(other.currency);
    }

    /*
    private void updateEuroExchangeRate() throws IOException {

        String url_str = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD";

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();


        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();


        String req_result = jsonobj.get("EUR").getAsString();
        //this.euroToDollarExchangeRate = get exchange rate from web;
        //this.dollarToEuroExchangeRate = get exchange rate from web;
    }

    private void updateYenExchangeRate() {
        //this.yenToDollarExchangeRate = get exchange rate from web;
        //this.dollarToYenExchangeRate = get exchange rate from web;
    }


    private double calculateToDollar() {

        switch (this.currency.name()) {
            case "EURO":
                return this.value * this.euroToDollarExchangeRate;
            case "YEN":
                return this.value * this.yenToDollarExchangeRate;
            case "DOLLAR":
                return this.value;
        }
        return 0;
    }

    public MoneyValue getValueInEuro() {
        if (this.currency.name().equals("EURO")) {
            return this;
        }
        updateEuroExchangeRate();
        double balanceInDollars = calculateToDollar();
        double finalBalance = balanceInDollars * this.dollarToEuroExchangeRate;
        return new MoneyValue(finalBalance, CurrencyEnum.EURO);
    }

    public MoneyValue getValueInDollar() {
        return new MoneyValue(calculateToDollar(), CurrencyEnum.DOLLAR);
    }

    public MoneyValue getValueInYen() {
        if (this.currency.name().equals("YEN")) {
            return this;
        }
        updateYenExchangeRate();
        double balanceInDollars = calculateToDollar();
        double finalBalance = balanceInDollars * this.dollarToYenExchangeRate;
        return new MoneyValue(finalBalance, CurrencyEnum.YEN);
    }
    */

    public MoneyValue credit(MoneyValue moneyValue) {
        MoneyValue creditMoneyValue;
        if (sameCurrency(moneyValue))
            creditMoneyValue = new MoneyValue(Math.abs(this.value) + Math.abs(moneyValue.value), this.currency);
        else
            throw new NotSameCurrencyException(CURRENCYDIFFER);
        return creditMoneyValue;
    }

    public MoneyValue debit(MoneyValue moneyValue) {
        MoneyValue debitMoneyValue;
        if (sameCurrency(moneyValue))
            debitMoneyValue = new MoneyValue(Math.abs(this.value) - Math.abs(moneyValue.value), this.currency);
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
     *
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

    public MoneyValue getSimmetric() {
        return new MoneyValue(-this.value, this.currency);
    }
}
