package switchtwentytwenty.project.domain.sandbox;

import org.junit.jupiter.api.Test;
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
    void testPureSuccess(){
        Result<String> pass = Result.success();
        assertTrue(pass.isSuccess());
    }

    @Test
    void testPureFailure(){
        Result<String> fail = Result.failure("Fail");
        assertFalse(fail.isSuccess());
    }


}