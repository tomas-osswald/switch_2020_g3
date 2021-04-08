package switchtwentytwenty.project.dto;

public class AddEmailDTO {

    String email;

    public AddEmailDTO(String email) {
        this.email = email;
    }

    public String unpackEmail(){
        return this.email;
    }
}
