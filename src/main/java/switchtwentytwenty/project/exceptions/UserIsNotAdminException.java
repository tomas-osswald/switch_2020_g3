package switchtwentytwenty.project.exceptions;

public class UserIsNotAdminException extends IllegalStateException{

    public UserIsNotAdminException() {
        super("Logged User isn't the admin");
    }
}
