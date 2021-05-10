package switchtwentytwenty.project.dto.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Currency;

@NoArgsConstructor
@Getter
@Setter
public class CreateAccountDTO {

    private String designation;
    private Integer initialAmount;
    private Currency currency;

    public CreateAccountDTO (String designation, Integer initialAmount, String currency){
        this.designation = designation;
        this.initialAmount = initialAmount;
        this.currency = validateCurrency(currency);
    }

    private Currency validateCurrency(String currencyToCheck) {
        Currency currency;
        if (checkBlank(currencyToCheck) || checkNull(currencyToCheck)) {
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
        if (currency.trim().length() == 0){
            isNull = true;
        }
        return isNull;
    }

}
