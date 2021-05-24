package switchtwentytwenty.project.domain.valueobject;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
public class Relation implements ValueObject, Comparable<Relation> {
    private final PersonID memberA;
    private final PersonID memberB;
    private final RelationDesignation relationDesignation;
    @Getter
    private long id;

    public Relation(PersonID memberA, PersonID memberB, String designation) {
        this.memberA = memberA;
        this.memberB = memberB;
        this.relationDesignation = new RelationDesignation(designation);
    }

    //private void validateRelation() { } //member A and member B cannot be the same

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;
        return (memberA.equals(relation.memberA) && memberB.equals(relation.memberB)) || (memberA.equals(relation.memberB) && memberB.equals(relation.memberA));
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberA, memberB);
    }

    //TODO: rever isto sff, Johny Sins
    @Override
    public int compareTo(Relation o) {
        int result = -1;
        if (this.memberA.equals(o.memberB) && this.memberB.equals(o.memberA)) result = 0;
        if (this.memberA.equals(o.memberA) && this.memberB.equals(o.memberB)) result = 0;
        return result;
    }
}
