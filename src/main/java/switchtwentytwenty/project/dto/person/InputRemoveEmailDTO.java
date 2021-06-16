package switchtwentytwenty.project.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InputRemoveEmailDTO {
    private String email;
    private String personID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputRemoveEmailDTO)) return false;
        InputRemoveEmailDTO that = (InputRemoveEmailDTO) o;
        return Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPersonID(), that.getPersonID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPersonID());
    }
}
