package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

@SpringBootTest
public class FamilyRepositoryITDB {

    @Autowired
    IFamilyRepository familyRepository;


    @Test
    @DisplayName("Should not throw if PersonID is a registered admin")
    void verifyAdminSuccessTest(){
        PersonID adminID = new PersonID("tonyze@latinlover.com");
        Assertions.assertDoesNotThrow(()-> familyRepository.verifyAdmin(adminID));
    }

    @Test
    @DisplayName("Should throw if PersonID is a registered user thats not an admin")
    void verifyAdminFailureTestNotAdmin(){
        PersonID adminID = new PersonID("kvanessa@latina.com");
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, ()-> familyRepository.verifyAdmin(adminID));
    }

    @Test
    @DisplayName("Should throw if PersonID is not registered in the DB")
    void verifyAdminFailureTestNotRegistered(){
        PersonID adminID = new PersonID("notindb@latinlover.com");
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, ()-> familyRepository.verifyAdmin(adminID));
    }
}
