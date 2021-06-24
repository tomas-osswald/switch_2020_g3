package switchtwentytwenty.project.authentication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CorsFilterTest {

    CorsFilter corsFilter = new CorsFilter();

    @Mock
    FilterChain mockFilterChain;

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
        request.addHeader("Origin", "localhost:3000");

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

    @Test
    void doFilterMockedFilterChain() throws IOException, ServletException {
        request.addHeader("Origin", "localhost:3000");

        doNothing().when(mockFilterChain).doFilter(any(),any());

        try {
            corsFilter.doFilter(request, response, mockFilterChain);
            corsFilter.destroy();
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
        verify(mockFilterChain).doFilter(any(),any());
    }
}