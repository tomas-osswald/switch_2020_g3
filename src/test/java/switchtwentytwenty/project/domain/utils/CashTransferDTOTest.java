package switchtwentytwenty.project.domain.utils;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.CashTransferDTO;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashTransferDTOTest {
    Date date = new Date();
    CurrencyEnum currency = CurrencyEnum.EURO;
    CashTransferDTO cashTransferDTO = new CashTransferDTO(2,"175345988ZX8",1,"000000000ZZ4",1,2.3,currency,1,"Test",date);

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

    @Test
    void getTransactionDateIfDateNull() {
        CashTransferDTO cashTransferDTO = new CashTransferDTO(2,"175345988ZX8",1,"000000000ZZ4",1,2.3,currency,1,"Test",null);
        Date expected = new Date();
        Date result = cashTransferDTO.getTransactionDate();
        assertEquals(expected, result);
    }

    @Test
    void getTransferedValue() {
        double expected = 2.3;
        double result = cashTransferDTO.getTransferAmount();
        assertEquals(expected, result);
    }

    @Test
    void getFamily() {
        int expected = 2;
        double result = cashTransferDTO.getFamilyID();
        assertEquals(expected, result);
    }

    @Test
    void getOriginFamilyMemberCC() {
        String expected = "175345988ZX8";
        String result = cashTransferDTO.getOriginFamilyMemberCC();
        assertEquals(expected, result);
    }

    @Test
    void getOriginAccountID() {
        int expected = 1;
        int result = cashTransferDTO.getOriginAccountID();
        assertEquals(expected, result);
    }

    @Test
    void getDestinationFamilyMemberCC() {
        String expected = "000000000ZZ4";
        String result = cashTransferDTO.getDestinationFamilyMemberCC();
        assertEquals(expected, result);
    }

    @Test
    void getDestinationAccountID() {
        int expected = 1;
        int result = cashTransferDTO.getDestinationAccountID();
        assertEquals(expected, result);
    }

    @Test
    void getCategoryID() {
        int expected = 1;
        int result = cashTransferDTO.getCategoryID();
        assertEquals(expected, result);
    }
}