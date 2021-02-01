package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetListOfMovementsBetweenDatesControllerTest {

    String cc = "110142608ZZ0";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "diogo@gmail.com";
    int nif = 212122230;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    boolean admin = false;

    String cc2 = "137843828ZX3";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    boolean admin2 = false;

    String cc3 = "137476450ZX0";
    String name3 = "TonyZe";
    Date date3 = new Date(1900, 8, 26);
    int numero3 = 919939998;
    String email3 = "tonyze@gmail.com";
    int nif3 = 212122000;
    String rua3 = "Rua";
    String codPostal3 = "4444-556";
    String local3 = "Gaia";
    String city3 = "Porto";
    boolean admin3 = true;

    FamilyMember familyMember1 = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local, city, admin);
    FamilyMember familyMember2 = new FamilyMember(cc2,name2,date2,numero2,email2,nif2,rua2,codPostal2,local2, city2, admin2);
    FamilyMember familyMember3 = new FamilyMember(cc3,name3,date3,numero3,email3,nif3,rua3,codPostal3,local3, city3, admin3);

    String testFamilyName = "Moura";
    int testFamilyID = 10;
    Family testFamily = new Family(testFamilyName, testFamilyID);
    Application app = new Application(testFamily);
    GetListOfMovementsBetweenDatesController controller = new GetListOfMovementsBetweenDatesController(app);

    double balance = 0.6;
    String accountName = "Savings";
    int cashAccountID = 1;
    int cashAccountBlankID = 2;
    int cashAccountEmptyID = 3;
    AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(balance, accountName, cc, 1);
    AddCashAccountDTO addCashAccountDTOBlankName = new AddCashAccountDTO(balance, "   ", cc2, 1);
    AddCashAccountDTO addCashAccountDTOEmptyName = new AddCashAccountDTO(balance, "", cc3, 1);

    CashAccount cashAccount = new CashAccount(addCashAccountDTO, cashAccountID);
    CashAccount cashAccountBlank = new CashAccount(addCashAccountDTOBlankName, cashAccountBlankID);
    CashAccount cashAccountEmpty = new CashAccount(addCashAccountDTOEmptyName, cashAccountEmptyID);

    Date startDateOne = new Date(2021,0,19);
    Date startDateTwo = new Date(2021,0,20);
    Date startDateThree = new Date(2021,0,21);
    Date endDateOne = new Date(2021,0,29);
    Date endDateTwo = new Date(2021,0,30);
    Date endDateThree = new Date(2021,0,31);

    @BeforeEach
    void setup() {
        testFamily.addFamilyMember(familyMember1);
        testFamily.addFamilyMember(familyMember2);
        testFamily.addFamilyMember(familyMember3);
        familyMember1.addAccount(cashAccount);
        familyMember2.addAccount(cashAccountBlank);
        familyMember3.addAccount(cashAccountEmpty);
    }

    @Test
    void checkIfListObtainedSucccessfully() {
        List<TransactionDataDTO> result = controller.getListOfMovementsBetweenDates(testFamilyID, cc, cashAccountID, startDateOne, endDateThree);
        assertNotNull(result);
    }

    @Test
    void checkIfThrowsWhenNoSuchMemberID() {
        assertNull(controller.getListOfMovementsBetweenDates(testFamilyID, "110142608ZZ1", cashAccountID, startDateOne,startDateTwo));
    }

    @Test
    void checkIfThrowsWhenNoSuchFamilyID() {
        testFamily.addFamilyMember(familyMember3);
        assertNull(controller.getListOfMovementsBetweenDates(11, cc, cashAccountID, startDateOne,startDateTwo));
    }

    @Test
    void checkIfThrowsWhenNoSuchAccountID() {
        testFamily.addFamilyMember(familyMember3);
        assertNull(controller.getListOfMovementsBetweenDates(testFamilyID, cc, 5, startDateOne,startDateTwo));
    }

}