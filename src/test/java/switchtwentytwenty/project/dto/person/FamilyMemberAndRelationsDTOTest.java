package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Link;
import switchtwentytwenty.project.dto.family.OutputRelationDTO;
import switchtwentytwenty.project.interfaceadapters.controller.implcontrollers.FamilyRESTController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

class FamilyMemberAndRelationsDTOTest {


    @Test
    void testSetName() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();
        expected.setName("tony");
        result.setName("tony");

        assertEquals(result, expected);
    }

    @Test
    void testSetPersonID() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();
        expected.setPersonID("tony@gmail.com");
        result.setPersonID("tony@gmail.com");

        assertEquals(result, expected);
    }

    @Test
    void testSetRelations() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();

        OutputRelationDTO outputRelationDTO = new OutputRelationDTO("tony@gmail.com", "ze@gmail.com","filho","1");
        List<OutputRelationDTO> list = new ArrayList<>();
        list.add(outputRelationDTO);

        expected.setRelations(list);
        result.setRelations(list);

        assertEquals(result, expected);
    }

    @Test
    void testGetName() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();
        expected.setName("tony");
        result.setName("tony");

        assertEquals(result.getName(), expected.getName());
    }

    @Test
    void testGetPersonID() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();
        expected.setPersonID("tony@gmail.com");
        result.setPersonID("tony@gmail.com");

        assertEquals(result.getPersonID(), expected.getPersonID());
    }

    @Test
    void testGetRelations() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();

        OutputRelationDTO outputRelationDTO = new OutputRelationDTO("tony@gmail.com", "ze@gmail.com","filho","1");
        List<OutputRelationDTO> list = new ArrayList<>();
        list.add(outputRelationDTO);

        expected.setRelations(list);
        result.setRelations(list);

        assertEquals(result.getRelations(), expected.getRelations());
    }

    @Test
    void testEqualsSameLink() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();
        expected.setPersonID("tony@gmail.com");
        result.setPersonID("tony@gmail.com");

        Link link1 = linkTo(FamilyRESTController.class).withRel("Add New Relation");

        expected.add(link1);
        result.add(link1);

        assertEquals(expected, result);
    }

    @Test
    void testEqualsDifferentLink() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();
        expected.setPersonID("tony@gmail.com");
        result.setPersonID("tony@gmail.com");

        Link link1 = linkTo(FamilyRESTController.class).withRel("Add New Relation");
        Link link2 = linkTo(FamilyRESTController.class).withRel("x");

        expected.add(link1);
        result.add(link2);

        assertNotEquals(expected, result);
    }

    @Test
    void testSameHashCode() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();
        expected.setPersonID("tony@gmail.com");
        result.setPersonID("tony@gmail.com");

        assertEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    void testDifferentHashCode() {
        FamilyMemberAndRelationsDTO expected = new FamilyMemberAndRelationsDTO();
        FamilyMemberAndRelationsDTO result = new FamilyMemberAndRelationsDTO();
        expected.setPersonID("tony@gmail.com");
        result.setPersonID("tonyZe@gmail.com");

        assertNotEquals(expected.hashCode(), result.hashCode());
    }
}