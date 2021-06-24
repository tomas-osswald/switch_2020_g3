package switchtwentytwenty.project.authentication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JWTUserDetailsServiceIT {


    @Autowired
    PasswordEncoder bcryptEncoder;

    @Autowired
    JWTUserDetailsService jwtUserDetailsService;


    // User strings
    String username = "tonyze@latinlover.com";
    String password = "password";
    String role = "systemManager";

    @Test
    void saveNewUserTestSuccess() {
        UserDTO userDTO = new UserDTO(username, password, role);

        DAOUser expected = new DAOUser();
        expected.setUsername(username);
        expected.setPassword(bcryptEncoder.encode(password));
        expected.setRole(role);

        DAOUser result = jwtUserDetailsService.save(userDTO);

        assertEquals(expected.getUsername(), result.getUsername());
        assertNotEquals(expected.getPassword(), result.getPassword());
        assertEquals(expected.getRole(), result.getRole());
    }
}
