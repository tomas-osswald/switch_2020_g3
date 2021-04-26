package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryIDTest {

    @Test
    void categoryIDConstructor_Valid(){
        assertDoesNotThrow(()-> new CategoryID());
    }

    @Test
    void categoryIDConstructor_NotEquals(){
        CategoryID ID1 = new CategoryID();
        CategoryID ID2 = new CategoryID();
        assertNotEquals(ID1, ID2);
    }
}