package switchtwentytwenty.project.domain.valueobject;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
public class Relation implements ValueObject, Serializable {
    @Getter
    private final PersonID memberA;
    @Getter
    private final PersonID memberB;
    @Getter
    private final RelationDesignation relationDesignation;
    @Getter
    private int id;

    public Relation(PersonID memberA, PersonID memberB, RelationDesignation designation) {
        this.memberA = memberA;
        this.memberB = memberB;
        this.relationDesignation = designation;
        this.id = this.hashCode();
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
}