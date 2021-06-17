package switchtwentytwenty.project.authentication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class JWTokenUtilTest {

    String secret = "apestogetherstrong";

    JWTokenUtil jwTokenUtil = new JWTokenUtil(secret);

    // User
    String username = "tonyze@latinlover.com";
    String password = "password";
    String role = "systemManager";

    @Test
    void generateTokenSuccess() {
        DAOUser daoUser = new DAOUser();
        daoUser.setUsername(username);
        daoUser.setPassword(password);
        daoUser.setRole(role);

        UserDetails userDetails = new SecurityUser(daoUser.getUsername(), daoUser.getPassword(), daoUser.getRole());

        String jwtEncryptionExpected = "eyJhbGciOiJIUzUxMiJ9";

        String result = jwTokenUtil.generateToken(userDetails);

        assertNotNull(result);
        assertEquals(jwtEncryptionExpected, result.split("\\.")[0]);
        assertTrue(jwTokenUtil.validateToken(result, userDetails));
        assertEquals(jwTokenUtil.getUsernameFromToken(result), username);
    }

}