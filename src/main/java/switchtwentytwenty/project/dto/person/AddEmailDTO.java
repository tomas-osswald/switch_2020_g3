package switchtwentytwenty.project.dto.person;

import java.util.Objects;

public class AddEmailDTO {

    String email;
    String id;

    public AddEmailDTO(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String unpackEmail() {
        return this.email;
    }

    public String unpackUserID() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddEmailDTO that = (AddEmailDTO) o;
        return email.equals(that.email) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id);
    }
}
