package switchtwentytwenty.project.domain.dtos.output;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.TransactionData;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDataDTOTest {

    StandardCategory parentStandard = new StandardCategory("root",null,1);

    String designationOne = "movement one";
    MoneyValue amountOne = new MoneyValue(1.0, CurrencyEnum.EURO);
    Date transactionDateOne = new Date(2021, 1, 21);
    StandardCategory categoryOne = new StandardCategory("Serviços",parentStandard,2);

    String designationTwo = "movement two";
    MoneyValue amountTwo = new MoneyValue(2.0, CurrencyEnum.EURO);
    Date transactionDateTwo = new Date(2021, 2, 21);
    StandardCategory categoryTwo = new StandardCategory("Serviços",parentStandard,2);

    TransactionData transactionDataOne = new TransactionData(designationOne, amountOne, transactionDateOne, categoryOne);
    TransactionData transactionDataTwo = new TransactionData(designationTwo, amountTwo, transactionDateTwo, categoryTwo);

    TransactionDataDTO transactionDataDTOOne = new TransactionDataDTO(transactionDataOne);
    TransactionDataDTO transactionDataDTOTwo = new TransactionDataDTO(transactionDataTwo);
    TransactionDataDTO transactionDataDTOThree = new TransactionDataDTO(transactionDataOne);

    @Test
    void constructorForTransactionDataDTO(){
        //Arrange
        String designation = "New Transaction";
        MoneyValue ammount = new MoneyValue(50.0, CurrencyEnum.EURO);
        Date transactionDate = new Date();
        Category category = new StandardCategory("TestCategory", null, 1);
        TransactionData transactionData = new TransactionData(designation,ammount,transactionDate,category);

        //Act
        TransactionDataDTO transactionDTO = new TransactionDataDTO(transactionData);

        //Assert
        Assertions.assertNotNull(transactionDTO);

    }

    @Test
    void equalsTrueSameObject() {
        TransactionDataDTO expected = transactionDataDTOOne;
        TransactionDataDTO result = transactionDataDTOOne;
        assertEquals(expected, result);
        assertSame(expected, result);
    }

    @Test
    void equalsTrueDifferentObjects() {
        TransactionDataDTO expected = transactionDataDTOOne;
        TransactionDataDTO result = transactionDataDTOThree;
        assertEquals(expected, result);
    }

    @Test
    void equalsFalseNotSameInstance() {
        AccountService expected = new AccountService();
        TransactionDataDTO result = transactionDataDTOOne;
        assertNotSame(expected, result);
        assertNotEquals(expected, result);
    }

    @Test
    void equalsFalseNullObject() {
        TransactionDataDTO expected = null;
        TransactionDataDTO result = transactionDataDTOOne;
        assertNotEquals(expected, result);
    }

    @Test
    void equalsFalseDifferentObjects() {
        TransactionDataDTO expected = transactionDataDTOOne;
        TransactionDataDTO result = transactionDataDTOTwo;
        assertNotEquals(expected, result);
    }

}