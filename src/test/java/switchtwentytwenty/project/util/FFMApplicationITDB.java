package switchtwentytwenty.project.util;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.FFMSpringBootApplication;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class FFMApplicationITDB {

    @Test
    void main() {
        assertDoesNotThrow(() -> FFMSpringBootApplication.main(new String[]{}));
    }
}
