package switchtwentytwenty.project.person;

import switchtwentytwenty.project.Person.Person;

public class Relation {

    private Person memberA;
    private Person memberB;
    private String designation;

    public Relation (Person memberA, Person memberB, String designation) {
        validateRelation();
        this.memberA = memberA;
        this.memberB = memberB;
        this.designation = designation;
    }

    private void validateRelation() {

    }
}
