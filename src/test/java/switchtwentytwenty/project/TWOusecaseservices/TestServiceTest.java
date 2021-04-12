package switchtwentytwenty.project.TWOusecaseservices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestServiceTest {

    @Mock
    private TestIRepository mockTestRepository;

    @Test
    void getNameById_CorrectID() {
        when(mockTestRepository.getNameByID(150)).thenReturn("TonyZe");
        int id = 150;
        String expected = "TonyZe";

        String result = mockTestRepository.getNameByID(id);

        assertEquals(expected,result);
    }

    @Test
    void getNameById_IncorrectId() {
        when(mockTestRepository.getNameByID(100)).thenReturn("AnaMaria");
        int id = 100;
        String notExpected = "TonyZe";

        String result = mockTestRepository.getNameByID(id);

        assertNotEquals(notExpected,result);
    }
}