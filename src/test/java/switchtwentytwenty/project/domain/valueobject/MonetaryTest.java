package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class MonetaryTest {

    @Test
    void monetaryConstructorNullCurrency() {
        BigDecimal amount = BigDecimal.valueOf(100);
        Monetary result = new Monetary(null,amount);

        Monetary expected = new Monetary("EUR",amount);

        assertEquals(expected,result);
    }

    @Test
    void monetaryConstructorBlankCurrency() {
        BigDecimal amount = BigDecimal.valueOf(100);
        Monetary result = new Monetary("",amount);

        Monetary expected = new Monetary("EUR",amount);

        assertEquals(expected,result);
    }

    @Test
    void monetaryConstructor() {
        BigDecimal amount = BigDecimal.valueOf(100);

        assertThrows(IllegalArgumentException.class,()->new Monetary("Patacas",amount));
    }

    @Test
    void getCurrencyTest() {
        BigDecimal amount = BigDecimal.valueOf(100);
        Monetary monetary = new Monetary("EUR",amount);
        Currency expected = Currency.getInstance("EUR");

        Currency result = monetary.getCurrency();

        assertEquals(expected,result);
    }


    @Test
    void setCurrencyTest() {
        BigDecimal amount = BigDecimal.valueOf(100);
        Monetary monetary = new Monetary("EUR",amount);
        Currency expected = Currency.getInstance("USD");

        monetary.setCurrency(Currency.getInstance("USD"));
        Currency result = monetary.getCurrency();

        assertEquals(expected,result);
    }

    @Test
    void getAmountTest() {
        BigDecimal amount = BigDecimal.valueOf(100);
        Monetary monetary = new Monetary("EUR",amount);
        BigDecimal expected = BigDecimal.valueOf(100);

        BigDecimal result = monetary.getAmount();

        assertEquals(expected,result);
    }

    @Test
    void setAmountTest() {
        BigDecimal amount = BigDecimal.valueOf(100);
        Monetary monetary = new Monetary("EUR",amount);
        BigDecimal expected = BigDecimal.valueOf(200);

        monetary.setAmount(BigDecimal.valueOf(200));
        BigDecimal result = monetary.getAmount();

        assertEquals(expected,result);
    }

    @Test
    void testEqualsForEqualMonetary() {
        Monetary monetaryOne = new Monetary("EUR",BigDecimal.valueOf(100));
        Monetary monetaryTwo = new Monetary("EUR",BigDecimal.valueOf(100));

        assertEquals(monetaryOne,monetaryTwo);
        assertNotSame(monetaryOne,monetaryTwo);
    }

    @Test
    void testEqualsForSameMonetary() {
        Monetary monetaryOne = new Monetary("EUR",BigDecimal.valueOf(100));
        Monetary monetaryTwo = monetaryOne;

        assertEquals(monetaryOne,monetaryTwo);
        assertSame(monetaryOne,monetaryTwo);
    }

    @Test
    void testEqualsForDifferentCurrencyMonetary() {
        Monetary monetaryOne = new Monetary("EUR",BigDecimal.valueOf(100));
        Monetary monetaryTwo = new Monetary("USD",BigDecimal.valueOf(100));

        assertNotEquals(monetaryOne,monetaryTwo);
    }

    @Test
    void testEqualsForDifferentAmountMonetary() {
        Monetary monetaryOne = new Monetary("EUR",BigDecimal.valueOf(100));
        Monetary monetaryTwo = new Monetary("EUR",BigDecimal.valueOf(200));

        assertNotEquals(monetaryOne,monetaryTwo);
    }

    @Test
    void testEqualsForDifferentObjects() {
        Monetary monetary = new Monetary("EUR",BigDecimal.valueOf(100));
        String notMonetary = "Not a Monetary Value";

        assertNotEquals(monetary,notMonetary);
    }

    @Test
    void testEqualsDifferentFromNull() {
        Monetary monetary = new Monetary("EUR",BigDecimal.valueOf(100));
        String nullString = null;

        assertNotEquals(monetary,nullString);
    }


    @Test
    void testHashCodeSameHashCode() {
        Monetary monetaryOne = new Monetary("EUR",BigDecimal.valueOf(100));
        Monetary monetaryTwo = new Monetary("EUR",BigDecimal.valueOf(100));

        assertEquals(monetaryOne.hashCode(),monetaryTwo.hashCode());
        assertNotSame(monetaryOne,monetaryTwo);
    }

    @Test
    void testHashCodeDifferentHashCode() {
        Monetary monetaryOne = new Monetary("EUR",BigDecimal.valueOf(100));
        Monetary monetaryTwo = new Monetary("USD",BigDecimal.valueOf(100));

        assertNotEquals(monetaryOne.hashCode(),monetaryTwo.hashCode());
    }

}