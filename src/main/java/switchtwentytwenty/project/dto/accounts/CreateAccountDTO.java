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
    private String currency;
    private String ownerID;
    private String accountType;


    public CreateAccountDTO (String designation, Integer initialAmount, String currency, String ownerID, String accountType){
        this.designation = designation;
        this.initialAmount = initialAmount;
        this.currency = currency;
        this.ownerID = ownerID;
        this.accountType = accountType;
    }

    /*
    Estes métodos de validação vão para o Service para a instanciação de Currency
     */
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
