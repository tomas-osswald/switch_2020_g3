package switchtwentytwenty.project.dataaccesslayer;

import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.shared.EmailAddress;

public class AddEmailService {

    private Application application;


    public AddEmailService(Application application) {
        this.application = application;

    }

    public void addEmail(AddEmailDTO addEmailDTO) {
        PersonRepository personRepository = application.getPersonRepository();
        EmailAddress loggedUserID = application.getLoggedPersonID();

        EmailAddress email = new EmailAddress(addEmailDTO.unpackEmail());

        personRepository.addEmailToPerson(email, loggedUserID);
    }
}
