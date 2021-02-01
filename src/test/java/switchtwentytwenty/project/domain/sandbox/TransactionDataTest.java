package switchtwentytwenty.project.domain.sandbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

class TransactionDataTest {

    Date date = new Date();
    Category category = new StandardCategory("cat", null, 2);
    TransactionData transactionData = new TransactionData("test", new MoneyValue(22.2, CurrencyEnum.EURO), date, category);

    @Test
    void getTransactionDate() {
        Date result = date;
        Date expected = transactionData.getTransactionDate();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getRegistrationDate() {
        Date expected = transactionData.getRegistrationDate();
        Assertions.assertNotNull(expected);
        Assertions.assertNotSame(expected, transactionData.getTransactionDate());
    }

    @Test
    void getCategory() {
        Category expected = category;
        Category result = transactionData.getCategory();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getDesignation() {
        String expected = "test";
        String result = transactionData.getDesignation();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAmmount() {
        double expected = 22.2;
        double result = transactionData.getAmmount().getValue();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getRemainingBalance() {
        double expected = 0;
        double result = transactionData.getRemainingBalance().getValue();
        Assertions.assertEquals(expected,result);
    }
}