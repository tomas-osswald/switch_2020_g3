package switchtwentytwenty.project.domain.dtos.input;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AddCreditCardAccountDTOTest {

    String cc = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    @Test
    void getCardDescription() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 1, "Card", 100.00, 50.00, 25.00, CurrencyEnum.EURO);
        String expected = "Card";

        String result = addCreditCardAccountDTO.getCardDescription();

        assertEquals(expected, result);
    }

    @Test
    void getCardDescriptionEmpty() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 1, "", 100.00, 50.00, 25.00, CurrencyEnum.EURO);
        String expected = "";

        String result = addCreditCardAccountDTO.getCardDescription();

        assertEquals(expected, result);
    }

    @Test
    void getCardDescriptionNull() {
        String cardDescription = null;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 1, cardDescription, 100.00, 50.00, 25.00, CurrencyEnum.EURO);

        assertNull(addCreditCardAccountDTO.getCardDescription());
    }

    @Test
    void getCurrency() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 1, "Card", 100.00, 50.00, 25.00, CurrencyEnum.EURO);
        CurrencyEnum expected = CurrencyEnum.EURO;

        CurrencyEnum result = addCreditCardAccountDTO.getCurrency();

        assertEquals(expected, result);
    }

    @Test
    void getCurrencyNull() {
        CurrencyEnum currencyEnum = null;
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 1, "Card", 100.00, 50.00, 25.00, currencyEnum);

        assertNull(addCreditCardAccountDTO.getCurrency());
    }
}