package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;


import org.springframework.beans.factory.annotation.Autowired;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.EmailAddress;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

public class AddEmailService {

    @Autowired
    IPersonRepository personRepository;



    public void addEmail(AddEmailDTO addEmailDTO) {

        PersonID loggedUserID = new PersonID(addEmailDTO.unpackID());


        EmailAddress email = new EmailAddress(addEmailDTO.unpackEmail());

        Person person = personRepository.getByID(loggedUserID);
        person.addEmail(email);
    }
}
