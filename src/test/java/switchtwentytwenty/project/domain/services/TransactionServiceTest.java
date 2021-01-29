package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    // FamilyMember
    int familyID = 1;
    String selfCC = "0000000000ZZ4";

    // Category
    StandardCategory parentStandard = new StandardCategory("root",null,1);
    StandardCategory categoria1 = new StandardCategory("Serviços",parentStandard,2);
    StandardCategory categoria2 = new StandardCategory("Serviços",parentStandard,2);

    // CashAccount
    String description = "Cash Account do Ze Manel";
    Double balance = 450.00;
    int accountID = 1;
    AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(balance,description,selfCC,familyID);
    CashAccount contaCash = new CashAccount(cashAccountDTO,accountID);

    // CashTransaction
    double transferedValue = 200;
    int categoryID = 2;
    String transactionDesignation = "Luz Novembro";
    Date transactionDate = new Date(2021,1,21);
    TransferenceDTO transacaoDTO1 = new TransferenceDTO(familyID,selfCC,accountID,transferedValue,categoryID,transactionDesignation,transactionDate);
    TransferenceDTO transacaoDTO2 = new TransferenceDTO(familyID,selfCC,accountID,600,categoryID,transactionDesignation,transactionDate);
    TransferenceDTO transacaoDTO3 = new TransferenceDTO(familyID,selfCC,accountID,-100,categoryID,transactionDesignation,transactionDate);


    @Test
    void RegisterPaymentMyCashAccount() {
        TransactionService service = new TransactionService();
        assertTrue(service.registerPaymentMyCashAccount(contaCash,categoria1,transacaoDTO1));
    }

    @Test
    void NoRegisterPaymentMyCashAccount_NotEnoughMoney() {
        TransactionService service = new TransactionService();
        assertFalse(service.registerPaymentMyCashAccount(contaCash,categoria1,transacaoDTO2));
    }

    @Test
    void NoRegisterPaymentMyCashAccount_NegativeAmmount() {
        TransactionService service = new TransactionService();
        assertFalse(service.registerPaymentMyCashAccount(contaCash,categoria1,transacaoDTO3));
    }

}