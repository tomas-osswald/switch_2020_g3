package switchtwentytwenty.project.domain.utils;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashTransferDTOTest {
    Date date = new Date();
    CashTransferDTO cashTransferDTO = new CashTransferDTO(2, "", 2, "", 3, new MoneyValue(2.3, CurrencyEnum.EURO), 0, "Test", date);

    @Test
    void getTransactionDesignation() {
        String expected = "Test";
        String result = cashTransferDTO.getTransactionDesignation();
        assertEquals(expected, result);
    }

    @Test
    void getTransactionDate() {
        Date expected = date;
        Date result = cashTransferDTO.getTransactionDate();
        assertEquals(expected, result);
    }
}