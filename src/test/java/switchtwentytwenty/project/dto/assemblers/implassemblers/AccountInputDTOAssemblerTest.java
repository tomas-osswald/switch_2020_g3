package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountInputDTOAssemblerTest {

    AccountInputDTOAssembler accountInputDTOAssembler = new AccountInputDTOAssembler();
    String designation = "Conta";
    String designationTwo = "Account";
    BigDecimal initialAmount = BigDecimal.valueOf(3);
    String currency = "EUR";
    String ownerID = "tonyze@tonyze.com";
    String accountType = "cash";
    CreateAccountDTO createAccountDTO = new CreateAccountDTO(designation, initialAmount, currency, ownerID, accountType);




    @Test
    @DisplayName("Test successful conversion to InputAccountDTO")
    void toInputDTOCreateSuccessfulDTO() {
        InputAccountDTO expected = new InputAccountDTO(designation, initialAmount, currency, ownerID, accountType);

        InputAccountDTO result = accountInputDTOAssembler.toInputDTO(createAccountDTO);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test different DTOs expecting NotEquals")
    void verifyNotEqualsInInputDTOsWithDifferentDesignation() {
        InputAccountDTO expected = new InputAccountDTO(designationTwo, initialAmount, currency, ownerID, accountType);

        InputAccountDTO result = accountInputDTOAssembler.toInputDTO(createAccountDTO);

        assertNotEquals(expected, result);
    }

    @Test
    @DisplayName("Test different DTOs expecting NotEquals")
    void verifySameHashcodeInDifferentObjectsWithSameInformation() {
        InputAccountDTO expected = new InputAccountDTO(designation, initialAmount, currency, ownerID, accountType);

        InputAccountDTO result = accountInputDTOAssembler.toInputDTO(createAccountDTO);

        assertEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    @DisplayName("Test different DTOs expecting NotEquals hashcode")
    void verifyDifferentHashcodeInDifferentDTOsExpectingNotEquals() {
        InputAccountDTO expected = new InputAccountDTO(designationTwo, initialAmount, currency, ownerID, accountType);

        InputAccountDTO result = accountInputDTOAssembler.toInputDTO(createAccountDTO);

        assertNotEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    @DisplayName("Test same object expecting Equals")
    void verifySameObjectsExpectingEquals() {
        InputAccountDTO expected = new InputAccountDTO(designationTwo, initialAmount, currency, ownerID, accountType);

        InputAccountDTO result = expected;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test different objects expecting NotEquals")
    void verifyNullObjectExpectingNotEquals() {
        InputAccountDTO expected = new InputAccountDTO(designationTwo, initialAmount, currency, ownerID, accountType);

        String result = null;

        assertNotEquals(expected, result);
    }

    @Test
    @DisplayName("Test same object expecting Equals")
    void verifyDifferentObjectsExpectingNotEquals() {
        InputAccountDTO expected = new InputAccountDTO(designationTwo, initialAmount, currency, ownerID, accountType);

        String result = "3";

        assertNotEquals(expected, result);
    }
}