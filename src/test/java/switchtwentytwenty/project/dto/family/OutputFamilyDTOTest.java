package switchtwentytwenty.project.dto.family;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputFamilyDTOTest {

    @Test
    @DisplayName("Test to check if the getFamilyName method functions correctly")
    void getFamilyName() {
        OutputFamilyDTO outputFamilyDTO = new OutputFamilyDTO("Silva", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");
        String expected = "Silva";
        String result = outputFamilyDTO.getFamilyName();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to check if the getAdminID method functions correctly")
    void getAdminID() {
        OutputFamilyDTO outputFamilyDTO = new OutputFamilyDTO("Silva", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");
        String expected = "silva@gmail.com";
        String result = outputFamilyDTO.getAdminID();
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return true if two identical OutputFamilyDTO objects are compared using the equals method")
    void testEquals() {
        OutputFamilyDTO outputFamilyDTO1 = new OutputFamilyDTO("Silva", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");
        OutputFamilyDTO outputFamilyDTO2 = new OutputFamilyDTO("Silva", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");

        Assertions.assertEquals(outputFamilyDTO1, outputFamilyDTO2);
        Assertions.assertNotSame(outputFamilyDTO1, outputFamilyDTO2);

    }

    @Test
    @DisplayName("Should return false if two different OutputFamilyDTO objects are compared using the equals method")
    void testEqualsFail() {
        OutputFamilyDTO outputFamilyDTO1 = new OutputFamilyDTO("Silva", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");
        OutputFamilyDTO outputFamilyDTO2 = new OutputFamilyDTO("Silvas", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");

        Assertions.assertNotEquals(outputFamilyDTO1, outputFamilyDTO2);
        Assertions.assertNotSame(outputFamilyDTO1, outputFamilyDTO2);

    }

    @Test
    @DisplayName("Should return true if two identical OutputFamilyDTO objects are compared using their hash code")
    void testHashCode() {
        OutputFamilyDTO outputFamilyDTO1 = new OutputFamilyDTO("Silva", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");
        OutputFamilyDTO outputFamilyDTO2 = new OutputFamilyDTO("Silva", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");

        Assertions.assertEquals(outputFamilyDTO1.hashCode(), outputFamilyDTO2.hashCode());
        Assertions.assertNotSame(outputFamilyDTO1, outputFamilyDTO2);
    }

    @Test
    @DisplayName("Should return false if two different OutputFamilyDTO objects are compared using their hash code")
    void testHashCodeFail() {
        OutputFamilyDTO outputFamilyDTO1 = new OutputFamilyDTO("Silva", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");
        OutputFamilyDTO outputFamilyDTO2 = new OutputFamilyDTO("Silvas", "@silva@gmail.com", "silva@gmail.com", "12/12/1990");

        Assertions.assertNotEquals(outputFamilyDTO1.hashCode(), outputFamilyDTO2.hashCode());
        Assertions.assertNotSame(outputFamilyDTO1, outputFamilyDTO2);
    }
}