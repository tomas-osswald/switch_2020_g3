package switchtwentytwenty.project.authentication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebSecurityConfigTest {

    WebSecurityConfig webSecurityConfig = new WebSecurityConfig();

    @Test
    void passwordEncoder() {
        assertNotNull(webSecurityConfig.passwordEncoder());
    }

    @Test
    void authenticationManagerBean() {
        assertThrows(Exception.class, ()-> webSecurityConfig.authenticationManagerBean());
    }

    @Test
    void corsFilter() {
        assertNotNull(webSecurityConfig.corsFilter());
    }
}