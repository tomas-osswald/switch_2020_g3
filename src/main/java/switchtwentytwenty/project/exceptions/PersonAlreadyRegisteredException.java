package switchtwentytwenty.project.exceptions;

public class PersonAlreadyRegisteredException extends IllegalStateException{

//    public PersonAlreadyRegisteredException() {
//        super("This person is already registered in the Application");
//    }

    public PersonAlreadyRegisteredException(String message){
        super(message);
    }
}