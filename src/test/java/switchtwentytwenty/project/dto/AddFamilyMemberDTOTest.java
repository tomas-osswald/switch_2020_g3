package switchtwentytwenty.project.dto;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.dto.family.AddFamilyMemberDTO;

class AddFamilyMemberDTOTest {

    String adminID = "tonyAdmin@gmail.com";
    String emailID = "tonyZe@gamil.com";
    String name = "Tony";
    String birtDate = "1/1/1991";
    int vatNumber = 2224466;
    Integer phone = 919998877;
    String street = "Rua";
    String city = "Cidade";
    String houseNumber = "03";
    String zipCode = "4321-333";

    AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO();


    @Test
    void getAdminID() {
        familyMemberDTO.setAdminID(adminID);
        String result = familyMemberDTO.getAdminID();

        String expected = "tonyAdmin@gmail.com";

        Assert.assertEquals(expected, result);
    }

    @Test
    void setStreet() {
    }

    @Test
    void setCity() {
    }

    @Test
    void setHouseNumber() {
    }

    @Test
    void setZipCode() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void getName() {
    }

    @Test
    void getBirtDate() {
    }

    @Test
    void getVatNumber() {
    }

    @Test
    void getPhone() {
    }

    @Test
    void getStreet() {
    }

    @Test
    void getCity() {
    }

    @Test
    void getHouseNumber() {
    }

    @Test
    void getZipCode() {
    }

    @Test
    void setAdminID() {
    }

    @Test
    void setEmailID() {
    }

    @Test
    void setName() {
    }

    @Test
    void setBirtDate() {
    }

    @Test
    void setVatNumber() {
    }

    @Test
    void setPhone() {
    }

    @Test
    void testSetStreet() {
    }

    @Test
    void testSetCity() {
    }

    @Test
    void testSetHouseNumber() {
    }

    @Test
    void testSetZipCode() {
    }

    @Test
    void testEquals1() {
    }

    @Test
    void testHashCode1() {
    }
}