package switchtwentytwenty.project.domain.DTOs;

import java.util.Currency;

public class MoneyValue {

    private Double value;
    //private Currency currency; definir se Currency ou Enum

    public MoneyValue(Double value){
        this.value = value;
        //this.currency = currency;
    }
}
