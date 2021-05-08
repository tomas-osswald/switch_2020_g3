package switchtwentytwenty.project.dto;

public class InternalEmailDTO {

    private final String id;
    private final String email;


    public InternalEmailDTO(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String unpackEmail(){
        return this.email;
    }

    public String unpackUserID() { return this.id; }

}
