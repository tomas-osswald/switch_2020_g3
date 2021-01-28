package switchtwentytwenty.project.domain.DTOs;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyValueTest {

    MoneyValue moneyValue = new MoneyValue(2.5, CurrencyEnum.EURO);

    @Test
    void getValue() {
        double expected = 2.5;
        double result = moneyValue.getValue();
        assertEquals(expected, result, 0.01);
    }

    @Test
    void getCurrency() {
        String expected = "EURO";
        String result = moneyValue.getCurrency();
        assertEquals(expected, result);
    }
}