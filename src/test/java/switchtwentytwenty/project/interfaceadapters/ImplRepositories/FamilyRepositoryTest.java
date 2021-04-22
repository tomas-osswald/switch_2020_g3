package switchtwentytwenty.project.interfaceadapters.ImplRepositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class FamilyRepositoryTest {

    @Mock
    IFamilyRepositoryJPA iFamilyRepositoryJPA;

    @InjectMocks
    FamilyRepository familyRepository;


    // FamilyJPA

    String familyName = "Simpson";
    String registrationDate = "12/12/2020";

    String adminEmail = "email@email.com";
    PersonIDJPA adminID = new PersonIDJPA(adminEmail);

    FamilyIDJPA familyID = new FamilyIDJPA(UUID.randomUUID().toString());

    FamilyJPA familyJPA = new FamilyJPA(familyID,familyName,registrationDate,adminID);

    // End FamilyJPA



    @Test
    void generateID() {
        Optional<FamilyJPA> familyJPAOptional = Optional.empty();

        when(iFamilyRepositoryJPA.findById(any())).thenReturn(familyJPAOptional);

        assertNotNull(familyRepository.generateID());
    }

    @Test
    void generateIDAlreadyPresentCreatesAnother() {
        //FamilyJPA familyJPA = Mockito.mock(FamilyJPA.class);
        FamilyJPA familyJPA = new FamilyJPA(familyID,familyName,registrationDate,adminID);


        Optional<FamilyJPA> familyJPAOptional = Optional.of(familyJPA);

        when(iFamilyRepositoryJPA.findById(any(FamilyIDJPA.class))).thenReturn(familyJPAOptional).thenReturn(Optional.empty());

        //when(iFamilyRepositoryJPA.findById(any())).thenReturn()
        assertNotNull(familyRepository.generateID());
    }
}