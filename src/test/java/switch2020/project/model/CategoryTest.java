package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

   @Test
    void testCheckIfIsStandard() {
       //arrange
       Category cat = new Category("Casa");
       boolean expected = cat.checkIfIsStandard();
       assertTrue(expected);
    }
}