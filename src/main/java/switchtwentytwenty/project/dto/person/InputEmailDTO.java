package switchtwentytwenty.project.dto.person;

import java.util.Objects;

public class InputEmailDTO {
    private final String email;

    public InputEmailDTO(String email) {
        this.email = email;
    }

    public String unpackEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputEmailDTO that = (InputEmailDTO) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
