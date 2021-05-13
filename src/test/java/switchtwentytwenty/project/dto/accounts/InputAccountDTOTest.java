package switchtwentytwenty.project.dto.accounts;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InputAccountDTOTest {
    InputAccountDTO inputAccountDTO = new InputAccountDTO();

    @Test
    void createSuccessfulObjectNoArgsConstructor(){
        assertNotNull(inputAccountDTO);
    }

    @Test
    void setDesignation() {
        String expected = "Account";
        inputAccountDTO.setDesignation(expected);
        String result = inputAccountDTO.getDesignation();
        assertEquals(expected, result);
    }

    @Test
    void setInitialAmount() {
        BigDecimal expected = BigDecimal.valueOf(3);
        inputAccountDTO.setInitialAmount(expected);
        assertEquals(expected, inputAccountDTO.getInitialAmount());
    }

    @Test
    void setCurrency() {
        String expected = "EUR";
        inputAccountDTO.setCurrency(expected);
        String result = inputAccountDTO.getCurrency();
        assertEquals(expected, result);
    }

    @Test
    void setOwnerID() {
        String expected = "tonyze@latinlover.com";
        inputAccountDTO.setOwnerID(expected);
        String result = inputAccountDTO.getOwnerID();
        assertEquals(expected, result);
    }

    @Test
    void setAccountType() {
        String expected = "Cash";
        inputAccountDTO.setAccountType(expected);
        String result = inputAccountDTO.getAccountType();
        assertEquals(expected, result);
    }

    @Test
    void testEquals(){

    }
}