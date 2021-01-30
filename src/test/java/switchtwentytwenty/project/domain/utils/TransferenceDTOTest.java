package switchtwentytwenty.project.domain.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.sandbox.TransactionData;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransferenceDTOTest {

    int familyID = 1;
    String familyMemberCC="000000000BC4";
    int accountID = 2;
    double transferredValue = 130.00;
    int categoryID = 2;
    String transactionDesignation = "TestTransaction";
    Date transactionDate;


    @Test
    void dtoConstructorWithTransactionDate(){
        Date transactionDate = new Date();
        TransferenceDTO dto = new TransferenceDTO(familyID,familyMemberCC,accountID,transferredValue,categoryID,transactionDesignation,transactionDate);

        Assertions.assertNotNull(dto);
    }

    @Test
    void dtoConstructorWithoutTransactionDate(){
        Date transactionDate = null;
        TransferenceDTO dto = new TransferenceDTO(familyID,familyMemberCC,accountID,transferredValue,categoryID,transactionDesignation,transactionDate);

        Assertions.assertNotNull(dto);
    }

}