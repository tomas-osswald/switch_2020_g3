package switchtwentytwenty.project.dto.person;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class OutputEmailDTO extends RepresentationModel<OutputEmailDTO> {

    private final String email;
    private final String emailID;

    /**
     * This DTO receives information from the updated Person in the Persistence and retrieves the added email and the newly created
     * email ID (Given by the database). Packages all info to be sent back to the Controller to be converted to an External DTO
     * to be placed in the Response Entity.
     */

    public OutputEmailDTO (String email, Long emailID) {
        this.email = email;
        this.emailID = emailID.toString();
    }

    public String getEmail() {
        return this.email;
    }

    public String getEmailID() {
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
