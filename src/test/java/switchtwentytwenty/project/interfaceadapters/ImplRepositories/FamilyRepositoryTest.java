package switchtwentytwenty.project.interfaceadapters.ImplRepositories;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.FamilyDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;

import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class FamilyRepositoryTest {

    @Mock
    IFamilyRepositoryJPA iFamilyRepositoryJPA;

    @Mock
    FamilyDataDomainAssembler familyDataDomainAssembler;

    @InjectMocks
    FamilyRepository familyRepository;

    @Captor
    ArgumentCaptor<FamilyIDJPA> captorFamilyIDJPA;

    // FamilyJPA

    String familyNameJPA = "Simpson";
    String registrationDateJPA = "12/12/2020";

    String adminEmailJPA = "email@email.com";
    PersonIDJPA adminIDJPA = new PersonIDJPA(adminEmailJPA);

    FamilyIDJPA familyIDJPA = new FamilyIDJPA(UUID.randomUUID().toString());

    // End FamilyJPA

    // Family

    UUID id = UUID.randomUUID();
    FamilyID familyID = new FamilyID("admin@gmail.com");
    String familyNameString = "Ribeiro";
    FamilyName familyName = new FamilyName(familyNameString);
    String date = "12/12/1990";
    RegistrationDate registrationDate = new RegistrationDate(date);
    String emailString = "admin@gmail.com";
    PersonID adminEmail = new PersonID(emailString);

    Family family = new Family(familyID, familyName, registrationDate, adminEmail);


    @Tag("US010")
    @Test
    void addFamily() {
        FamilyJPA familyJPA = new FamilyJPA(familyIDJPA, familyNameJPA, registrationDateJPA, adminIDJPA);

        when(familyDataDomainAssembler.toData(any(Family.class))).thenReturn(familyJPA);

        when(iFamilyRepositoryJPA.save(any(FamilyJPA.class))).thenReturn(familyJPA);

        assertDoesNotThrow(() -> familyRepository.add(family));
    }

    @Test
    void captorFindByID() {
        FamilyIDJPA expected = new FamilyIDJPA("@"+emailString);

        when(iFamilyRepositoryJPA.findById(any(FamilyIDJPA.class))).thenReturn(Optional.of(new FamilyJPA()));

        familyRepository.getByID(familyID);

        verify(iFamilyRepositoryJPA).findById(captorFamilyIDJPA.capture());

        FamilyIDJPA result = captorFamilyIDJPA.getValue();

        assertEquals(expected, result);
    }
}