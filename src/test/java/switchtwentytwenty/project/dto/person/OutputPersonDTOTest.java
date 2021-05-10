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
    List<String> EMAILLISTTWO = new ArrayList<String>();
    List<Integer> PHONELIST = new ArrayList<Integer>();
    List<Integer> PHONELISTTWO = new ArrayList<Integer>();
    String VAT = "123456789";
    String ADDRESS = "Address";
    String FAMILYID = "@tony@gmail.com";

    @Test
    @DisplayName("Should return true if two identical OutputPersonDTO objects are compared using the equals method")
    void testEquals() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotSame(outputPersonDTOOne,outputPersonDTOTwo);
        Assertions.assertEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two  OutputPersonDTO objects with different ids are compared using the equals method")
    void testEqualsFalseDifferentIDs() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO("notTony@gmail.com",NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two  OutputPersonDTO objects with different names are compared using the equals method")
    void testEqualsFalseDifferentNames() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,"notTony",BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two  OutputPersonDTO objects with different BirthDates are compared using the equals method")
    void testEqualsFalseDifferentBirthDates() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,"01/01/1970", EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two  OutputPersonDTO objects with different Emails are compared using the equals method")
    void testEqualsFalseDifferentEmails() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        EMAILLISTTWO.add("otherEmailOne@gmail.com");
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLISTTWO,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two  OutputPersonDTO objects with different PhoneNumbers are compared using the equals method")
    void testEqualsFalseDifferentPhoneNumbers() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        PHONELISTTWO.add(911234567);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLISTTWO,PHONELISTTWO,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two  OutputPersonDTO objects with different VATNumbers are compared using the equals method")
    void testEqualsFalseDifferentVATNumbers() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,"911234567",ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLISTTWO,PHONELISTTWO,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two  OutputPersonDTO objects with different addresses are compared using the equals method")
    void testEqualsFalseDifferentAddresses() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,"otherAddress",FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLISTTWO,PHONELISTTWO,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two  OutputPersonDTO objects with different familyIDs are compared using the equals method")
    void testEqualsFalseDifferentFamilyIDs() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,"admin@gmail.com");
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLISTTWO,PHONELISTTWO,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    void testEqualsSameOutputPersonDTO() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = outputPersonDTOOne;

        Assertions.assertEquals(outputPersonDTOOne,outputPersonDTOTwo);
    }

    @Test
    void testEqualsDifferentObjectTypes() {
        OutputPersonDTO outputPersonDTO = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        String notOutputPersonDTO = "test String";

        Assertions.assertNotEquals(outputPersonDTO,notOutputPersonDTO);
    }

    @Test
    void testEqualsDifferentFromNull() {
        OutputPersonDTO outputPersonDTO = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(null, outputPersonDTO);
    }

    @Test
    @DisplayName("Should return true if two identical OutPutPersonDTO objects have their hash codes compared")
    void testHashCode() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotSame(outputPersonDTOOne,outputPersonDTOTwo);
        Assertions.assertEquals(outputPersonDTOOne.hashCode(),outputPersonDTOTwo.hashCode());
    }

    @Test
    @DisplayName("Should return false if two different OutPutPersonDTO objects have their hash codes compared")
    void testHashCodeFalse() {
        OutputPersonDTO outputPersonDTOOne = new OutputPersonDTO("notTony@gmail.com",NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);
        OutputPersonDTO outputPersonDTOTwo = new OutputPersonDTO(ID,NAME,BIRTHDATE, EMAILLIST,PHONELIST,VAT,ADDRESS,FAMILYID);

        Assertions.assertNotEquals(outputPersonDTOOne.hashCode(),outputPersonDTOTwo.hashCode());
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
        PHONELIST.add(919999999);
        PHONELIST.add(918888888);
        outputPersonDTO.setPhoneNumbers(PHONELIST);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(919999999);
        expected.add(918888888);

        List<Integer> result = outputPersonDTO.getPhoneNumbers();

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