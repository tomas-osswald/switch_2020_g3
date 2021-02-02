package switchtwentytwenty.project.domain.dtos.output;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.accounts.BankSavingsAccount;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.TransactionData;
import switchtwentytwenty.project.domain.services.AccountService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDataDTOTest {

    StandardCategory parentStandard = new StandardCategory("root",null,1);

    String designationOne = "movement one";
    MoneyValue amountOne = new MoneyValue(1.00, null);
    Date transactionDateOne = new Date(2021, 1, 21);
    StandardCategory categoryOne = new StandardCategory("Serviços",parentStandard,2);

    String designationTwo = "movement two";
    MoneyValue amountTwo = new MoneyValue(2.00, null);
    Date transactionDateTwo = new Date(2021, 2, 21);
    StandardCategory categoryTwo = new StandardCategory("Serviços",parentStandard,2);

    TransactionData transactionDataOne = new TransactionData(designationOne, amountOne, transactionDateOne, categoryOne);
    TransactionData transactionDataTwo = new TransactionData(designationTwo, amountTwo, transactionDateTwo, categoryTwo);

    switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO transactionDataDTOOne = new switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO(transactionDataOne);
    switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO transactionDataDTOTwo = new switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO(transactionDataTwo);
    switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO transactionDataDTOThree = new switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO(transactionDataOne);

    @Test
    void constructorForTransactionDataDTO(){
        //Arrange
        String designation = "New Transaction";
        MoneyValue ammount = new MoneyValue(50.0, null);
        Date transactionDate = new Date();
        Category category = new StandardCategory("TestCategory", null, 1);
        TransactionData transactionData = new TransactionData(designation,ammount,transactionDate,category);

        //Act
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO transactionDTO = new switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO(transactionData);

        //Assert
        Assertions.assertNotNull(transactionDTO);

    }

    @Test
    void equalsTrueSameObject() {
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO expected = transactionDataDTOOne;
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO result = transactionDataDTOOne;
        assertEquals(expected, result);
        assertSame(expected, result);
        assertTrue(expected.equals(result));
    }

    @Test
    void equalsTrueDifferentObjects() {
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO expected = transactionDataDTOOne;
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO result = transactionDataDTOThree;
        assertEquals(expected, result);
        assertTrue(expected.equals(result));
    }

    @Test
    void equalsFalseNotSameInstance() {
        AccountService expected = new AccountService();
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO result = transactionDataDTOOne;
        assertNotSame(expected, result);
        assertNotEquals(expected, result);
        assertFalse(expected.equals(result));
    }

    @Test
    void equalsFalseNullObject() {
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO expected = null;
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO result = transactionDataDTOOne;
        assertNotEquals(expected, result);
        assertFalse(result.equals(expected));
    }

    @Test
    void equalsFalseDifferentObjects() {
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO expected = transactionDataDTOOne;
        switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO result = transactionDataDTOTwo;
        assertNotEquals(expected, result);
        assertFalse(expected.equals(result));
    }

}