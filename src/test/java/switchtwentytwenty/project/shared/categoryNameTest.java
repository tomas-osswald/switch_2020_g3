package switchtwentytwenty.project.shared;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.exceptions.InvalidNameException;

import static org.junit.jupiter.api.Assertions.*;

class categoryNameTest {

    @Test
    void categoryNameConstructor_Valid(){
        final String name = "TonyZe";
        assertDoesNotThrow( ()-> new CategoryName(name));
    }


    @Test
    void categoryNameConstructor_Invalid_Null(){
        String name = null;
        assertThrows(InvalidNameException.class,()-> {
            new CategoryName(name);
        });
    }

    @Test
    void categoryNameConstructor_Invalid_Empty(){
        String name = "";
        assertThrows(InvalidNameException.class,()-> {
            new CategoryName(name);
        });
    }

    @Test
    void categoryNameConstructor_Invalid_Blank(){
        String name = "      ";
        assertThrows(InvalidNameException.class,()-> {
            new CategoryName(name);
        });
    }
}