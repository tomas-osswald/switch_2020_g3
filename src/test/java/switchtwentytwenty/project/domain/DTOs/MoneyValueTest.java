package switchtwentytwenty.project.domain.DTOs;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyValueTest {

    MoneyValue moneyValueEuro = new MoneyValue(2.5, CurrencyEnum.EURO);
    MoneyValue moneyValueYen = new MoneyValue(199.65, CurrencyEnum.YEN);
    MoneyValue moneyValueDollar = new MoneyValue(-3.0, CurrencyEnum.DOLLAR);
    MoneyValue moneyValueunknwon = new MoneyValue(9.0,CurrencyEnum.POUND);

    @Test
    void getValue() {
        double expected = 2.5;
        double result = moneyValueEuro.getValue();
        assertEquals(expected, result, 0.01);
    }

    @Test
    void getCurrencyEuro() {
        String expected = "2.5€";
        String result = moneyValueEuro.getCurrency();
        assertEquals(expected, result);
    }

    @Test
    void getCurrencyYen() {
        String expected = "199.65¥";
        String result = moneyValueYen.getCurrency();
        assertEquals(expected, result);
    }

    @Test
    void getCurrencyDollar() {
        String expected = "-3.0$";
        String result = moneyValueDollar.getCurrency();
        assertEquals(expected, result);
    }

    @Test
    void getCurrencyUnknownSign() {
        String expected = "9.0?";
        String result = moneyValueunknwon.getCurrency();
        assertEquals(expected, result);
    }
}