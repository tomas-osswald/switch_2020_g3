package switchtwentytwenty.project.TWOusecaseservices.applicationservices;


import switchtwentytwenty.project.ONEdomain.valueobject.PersonID;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.PersonRepository;
import switchtwentytwenty.project.ONEdomain.valueobject.EmailAddress;

public class AddEmailService {





//TODO: autowire de personRepository e obter o loggedUserID no addEmailDTO
    public void addEmail(AddEmailDTO addEmailDTO) {
        PersonRepository personRepository = null;
        PersonID loggedUserID = null;

        EmailAddress email = new EmailAddress(addEmailDTO.unpackEmail());

        personRepository.addEmailToPerson(email, loggedUserID);
    }
}
