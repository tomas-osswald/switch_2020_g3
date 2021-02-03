package switchtwentytwenty.project.domain.sandbox;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.output.FamilyWithoutAdministratorDTO;
import switchtwentytwenty.project.domain.model.Family;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void success() {
        Family family = new Family("test", 2);
        Result<Family> success = new Result(true, family);
        assertTrue(success.isSuccess());
    }

    @Test
    void failure() {
        Family family = new Family("test", 2);
        Result<Family> failure = new Result(false, family);
        assertFalse(failure.isSuccess());
    }

    @Test
    void isEquals() {
        Family family = new Family("test", 2);
        Result<Family> result1 = new Result(true, family);
        Result<Family> result2 = new Result(true, family);
        assertNotSame(result1, result2);
        assertEquals(result1, result2);

    }

    @Test
    void testNotEquals() {
        Family family = new Family("test", 2);
        Result<Family> result1 = new Result(true, family);
        Result<Family> result2 = new Result(false, family);
        assertNotSame(result1, result2);
        assertNotEquals(result1, result2);
    }

    @Test
    void testPureSuccess() {
        Result<String> pass = Result.success();
        assertTrue(pass.isSuccess());
    }

    @Test
    void testPureFailure() {
        Result<String> fail = Result.failure("Fail");
        assertFalse(fail.isSuccess());
    }


    @Test
    void compareSameInstance() {
        Result<String> result = Result.success();
        assertSame(result, result);
        assertEquals(result, result);
    }

    @Test
    void compareWithAnotherClass() {
        Result<String> result = Result.success();
        String compare = "result";
        assertNotEquals(result, compare);
    }

    @Test
    void diferentContent() {
        Result<String> resultOne = Result.failure("failure");
        Result<String> resultTwo = Result.failure("falhanço");

        assertNotEquals(resultOne, resultTwo);
    }

    @Test
    void testHashCodeNotEquals() {
        Result<String> result = Result.failure("");

        int notExpected = 0;
        int resultOne = result.hashCode();
        assertNotEquals(notExpected, resultOne);
    }

    @Test
    void testHashCodeEquals() {
        Result<String> resultOneResult = Result.success();
        Result<String> resultTwoResult = Result.success();

        int resultOne = resultTwoResult.hashCode();
        int resultTwo = resultOneResult.hashCode();
        assertEquals(resultOne, resultTwo);
    }

    @Test
    void testHashCodeNotEqualsTwo() {
        Result<String> resultOneResult = Result.failure("Failure");
        Result<String> resultTwoResult = Result.failure("failure");

        int resultOne = resultTwoResult.hashCode();
        int resultTwo = resultOneResult.hashCode();
        assertNotEquals(resultOne, resultTwo);
    }
}