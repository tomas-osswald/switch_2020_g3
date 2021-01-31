package switchtwentytwenty.project.domain.DTOs.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

class FamilyCashTransferDTOTest {

    int familyID = 1;
    String familyMemberCC="000000000BC4";
    int accountID = 2;
    double transferAmount = 130.00;
    CurrencyEnum currency = CurrencyEnum.EURO;
    int categoryID = 2;
    String transactionDesignation = "TestTransaction";
    Date transactionDate;


    @Test
    void dtoConstructorWithTransactionDate(){
        transactionDate = new Date();
        FamilyCashTransferDTO dto = new FamilyCashTransferDTO(familyID,familyMemberCC,accountID, transferAmount,currency,categoryID,transactionDesignation,transactionDate);

        Assertions.assertNotNull(dto);
    }

    @Test
    void dtoConstructorWithoutTransactionDate(){
        transactionDate = null;
        FamilyCashTransferDTO dto = new FamilyCashTransferDTO(familyID,familyMemberCC,accountID, transferAmount,currency,categoryID,transactionDesignation,transactionDate);

        Assertions.assertNotNull(dto);
    }

    @Test
    void getCurrency() {
        transactionDate = new Date();
        FamilyCashTransferDTO dto = new FamilyCashTransferDTO(familyID,familyMemberCC,accountID, transferAmount,currency,categoryID,transactionDesignation,transactionDate);
        CurrencyEnum expected = CurrencyEnum.EURO;

        CurrencyEnum result = dto.getCurrency();

        Assertions.assertEquals(expected,result);
    }
}