package switchtwentytwenty.project.dto;

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

    public String unpackID() {
        return this.id;
    }
}
