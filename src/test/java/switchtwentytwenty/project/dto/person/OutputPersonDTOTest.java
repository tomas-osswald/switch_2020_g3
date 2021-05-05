package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class OutputPersonDTOTest {
    OutputPersonDTO outputPersonDTO = new OutputPersonDTO();
    String ID = "tony@gmail.com";
    String NAME = "Tony";
    String BIRTHDATE = "12/12/1222";
    List<String> EMAILLIST = new ArrayList<String>();
    List<String> PHONELIST = new ArrayList<String>();
    String VAT = "123456789";
    String ADDRESS = "Address";
    String FAMILYID = "@tony@gmail.com";

    @Test
    @DisplayName("Should return true if two identical OutputPersonDTO objects are compared using the equals method")
    void testEquals() {
        OutputPersonDTO outputPersonDTO1 = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTO2 = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotSame(outputPersonDTO1,outputPersonDTO2);
        Assertions.assertEquals(outputPersonDTO1,outputPersonDTO2);


    }

    @Test
    @DisplayName("Should return false if two different OutputPersonDTO objects are compared using the equals method")
    void testEqualsFalse() {
        OutputPersonDTO outputPersonDTO1 = new OutputPersonDTO("notTony@gmail.com",NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTO2 = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotSame(outputPersonDTO1,outputPersonDTO2);
        Assertions.assertNotEquals(outputPersonDTO1,outputPersonDTO2);


    }

    @Test
    @DisplayName("Should return true if two identical OutPutPersonDTO objects have their hash codes compared")
    void testHashCode() {
        OutputPersonDTO outputPersonDTO1 = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTO2 = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotSame(outputPersonDTO1,outputPersonDTO2);
        Assertions.assertEquals(outputPersonDTO1.hashCode(),outputPersonDTO2.hashCode());
    }

    @Test
    @DisplayName("Should return false if two different OutPutPersonDTO objects have their hash codes compared")
    void testHashCodeFalse() {
        OutputPersonDTO outputPersonDTO1 = new OutputPersonDTO("notTony@gmail.com",NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTO2 = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotSame(outputPersonDTO1,outputPersonDTO2);
        Assertions.assertNotEquals(outputPersonDTO1.hashCode(),outputPersonDTO2.hashCode());
    }

    @Test
    @DisplayName("Test to determine the correct function of the getID method")
    void getId() {
        outputPersonDTO.setId(ID);
        String expected = "tony@gmail.com";
        String result = outputPersonDTO.getId();

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getName method")
    void getName() {
        outputPersonDTO.setName(NAME);
        String expected = "Tony";
        String result = outputPersonDTO.getName();

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getBirthdate method")
    void getBirthdate() {
        outputPersonDTO.setBirthdate(BIRTHDATE);
        String expected = "12/12/1222";
        String result = outputPersonDTO.getBirthdate();

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getEmails method")
    void getEmails() {
        EMAILLIST.add("bla@gmail.com");
        EMAILLIST.add("ble@gmail.com");
        outputPersonDTO.setEmails(EMAILLIST);
        List<String> expected = new ArrayList<String>();
        expected.add("bla@gmail.com");
        expected.add("ble@gmail.com");

        List<String> result = outputPersonDTO.getEmails();

        Assertions.assertEquals(expected,result);
        Assertions.assertNotSame(expected,result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getPhoneNumbers method")
    void getPhoneNumbers() {
        PHONELIST.add("919999999");
        PHONELIST.add("918888888");
        outputPersonDTO.setPhoneNumbers(PHONELIST);
        List<String> expected = new ArrayList<String>();
        expected.add("919999999");
        expected.add("918888888");

        List<String> result = outputPersonDTO.getPhoneNumbers();

        Assertions.assertEquals(expected,result);
        Assertions.assertNotSame(expected,result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getVat method")
    void getVat() {
        outputPersonDTO.setVat(VAT);
        String expected = "123456789";
        String result = outputPersonDTO.getVat();

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getAddress method")
    void getAddress() {
        outputPersonDTO.setAddress(ADDRESS);
        String expected = "Address";
        String result = outputPersonDTO.getAddress();

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getFamilyID method")
    void getFamilyID() {
        outputPersonDTO.setFamilyID(FAMILYID);
        String expected = "@tony@gmail.com";
        String result = outputPersonDTO.getFamilyID();

        Assertions.assertEquals(expected,result);
    }


}