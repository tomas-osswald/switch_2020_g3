package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.EmailAddress;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class AddEmailService implements IAddEmailService {

    @Autowired
    IPersonRepository personRepository;

    @Override
    public void addEmail(AddEmailDTO addEmailDTO) {

        PersonID loggedUserID = new PersonID(addEmailDTO.unpackUserID());
        Person person = personRepository.getByID(loggedUserID);

        EmailAddress email = new EmailAddress(addEmailDTO.unpackEmail());

        person.addEmail(email);
        personRepository.addPerson(person);
    }
}
