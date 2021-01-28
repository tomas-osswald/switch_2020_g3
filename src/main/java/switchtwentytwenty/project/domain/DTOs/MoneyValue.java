package switchtwentytwenty.project.domain.DTOs;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;

public class MoneyValue {

    private Double value;
    private CurrencyEnum currency;

    /*
    private double euroToDollarExchangeRate;
    private double yenToDollarExchangeRate;
    private double dollarToEuroExchangeRate;
    private double dollarToYenExchangeRate;
    */

    public MoneyValue(Double value, CurrencyEnum currency) {
        this.value = value;
        this.currency = currency;
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

}
