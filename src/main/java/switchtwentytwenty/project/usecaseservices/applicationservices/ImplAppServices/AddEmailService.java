package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;


import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.interfaceadapters.ImplRepositories.PersonRepository;
import switchtwentytwenty.project.domain.valueobject.EmailAddress;

public class AddEmailService {





//TODO: autowire de personRepository e obter o loggedUserID no addEmailDTO
    public void addEmail(AddEmailDTO addEmailDTO) {
        PersonRepository personRepository = null;
        PersonID loggedUserID = null;

        EmailAddress email = new EmailAddress(addEmailDTO.unpackEmail());

        personRepository.addEmailToPerson(email, loggedUserID);
    }
}
