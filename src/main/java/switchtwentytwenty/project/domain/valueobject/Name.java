package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.exceptions.InvalidNameException;

import java.util.Objects;

public class Name implements ValueObject {


    private final String name;

    public Name(String name) {
        validateData(name);
        this.name = name.trim();
    }

    private void validateData(String name) {
        checkName(name);
    }

    private void checkName(String name) {
        String INVALIDNAME = "Name is not valid";
        if(!isValidName(name))
            throw new InvalidNameException(INVALIDNAME);
    }

    // Falta Verificação com regras de negócio
    private boolean isValidName(String name) {
        return name != null && name.trim().length() != 0;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}