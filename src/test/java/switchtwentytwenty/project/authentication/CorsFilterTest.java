package switchtwentytwenty.project.authentication;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CorsFilterTest {

    CorsFilter corsFilter = new CorsFilter();
    FilterChain filterChain = new FilterChain() {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {

        }
    };
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    MockHttpServletResponse expectedResponse = new MockHttpServletResponse();



    @Test
    void doFilter() {

        try {
            corsFilter.doFilter(request, response, filterChain);
        } catch (Exception e) {

        }

        expectedResponse.setHeader("Access-Control-Allow-Origin", "*");
        expectedResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS,PATCH");
        expectedResponse.setHeader("Access-Control-Allow-Headers", "*");
        expectedResponse.setHeader("Access-Control-Allow-Credentials", request.getHeader("Origin"));
        expectedResponse.setHeader("Access-Control-Max-Age", "180");

        assertEquals(response.getHeader("Access-Control-Allow-Origin"), expectedResponse.getHeader("Access-Control-Allow-Origin"));
        assertEquals(response.getHeader("Access-Control-Allow-Methods"), expectedResponse.getHeader("Access-Control-Allow-Methods"));
        assertEquals(response.getHeader("Access-Control-Allow-Headers"), expectedResponse.getHeader("Access-Control-Allow-Headers"));
        assertEquals(response.getHeader("Access-Control-Allow-Credentials"), expectedResponse.getHeader("Access-Control-Allow-Credentials"));
        assertEquals(response.getHeader("Access-Control-Max-Age"), expectedResponse.getHeader("Access-Control-Max-Age"));

    }
}