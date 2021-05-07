package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.EmailAddress;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.InternalEmailDTO;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class AddEmailService implements IAddEmailService {

    @Autowired
    IPersonRepository personRepository;

    /**
     * Method was changed because it was previously a void method. Now it receives an InternalEmailDTO (Converted from an addEmailDTO)
     * and returns an OutputEmailDTO
     * @param internalEmailDTO
     * @return OutputEmailDTO
     */
    //TODO alterar o addEmail porque tem de aceitar as duas classes
    @Override
    public OutputEmailDTO addEmail(InternalEmailDTO internalEmailDTO) {

        PersonID loggedUserID = new PersonID(internalEmailDTO.unpackUserID());

        Person person = personRepository.getByID(loggedUserID);
        EmailAddress email = new EmailAddress(internalEmailDTO.unpackEmail());

        person.addEmail(email);
        personRepository.add(person);

      /*  @Override
        public void addEmail(InputEmailDTO inputEmailDTO, UserIDDTO userIDDTO) {

            PersonID loggedUserID = new PersonID(userIDDTO.unpackUserID());
            EmailAddress emailString = new EmailAddress(inputEmailDTO.unpackEmail());
            Person person = personRepository.getByID(loggedUserID);

            person.addEmail(emailString);
            personRepository.add(person);*/
        return null;

    }
}