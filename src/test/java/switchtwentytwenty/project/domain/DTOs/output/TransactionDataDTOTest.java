package switchtwentytwenty.project.domain.DTOs.output;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.TransactionData;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDataDTOTest {

    @Test
    void constructorForTransactionDataDTO(){
        //Arrange
        String designation = "New Transaction";
        double ammount = 50.0;
        Date transactionDate = new Date();
        Category category = new StandardCategory("TestCategory", null, 1);
        TransactionData transactionData = new TransactionData(designation,ammount,transactionDate,category);

        //Act
        TransactionDataDTO transactionDTO = new TransactionDataDTO(transactionData);

        //Assert
        Assertions.assertNotNull(transactionDTO);

    }

}