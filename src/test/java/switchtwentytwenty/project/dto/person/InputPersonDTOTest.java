package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputPersonDTOTest {

    @Test
    @DisplayName("Should return true if two identical InputPersonDTOs are compared with the equals method")
    void testEquals() {
        InputPersonDTO inputPersonDTO1 = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTO2 = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");

        Assertions.assertNotSame(inputPersonDTO1,inputPersonDTO2);
        Assertions.assertEquals(inputPersonDTO1,inputPersonDTO2);

    }

    @Test
    @DisplayName("Should return false if two different InputPersonDTOs are compared with the equals method")
    void testEqualsFalse() {
        InputPersonDTO inputPersonDTO1 = new InputPersonDTO("AAAAtonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTO2 = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");

        Assertions.assertNotSame(inputPersonDTO1,inputPersonDTO2);
        Assertions.assertNotEquals(inputPersonDTO1,inputPersonDTO2);

    }

    @Test
    @DisplayName("Should return true if two identical InputPersonDTOs have their hashcodes compared")
    void testHashCode() {
        InputPersonDTO inputPersonDTO1 = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTO2 = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");

        Assertions.assertNotSame(inputPersonDTO1,inputPersonDTO2);
        Assertions.assertEquals(inputPersonDTO1.hashCode(),inputPersonDTO2.hashCode());
    }

    @Test
    @DisplayName("Should return false if two different InputPersonDTOs have their hashcodes compared")
    void testHashCodeFalse() {
        InputPersonDTO inputPersonDTO1 = new InputPersonDTO("AAAAAtonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");
        InputPersonDTO inputPersonDTO2 = new InputPersonDTO("tonyze@gmail.com","TonyZe","28/12/1990",123123123,919999999,"rua","cidade","23b","1234-123");

        Assertions.assertNotSame(inputPersonDTO1,inputPersonDTO2);
        Assertions.assertNotEquals(inputPersonDTO1.hashCode(),inputPersonDTO2.hashCode());
    }
}