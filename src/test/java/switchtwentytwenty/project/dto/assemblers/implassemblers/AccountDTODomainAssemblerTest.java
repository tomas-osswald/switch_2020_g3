package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountDTODomainAssemblerTest {

    AccountDTODomainAssembler accountDTODomainAssembler = new AccountDTODomainAssembler();

    InputAccountDTO inputAccountDTOa = new InputAccountDTO("balelas", BigDecimal.valueOf(10), "EUR", "tonyze@latinlover.com", "CashAccount");
    InputAccountDTO inputAccountDTOb = new InputAccountDTO("balelas", BigDecimal.valueOf(10), "EUR", "tonyze@latinlover.com", "CreditCardAccount");
    InputAccountDTO inputAccountDTOc = new InputAccountDTO("balelas", BigDecimal.valueOf(10), "EUR", "tonyze@latinlover.com", "BankAccount");
    InputAccountDTO inputAccountDTOd = new InputAccountDTO("balelas", BigDecimal.valueOf(10), "EUR", "tonyze@latinlover.com", "BankSavingsAccount");


    @Test
    void designationToDomainSuccess() {
        Designation expected = new Designation("balelas");
        Designation result = accountDTODomainAssembler.designationToDomain(inputAccountDTOa);

        assertEquals(expected, result);
    }

    @Test
    void initialAmountToDomainSuccess() {
        Monetary expected = new Monetary("EUR", BigDecimal.valueOf(10));
        Monetary result = accountDTODomainAssembler.initialAmountToDomain(inputAccountDTOa);

        assertEquals(expected, result);

    }

    @Test
    void ownerIDToDomainSuccess() {
        OwnerID expected = new PersonID("tonyze@latinlover.com");
        OwnerID result = accountDTODomainAssembler.ownerIDToDomain(inputAccountDTOa);

        assertEquals(expected, result);
    }

    @Test
    void accountTypeCashAccountToDomainSuccess() {
        String expected = "CashAccount";
        String result = accountDTODomainAssembler.accountTypeToDomain(inputAccountDTOa);

        assertEquals(expected, result);
    }

    @Test
    void accountTypeCreditCardAccountToDomainSuccess() {
        String expected = "CreditCardAccount";
        String result = accountDTODomainAssembler.accountTypeToDomain(inputAccountDTOb);

        assertEquals(expected, result);
    }

    @Test
    void accountTypeBankAccountToDomainSuccess() {
        String expected = "BankAccount";
        String result = accountDTODomainAssembler.accountTypeToDomain(inputAccountDTOc);

        assertEquals(expected, result);
    }

    @Test
    void accountTypeBankSavingsAccountToDomainSuccess() {
        String expected = "BankSavingsAccount";
        String result = accountDTODomainAssembler.accountTypeToDomain(inputAccountDTOd);

        assertEquals(expected, result);
    }

    @Test
    void toDTO() {
    }

   }