package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.PersonToDTO;
import switchtwentytwenty.project.dto.PersonProfileDTO;
import switchtwentytwenty.project.interfaceadapters.ImplRepositories.PersonRepository;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

@Service
public class GetFamilyMemberProfileService implements IGetFamilyMemberProfileService {

    @Autowired
    PersonRepository personRepository;

    public PersonProfileDTO getFamilyMemberProfile(String emailID){
        PersonID personID = new PersonID(emailID);
        Person person = personRepository.getByID(personID);
        PersonToDTO personToDTO = new PersonToDTO(person);

        return personToDTO.createPersonProfileDTO();
        return null;
    }

}
