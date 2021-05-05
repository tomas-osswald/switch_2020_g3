package switchtwentytwenty.project.dto.person;
import java.util.Objects;


public class OutputEmailDTO {
    public final String email;

    public String unpackEmail() {
        return email;
    }

    public OutputEmailDTO(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputEmailDTO that = (OutputEmailDTO) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
