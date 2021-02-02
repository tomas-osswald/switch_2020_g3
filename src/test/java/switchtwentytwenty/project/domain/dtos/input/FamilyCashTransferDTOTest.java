package switchtwentytwenty.project.domain.dtos.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

class FamilyCashTransferDTOTest {

    int familyID = 1;
    String familyMemberCC="000000000BC4";
    int accountID = 2;
    double transferAmount = 200.0;
    CurrencyEnum currency = CurrencyEnum.EURO;
    int categoryID = 2;
    String transactionDesignation = "TestTransaction";
    Date transactionDate;


    @Test
    void dtoConstructorWithTransactionDate(){
        transactionDate = new Date();
        switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO dto = new switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO(familyID,familyMemberCC,accountID, transferAmount,currency,categoryID,transactionDesignation,transactionDate);

        Assertions.assertNotNull(dto);
    }

    @Test
    void dtoConstructorWithoutTransactionDate(){
        transactionDate = null;
        switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO dto = new switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO(familyID,familyMemberCC,accountID, transferAmount,currency,categoryID,transactionDesignation,transactionDate);

        Assertions.assertNotNull(dto);
    }

    @Test
    void getCurrency() {
        transactionDate = new Date();
        switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO dto = new switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO(familyID,familyMemberCC,accountID, transferAmount,currency,categoryID,transactionDesignation,transactionDate);
        CurrencyEnum expected = CurrencyEnum.EURO;

        CurrencyEnum result = dto.getCurrency();

        Assertions.assertEquals(expected,result);
    }

    @Test
    void getCategoryID() {
        switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO dto = new switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO(familyID,familyMemberCC,accountID, transferAmount,currency,categoryID,transactionDesignation,transactionDate);
        int expected = 2;

        int result = dto.getCategoryID();

        Assertions.assertEquals(expected,result);

    }

    @Test
    void getTransactionDesignation() {
        switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO dto = new switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO(familyID,familyMemberCC,accountID, transferAmount,currency,categoryID,transactionDesignation,transactionDate);
        String expected = "TestTransaction";

        String result = dto.getTransactionDesignation();

        Assertions.assertTrue(result.compareTo(expected)==0);

    }
}