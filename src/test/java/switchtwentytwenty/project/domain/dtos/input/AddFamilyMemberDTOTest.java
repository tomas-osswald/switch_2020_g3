package switchtwentytwenty.project.domain.dtos.input;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.user_data.CCNumber;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AddFamilyMemberDTOTest {

    String cc = "000000000ZZ4";
    CCNumber ccNumber = new CCNumber(cc);
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    AddFamilyMemberDTO familyMemberDTO1 = new AddFamilyMemberDTO(cc,cc,name,date,numero,email,nif,rua,codPostal,local,city,1);
    AddFamilyMemberDTO familyMemberDTO2 = new AddFamilyMemberDTO(cc,cc,name,null,numero,email,nif,rua,codPostal,local,city,1);

    @Test
    void getBirthDate_CorrectDate() {
        Date expected = new Date(1990, 8, 26);
        Date result = familyMemberDTO1.getBirthDate();
        assertEquals(expected, result);
    }

    @Test
    void getBirthDate_NullDate() {
        int expected = new Date().getDay();
        int result = familyMemberDTO2.getBirthDate().getDay();
        assertEquals(expected,result);
    }

}