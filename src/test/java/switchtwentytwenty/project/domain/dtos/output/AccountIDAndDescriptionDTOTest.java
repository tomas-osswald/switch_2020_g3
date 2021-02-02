package switchtwentytwenty.project.domain.dtos.output;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountIDAndDescriptionDTOTest {

    @Test
    void compareSameInstance() {
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(1, "Card");

        assertEquals(accountIDAndDescriptionDTO, accountIDAndDescriptionDTO);
        assertSame(accountIDAndDescriptionDTO, accountIDAndDescriptionDTO);
    }

    @Test
    void compareWithAnotherClass() {
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(1, "Card");
        String other = "other";

        assertNotEquals(other, accountIDAndDescriptionDTO);
        assertNotSame(other, accountIDAndDescriptionDTO);
        assertFalse(accountIDAndDescriptionDTO.equals(other));
    }

    @Test
    void diferentInstanceButEquals() {
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(1, "Card");
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTOTwo = new AccountIDAndDescriptionDTO(1, "Card");

        assertEquals(accountIDAndDescriptionDTO, accountIDAndDescriptionDTOTwo);
        assertNotSame(accountIDAndDescriptionDTO, accountIDAndDescriptionDTOTwo);
    }

    @Test
    void diferentID() {
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(1, "Card");
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTOTwo = new AccountIDAndDescriptionDTO(2, "Card");

        assertNotEquals(accountIDAndDescriptionDTO, accountIDAndDescriptionDTOTwo);
        assertNotSame(accountIDAndDescriptionDTO, accountIDAndDescriptionDTOTwo);
    }

    @Test
    void diferentDescription() {
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(1, "Card");
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTOTwo = new AccountIDAndDescriptionDTO(1, "Car");

        assertNotEquals(accountIDAndDescriptionDTO, accountIDAndDescriptionDTOTwo);
        assertNotSame(accountIDAndDescriptionDTO, accountIDAndDescriptionDTOTwo);
    }

    @Test
    void testHashCodeNotEquals() {
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(1, "Card");

        int notExpected = 0;
        int result = accountIDAndDescriptionDTO.hashCode();
        assertNotEquals(notExpected, result);
    }

    @Test
    void testHashCodeEquals() {
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(1, "Card");
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTOTwo = new AccountIDAndDescriptionDTO(1, "Card");

        int resultOne = accountIDAndDescriptionDTO.hashCode();
        int resultTwo = accountIDAndDescriptionDTOTwo.hashCode();
        assertEquals(resultOne, resultTwo);
    }

    @Test
    void testHashCodeNotEqualsTwo() {
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTO = new AccountIDAndDescriptionDTO(2, "Card");
        AccountIDAndDescriptionDTO accountIDAndDescriptionDTOTwo = new AccountIDAndDescriptionDTO(1, "Card");

        int resultOne = accountIDAndDescriptionDTO.hashCode();
        int resultTwo = accountIDAndDescriptionDTOTwo.hashCode();
        assertNotEquals(resultOne, resultTwo);
    }
}