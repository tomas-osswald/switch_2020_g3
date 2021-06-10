package switchtwentytwenty.project.authentication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTResponseTest {

    @Test
    void getTokenTest() {
        JWTResponse jwtResponse = new JWTResponse("testToken");
        String expected = "testToken";

        String result = jwtResponse.getToken();

        assertEquals(expected,result);
    }
}