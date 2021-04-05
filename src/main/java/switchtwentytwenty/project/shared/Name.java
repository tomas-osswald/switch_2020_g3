package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.util.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidNameException;

public class Name implements ValueObject<String> {
    
    private String name;
    private final static String INVALIDNAME = "Name is not valid";

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
        if(!isValidName())
            throw new InvalidNameException(INVALIDNAME);
    }

    // Falta Verificação com regras de negócio
    private boolean isValidName() {
        return name != null && name.trim().length() != 0 && !name.isEmpty();
    }

}
