package switchtwentytwenty.project.domain.aggregates.family;

import lombok.Getter;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.domain.aggregates.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Family implements AggregateRoot<FamilyID> {

    private final FamilyID id;
    @Getter
    private FamilyName name;
    @Getter
    private RegistrationDate registrationDate;
    @Getter
    private PersonID admin;
    private final List<Relation> relations = new ArrayList<>();

    public Family(FamilyID familyID, FamilyName familyName, RegistrationDate registrationDate, PersonID adminEmail) {
        this.id = familyID;
        this.name = familyName;
        this.registrationDate = registrationDate;
        this.admin = adminEmail;
    }

    @Override
    public boolean hasID(FamilyID familyID) { //Implementado do Agregate Root ?
        return this.id.equals(familyID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return id.equals(family.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isPersonTheAdmin(PersonID loggedUserID) {
        return loggedUserID.equals(this.admin);
    }

    @Override
    public FamilyID id() {
        return this.id;
    }


}