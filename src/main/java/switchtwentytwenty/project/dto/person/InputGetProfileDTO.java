package switchtwentytwenty.project.dto.person;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class InputGetProfileDTO {

    @Setter
    private String id;

    @Setter
    private String jwt;

    public String unpackID() {
        return this.id;
    }

    public String unpackJWT() {
        return this.jwt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputGetProfileDTO)) return false;
        InputGetProfileDTO that = (InputGetProfileDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(jwt, that.jwt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jwt);
    }
}
