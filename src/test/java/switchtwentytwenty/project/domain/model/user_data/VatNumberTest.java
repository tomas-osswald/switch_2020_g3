package switchtwentytwenty.project.domain.model.user_data;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.services.FamilyService;

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
        VatNumber vatNumber2 = new VatNumber(vat);

        assertSame(vatNumber, vatNumber2);
        assertEquals(vatNumber, vatNumber2);
    }

    @Test
    void compareVATNumberWithAnotherClass() {
        Integer number = 957247231;
        PhoneNumber phoneNumber = new PhoneNumber(number);
        int vat = 123456789;
        VatNumber vatNumber = new VatNumber(vat);

        assertNotEquals(vatNumber, phoneNumber);
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

    @Test
    void testHashCodeEqualObjects() {
        int vat = 123456789;
        VatNumber expected = new VatNumber(vat);
        VatNumber result = new VatNumber(vat);
        assertEquals(result.hashCode(), expected.hashCode());
    }

    @Test
    void testHashCodeDifferentObjects() {
        int vat = 123456789;
        int vat2 = 123456780;
        VatNumber expected = new VatNumber(vat);
        VatNumber result = new VatNumber(vat2);
        assertNotEquals(result.hashCode(), expected.hashCode());
    }

}