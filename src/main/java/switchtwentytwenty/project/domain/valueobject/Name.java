package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.exceptions.InvalidNameException;

public class Name implements ValueObject {


    private String name;


    public Name(String name) {
        this.name = name;
        validateData();
        trimData();
    }

    private void trimData() {
        this.name = this.name.trim();
    }

    private void validateData() {
        checkName();
    }

    private void checkName() {
        String INVALIDNAME = "Name is not valid";
        if(!isValidName())
            throw new InvalidNameException(INVALIDNAME);
    }

    // Falta Verificação com regras de negócio
    private boolean isValidName() {
        return name != null && name.trim().length() != 0 && !name.isEmpty();
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
