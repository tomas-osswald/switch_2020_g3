package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VatNumberTest {

    @Test
    void CreateVatNumber_Null(){
        assertThrows(IllegalArgumentException.class,()-> new VatNumber(0));
    }

    @Test
    void CreateVatNumber_IncorrectNumbers(){
        assertThrows(IllegalArgumentException.class,()-> new VatNumber(12345678));
    }

    @Test
    void CreateVatNumber_Valid(){
        int vat = 123456789;
        VatNumber vatNumber = new VatNumber(vat);
        assertTrue(vatNumber.validate(vat));
    }

}