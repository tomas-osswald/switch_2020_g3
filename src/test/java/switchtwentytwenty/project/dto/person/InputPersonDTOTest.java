package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputPersonDTOTest {

    @Test
    @DisplayName("Should return true if two identical InputPersonDTOs are compared with the equals method")
    void testEquals() {
        InputPersonDTO inputPersonDTOOne = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTOTwo = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");

        Assertions.assertNotSame(inputPersonDTOOne,inputPersonDTOTwo);
        Assertions.assertEquals(inputPersonDTOOne,inputPersonDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two different InputPersonDTOs are compared with the equals method")
    void testEqualsFalse() {
        InputPersonDTO inputPersonDTOOne = new InputPersonDTO("AAAAtonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTOTwo = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");

        Assertions.assertNotEquals(inputPersonDTOOne,inputPersonDTOTwo);
    }

    @Test
    void testEqualsSameObject() {
        InputPersonDTO inputPersonDTOOne = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTOTwo = inputPersonDTOOne;

        Assertions.assertEquals(inputPersonDTOOne,inputPersonDTOTwo);
    }

    @Test
    void testEqualsDifferentObjectTypes() {
        InputPersonDTO inputPersonDTOOne = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        String notInputPersonDTO = "test String";

        Assertions.assertNotEquals(inputPersonDTOOne,notInputPersonDTO);
    }

    @Test
    @DisplayName("Should return true if two identical InputPersonDTOs have their hashcodes compared")
    void testHashCode() {
        InputPersonDTO inputPersonDTOOne = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTOTwo = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");

        Assertions.assertNotSame(inputPersonDTOOne,inputPersonDTOTwo);
        Assertions.assertEquals(inputPersonDTOOne.hashCode(),inputPersonDTOTwo.hashCode());
    }

    @Test
    @DisplayName("Should return false if two different InputPersonDTOs have their hashcodes compared")
    void testHashCodeFalse() {
        InputPersonDTO inputPersonDTOOne = new InputPersonDTO("AAAAAtonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTOTwo = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");

        Assertions.assertNotEquals(inputPersonDTOOne.hashCode(),inputPersonDTOTwo.hashCode());
    }
}