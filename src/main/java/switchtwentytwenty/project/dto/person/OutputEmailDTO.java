package switchtwentytwenty.project.dto.person;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OutputEmailDTO extends RepresentationModel<OutputEmailDTO> {

    private String email;

    private String emailID;

    /**
     * This DTO receives information from the updated Person in the Persistence and retrieves the added email and the newly created
     * email ID (Given by the database). Packages all info to be sent back to the Controller to be converted to an External DTO
     * to be placed in the Response Entity.
     */



    public String unpackEmail() {
        return this.email;
    }

    public String unpackEmailID() {
        return this.emailID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutputEmailDTO that = (OutputEmailDTO) o;
        return Objects.equals(email, that.email) && Objects.equals(emailID, that.emailID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, emailID);
    }
}
