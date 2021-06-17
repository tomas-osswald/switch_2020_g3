package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.authentication.JWTUserDetailsService;
import switchtwentytwenty.project.authentication.UserDao;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IFamilyRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.RelationInputDTOAssembler;
import switchtwentytwenty.project.dto.family.ChangeRelationDTO;
import switchtwentytwenty.project.dto.family.InputChangeRelationDTO;
import switchtwentytwenty.project.interfaceadapters.implrepositories.FamilyRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class ChangeRelationServiceIT {

    ChangeRelationService changeRelationService;

    @Mock
    IFamilyRepositoryJPA iFamilyRepositoryJPA;

    @InjectMocks
    FamilyRepository familyRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    UserDao userDao;

    @InjectMocks
    JWTUserDetailsService jwtUserDetailsService;

    @Autowired
    RelationInputDTOAssembler relationInputDTOAssembler;


    String relationID = "4";
    String familyIDString = "@tonyze@latinlover.com";
    FamilyID familyID = new FamilyID(familyIDString);
    ChangeRelationDTO changeRelationDTO = new ChangeRelationDTO(relationID);
    InputChangeRelationDTO inputChangeRelationDTO = new InputChangeRelationDTO(changeRelationDTO, familyID.toString(), relationID);

    @DisplayName( "Change relation success")
    @Test
    void createRelationSuccessOne() {

     // create Family with relation

        PersonID personOne = new PersonID("tonyze@latinlover.com");
        PersonID personTwo = new PersonID("katia@hotlatina.com");
        PersonID personThree = new PersonID("dimitri@crazyrussian.com");

        RelationDesignation relationOneDesignation = new RelationDesignation("BFF");
        RelationID relationOneID = new RelationID(123);

        RelationDesignation relationTwoDesignation = new RelationDesignation("Cousins");;
        RelationID relationTwoID = new RelationID(456);

        Relation relationOne = new Relation(personOne, personTwo, relationOneDesignation, relationOneID);
        Relation relationTwo = new Relation(personOne, personThree, relationTwoDesignation, relationTwoID);

        List<Relation> relations = new ArrayList<>();
        relations.add(relationOne);
        relations.add(relationTwo);



        // FamilyID familyID, FamilyName adminEmail


       //Relation relations =
       //Family family = new Family()



    // mock family repository JPA
   /* FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyIDString);
    String familyName = "Raimundos";
    String registrationDate = "12/12/2020";
    PersonIDJPA adminID = new PersonIDJPA("@tonyze@latinlover.com");
    FamilyJPA familyJPA =    new FamilyJPA(familyIDJPA, familyName, registrationDate, adminID);*/

    //



        
    }
}