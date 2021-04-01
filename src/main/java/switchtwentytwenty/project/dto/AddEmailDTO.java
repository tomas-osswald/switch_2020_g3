package switchtwentytwenty.project.dto;

import switchtwentytwenty.project.shared.EmailAddress;

public class AddEmailDTO {

    String email;

    public AddEmailDTO(String email) {
        this.email = email;
    }

    public String unpackEmail(){
        return this.email;
    }
}
