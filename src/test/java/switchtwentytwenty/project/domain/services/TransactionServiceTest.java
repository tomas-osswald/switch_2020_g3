package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO;
import switchtwentytwenty.project.domain.model.accounts.BankAccount;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.model.transactions.CashTransaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {
    MoneyValue remainingAmount = new MoneyValue(400.00, CurrencyEnum.EURO);

    // FamilyMember
    int familyID = 1;
    String selfCC = "0000000000ZZ4";

    // Category
    StandardCategory parentStandard = new StandardCategory("root", null, 1);
    StandardCategory categoria1 = new StandardCategory("Serviços", parentStandard, 2);
    StandardCategory categoria2 = new StandardCategory("Serviços", parentStandard, 2);

    // CashAccount
    String description = "Cash Account do Ze Manel";
    Double balance = 450.00;
    int accountID = 1;
    AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(balance, description, selfCC, familyID, CurrencyEnum.EURO);
    CashAccount contaCash = new CashAccount(cashAccountDTO, accountID);

    // CashTransaction
    double transferAmount = 200.0;
    CurrencyEnum currency = CurrencyEnum.EURO;
    boolean credit = true;
    int categoryID = 2;
    String transactionDesignation = "Luz Novembro";
    Date transactionDateOne = new Date(2021, 0, 21);
    Date transactionDateTwo = new Date(2021, 0, 22);
    Date transactionDateThree = new Date(2021, 0, 20);
    FamilyCashTransferDTO transacaoDTO1 = new FamilyCashTransferDTO(familyID, selfCC, accountID, transferAmount, currency, categoryID, transactionDesignation, transactionDateOne);
    FamilyCashTransferDTO transacaoDTO2 = new FamilyCashTransferDTO(familyID, selfCC, accountID, 600.0, currency, categoryID, transactionDesignation, transactionDateTwo);
    FamilyCashTransferDTO transacaoDTO3 = new FamilyCashTransferDTO(familyID, selfCC, accountID, -100.0, currency, categoryID, transactionDesignation, transactionDateThree);
    FamilyCashTransferDTO transacaoDTO4 = new FamilyCashTransferDTO(familyID, selfCC, accountID, 100.0, CurrencyEnum.DOLLAR, categoryID, transactionDesignation, transactionDateThree);

    CashTransaction cashTransactionOne = new CashTransaction(contaCash, categoria1, credit, remainingAmount, transacaoDTO1);
    CashTransaction cashTransactionTwo = new CashTransaction(contaCash, categoria1, credit, remainingAmount, transacaoDTO2);
    CashTransaction cashTransactionThree = new CashTransaction(contaCash, categoria1, credit, remainingAmount, transacaoDTO3);
    TransactionDataDTO transactionDataDTOOne = new TransactionDataDTO(cashTransactionOne.getTransactionData());
    TransactionDataDTO transactionDataDTOTwo = new TransactionDataDTO(cashTransactionTwo.getTransactionData());
    TransactionDataDTO transactionDataDTOThree = new TransactionDataDTO(cashTransactionThree.getTransactionData());


    @Test
    void RegisterPaymentMyCashAccount_SameBalance() {
        TransactionService service = new TransactionService();
        service.registerPaymentMyCashAccount(contaCash, categoria1, transacaoDTO1);
        double expected = 250.00;
        double result = contaCash.getMoneyBalance().getValue();
        assertEquals(expected, result);
    }

    @Test
    void RegisterPaymentMyCashAccount_SameMoneyValue() {
        TransactionService service = new TransactionService();
        boolean successTransaction = service.registerPaymentMyCashAccount(contaCash, categoria1, transacaoDTO1);
        MoneyValue expected = new MoneyValue(250.00, CurrencyEnum.EURO);
        MoneyValue result = contaCash.getMoneyBalance();
        assertEquals(expected, result);
        assertTrue(successTransaction);
    }

    @Test
    void NoRegisterPaymentMyCashAccount_DifferentMoneyValue() {
        TransactionService service = new TransactionService();
        assertThrows(IllegalArgumentException.class,()->{
            service.registerPaymentMyCashAccount(contaCash, categoria1, transacaoDTO4);
        });
    }

    @Test
    void NoRegisterPaymentMyCashAccount_NotEnoughMoney() {
        TransactionService service = new TransactionService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.registerPaymentMyCashAccount(contaCash, categoria1, transacaoDTO2);
        });
    }

    @Test
    void NoRegisterPaymentMyCashAccount_NegativeAmmount() {
        TransactionService service = new TransactionService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.registerPaymentMyCashAccount(contaCash, categoria1, transacaoDTO3);
        });
    }

    @Test
    void createListOfMovementsBetweenDates_ResultEmptyListNoMovements() {
        // arrange
        CashAccount cashAccount = new CashAccount(cashAccountDTO, accountID);
        TransactionService service = new TransactionService();
        Date startDate = new Date(2021, Calendar.JANUARY, 22);
        Date endDate = new Date(2021, Calendar.JANUARY, 30);
        List<TransactionDataDTO> expected = new ArrayList<>();

        // act
        List<TransactionDataDTO> result = service.createListOfMovementsBetweenDates(cashAccount, startDate, endDate);

        // assert
        assertEquals(expected, result);
        assertTrue(result.isEmpty());
    }

    @Test
    void createListOfMovementsBetweenDates_ResultEmptyListNoMovementsBetweenDates() {
        // arrange
        CashAccount cashAccount = new CashAccount(cashAccountDTO, accountID);
        TransactionService service = new TransactionService();
        service.registerPaymentMyCashAccount(cashAccount, categoria1, transacaoDTO1);
        Date startDate = new Date(2021, Calendar.JANUARY, 22);
        Date endDate = new Date(2021, Calendar.JANUARY, 30);
        List<TransactionDataDTO> expected = new ArrayList<>();

        // act
        List<TransactionDataDTO> result = service.createListOfMovementsBetweenDates(cashAccount, startDate, endDate);

        // assert
        assertEquals(expected, result);
        assertTrue(result.isEmpty());
    }

    @Test
    void createListOfMovementsBetweenDates_ResultOneMovementList() {
        // arrange
        CashAccount cashAccount = new CashAccount(cashAccountDTO, accountID);
        TransactionService service = new TransactionService();
        service.registerPaymentMyCashAccount(cashAccount, categoria1, transacaoDTO1);
        Date startDate = new Date(2021, Calendar.JANUARY, 20);
        Date endDate = new Date(2021, Calendar.JANUARY, 30);
        MoneyValue remainingAmountOne = new MoneyValue(250.00, CurrencyEnum.EURO);
        CashTransaction cashTransactionOne = new CashTransaction(contaCash, categoria1, credit, remainingAmountOne, transacaoDTO1);
        TransactionDataDTO transactionDataDTOOne = new TransactionDataDTO(cashTransactionOne.getTransactionData());
        List<TransactionDataDTO> expected = new ArrayList<>();
        expected.add(transactionDataDTOOne);
        int expectedSize = 1;

        // act
        List<TransactionDataDTO> result = service.createListOfMovementsBetweenDates(cashAccount, startDate, endDate);

        // assert
        assertEquals(expected, result);
        assertEquals(expectedSize, result.size());
    }

    @Test
    void createListOfMovementsBetweenDates_ResultManyMovementsList() {
        // arrange
        String description = "Cash Account do Ze Manel";
        Double balance = 10000.00;
        int accountID = 1;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(balance, description, selfCC, familyID, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount(cashAccountDTO, accountID);
        TransactionService service = new TransactionService();
        service.registerPaymentMyCashAccount(cashAccount, categoria1, transacaoDTO1);
        service.registerPaymentMyCashAccount(cashAccount, categoria1, transacaoDTO2);
        Date startDate = new Date(2021, Calendar.JANUARY, 20);
        Date endDate = new Date(2021, Calendar.JANUARY, 30);
        List<TransactionDataDTO> expected = new ArrayList<>();
        MoneyValue remainingAmountOne = new MoneyValue(9800.00, CurrencyEnum.EURO);
        CashTransaction cashTransactionOne = new CashTransaction(contaCash, categoria1, credit, remainingAmountOne, transacaoDTO1);
        MoneyValue remainingAmountTwo = new MoneyValue(9200.00, CurrencyEnum.EURO);
        CashTransaction cashTransactionTwo = new CashTransaction(contaCash, categoria1, credit, remainingAmountTwo, transacaoDTO2);
        TransactionDataDTO transactionDataDTOOne = new TransactionDataDTO(cashTransactionOne.getTransactionData());
        TransactionDataDTO transactionDataDTOTwo = new TransactionDataDTO(cashTransactionTwo.getTransactionData());
        expected.add(transactionDataDTOOne);
        expected.add(transactionDataDTOTwo);
        int expectedSize = 2;

        // act
        List<TransactionDataDTO> result = service.createListOfMovementsBetweenDates(cashAccount, startDate, endDate);

        // assert
        assertEquals(expected, result);
        assertEquals(expectedSize, result.size());
    }

    @Test
    void createListOfMovementsBetweenDates_SwitchedDates() {
        // arrange
        String description = "Cash Account do Ze Manel";
        Double balance = 10000.00;
        int accountID = 1;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(balance, description, selfCC, familyID, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount(cashAccountDTO, accountID);
        TransactionService service = new TransactionService();
        service.registerPaymentMyCashAccount(cashAccount, categoria1, transacaoDTO1);
        service.registerPaymentMyCashAccount(cashAccount, categoria1, transacaoDTO2);
        Date endDate = new Date(2021, Calendar.JANUARY, 20);
        Date startDate = new Date(2021, Calendar.JANUARY, 30);
        List<TransactionDataDTO> expected = new ArrayList<>();
        MoneyValue remainingAmountOne = new MoneyValue(9800.00, CurrencyEnum.EURO);
        CashTransaction cashTransactionOne = new CashTransaction(contaCash, categoria1, credit, remainingAmountOne, transacaoDTO1);
        MoneyValue remainingAmountTwo = new MoneyValue(9200.00, CurrencyEnum.EURO);
        CashTransaction cashTransactionTwo = new CashTransaction(contaCash, categoria1, credit, remainingAmountTwo, transacaoDTO2);
        TransactionDataDTO transactionDataDTOOne = new TransactionDataDTO(cashTransactionOne.getTransactionData());
        TransactionDataDTO transactionDataDTOTwo = new TransactionDataDTO(cashTransactionTwo.getTransactionData());
        expected.add(transactionDataDTOOne);
        expected.add(transactionDataDTOTwo);
        int expectedSize = 2;

        // act
        List<TransactionDataDTO> result = service.createListOfMovementsBetweenDates(cashAccount, startDate, endDate);

        // assert
        assertEquals(expected, result);
        assertEquals(expectedSize, result.size());
    }

    @Test
    void createListOfMovementsBetweenDates_DifferentTransactionDates() {
        // arrange
        String description = "Cash Account do Ze Manel";
        Double balance = 10000.00;
        int accountID = 1;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(balance, description, selfCC, familyID, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount(cashAccountDTO, accountID);
        TransactionService service = new TransactionService();
        service.registerPaymentMyCashAccount(cashAccount, categoria1, transacaoDTO1);
        service.registerPaymentMyCashAccount(cashAccount, categoria1, transacaoDTO2);
        Date endDate = new Date(2021, Calendar.JANUARY, 21);
        Date startDate = new Date(2021, Calendar.JANUARY, 30);
        List<TransactionDataDTO> expected = new ArrayList<>();
        MoneyValue remainingAmountTwo = new MoneyValue(9200.00, CurrencyEnum.EURO);
        CashTransaction cashTransactionTwo = new CashTransaction(contaCash, categoria1, credit, remainingAmountTwo, transacaoDTO2);
        TransactionDataDTO transactionDataDTOTwo = new TransactionDataDTO(cashTransactionTwo.getTransactionData());
        expected.add(transactionDataDTOTwo);
        int expectedSize = 1;

        // act
        List<TransactionDataDTO> result = service.createListOfMovementsBetweenDates(cashAccount, startDate, endDate);

        // assert
        assertEquals(expected, result);
        assertEquals(expectedSize, result.size());
    }

    @Test
    void registerCashTransfer_TestValidTransaction() {
        TransactionService service = new TransactionService();

        boolean result = service.registerCashTransfer(contaCash, contaCash, categoria1, transacaoDTO1);

        Assertions.assertTrue(result);
    }

}