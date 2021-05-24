package switchtwentytwenty.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class FFMSpringBootApplicationTestITDB {
// Test class added ONLY to cover main() invocation not covered by application tests.

    @Test
    void main() {
        assertDoesNotThrow(()-> FFMSpringBootApplication.main(new String[]{}));    }
}
