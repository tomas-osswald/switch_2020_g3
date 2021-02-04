package switchtwentytwenty.project.domain.dtos.input;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import static org.junit.jupiter.api.Assertions.*;

class AddBankSavingsAccountDTOTest {

    @Test
    void getCurrency() {
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(20.00, 1.00, "Card", "0000000ZY4", 1, CurrencyEnum.EURO);

        CurrencyEnum equals = CurrencyEnum.EURO;
        CurrencyEnum notEquals = CurrencyEnum.YEN;

        assertNotNull(addBankSavingsAccountDTO.getCurrency());
        assertEquals(addBankSavingsAccountDTO.getCurrency(), equals);
        assertNotEquals(addBankSavingsAccountDTO.getCurrency(), notEquals);
    }
}