package switchtwentytwenty.project.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class categoryIDTest {

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