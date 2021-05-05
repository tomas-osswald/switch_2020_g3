package switchtwentytwenty.project.dto.person;

import java.util.Objects;

public class InputPersonIDDTO {


    private final String personID;

    public InputPersonIDDTO(String personID) {
        this.personID = personID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputPersonIDDTO that = (InputPersonIDDTO) o;
        return Objects.equals(personID, that.personID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personID);
    }

    public String unpackUserID() {
        return this.personID;
    }
}
