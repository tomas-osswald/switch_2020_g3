package switchtwentytwenty.project.usecaseservices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestServiceTest {

    @Mock
    private TestIRepository mockTestRepository;

    @InjectMocks
    private TestService testService;

    @Test
    void getNameById_CorrectID() {
        Mockito.when(mockTestRepository.getNameByID(100)).thenReturn("TonyZe");
        int id = 150;
        String expected = "TonyZe";

        String result = testService.getNameById(id);

        assertEquals(expected,result);
    }

    @Test
    void getNameById_IncorrectId() {
        Mockito.when(mockTestRepository.getNameByID(100)).thenReturn("AnaMaria");
        int id = 100;
        String notExpected = "TonyZe";

        String result = testService.getNameById(id);

        assertNotEquals(notExpected,result);
    }
}