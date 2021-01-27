package switch2020.project.domain.model;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.user_data.VatNumber;
import switch2020.project.domain.services.FamilyService;

import static org.junit.jupiter.api.Assertions.*;

class VatNumberTest {

    @Test
    void CreateVatNumber_Null(){
        assertThrows(IllegalArgumentException.class,()-> new VatNumber(null));
    }

    @Test
    void CreateVatNumber_IncorrectNumbers(){
        assertThrows(IllegalArgumentException.class,()-> new VatNumber(12345678));
    }

    @Test
    void CreateVatNumber_Valid(){
        int vat = 123456789;
        VatNumber vatNumber = new VatNumber(vat);
        assertTrue(vatNumber.validateVatNumber(vat));
    }
    @Test
    void compareSameVATNumber() {
        int vat = 123456789;
        VatNumber vatNumber = new VatNumber(vat);

        assertSame(vatNumber, vatNumber);
        assertEquals(vatNumber, vatNumber);
    }

    @Test
    void compareVATNumberWithAnotherClass() {
        int vat = 123456789;
        VatNumber vatNumber = new VatNumber(vat);
        FamilyService familyService = new FamilyService();

        assertNotEquals(vatNumber, familyService);
    }
    @Test
    void compareTwoInstanceOfVATNumber() {
        int vat = 123456789;
        VatNumber vatNumber = new VatNumber(vat);

        int vat2 = 123456789;
        VatNumber vatNumber2 = new VatNumber(vat2);

        assertNotSame(vatNumber, vatNumber2);
        assertEquals(vatNumber, vatNumber2);
    }

    @Test
    void compareTwoInstanceOfDifferentVATNumber() {
        int vat = 123456789;
        VatNumber vatNumber = new VatNumber(vat);

        int vat2 = 123456780;
        VatNumber vatNumber2 = new VatNumber(vat2);

        assertNotSame(vatNumber, vatNumber2);
        assertNotEquals(vatNumber, vatNumber2);
    }

}