package switchtwentytwenty.project.TWOusecaseservices.applicationservices;

import switchtwentytwenty.project.Application;
import switchtwentytwenty.project.ONEdomain.valueobject.PersonID;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.PersonRepository;
import switchtwentytwenty.project.ONEdomain.valueobject.EmailAddress;

public class AddEmailService {

    private Application application;


    public AddEmailService(Application application) {
        this.application = application;

    }

    public void addEmail(AddEmailDTO addEmailDTO) {
        PersonRepository personRepository = application.getPersonRepository();
        PersonID loggedUserID = application.getLoggedPersonID();

        EmailAddress email = new EmailAddress(addEmailDTO.unpackEmail());

        personRepository.addEmailToPerson(email, loggedUserID);
    }
}
