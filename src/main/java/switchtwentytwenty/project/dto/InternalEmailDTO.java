package switchtwentytwenty.project.dto;

public class InternalEmailDTO {

    private final String email;

    private final String id;

    public InternalEmailDTO(String email, String id) {
        this.email = email;
        this.id = id;
    }

    public String unpackEmail(){
        return this.email;
    }

    public String unpackUserID() { return this.id; }

}
