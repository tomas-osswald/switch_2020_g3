package switchtwentytwenty.project.domain.dtos.input;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import static org.junit.jupiter.api.Assertions.*;

class AddCashAccountDTOTest {

    @Test
    void getCurrency() {
        AddCashAccountDTO addCreditCardAccountDTO = new AddCashAccountDTO(10.00, "Cash", "0000000000ZY4", 1, CurrencyEnum.EURO);
        CurrencyEnum expected = CurrencyEnum.EURO;

        CurrencyEnum result = addCreditCardAccountDTO.getCurrency();

        assertEquals(expected, result);
    }

    @Test
    void getCurrencyNull() {
        CurrencyEnum currencyEnum = null;
        AddCashAccountDTO addCreditCardAccountDTO = new AddCashAccountDTO(10.00, "Cash", "0000000000ZY4", 1, currencyEnum);

        assertNull(addCreditCardAccountDTO.getCurrency());
    }

}