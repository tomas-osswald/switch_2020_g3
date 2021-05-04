package switchtwentytwenty.project.dto;

public class InternalEmailDTO {

    private final String emailToAdd;
    private final String userID;


    public InternalEmailDTO (String emailToAdd, String userID){
        this.emailToAdd = emailToAdd;
        this.userID = userID;
    }

    public String unpackEmail(){
        return this.emailToAdd;

    }

    public String unpackUserID() {
        return this.userID;
    }



}
