package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.ProfileOutputDTO;
import switchtwentytwenty.project.interfaceadapters.ImplRepositories.PersonRepository;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

@Service
public class GetFamilyMemberProfileService implements IGetFamilyMemberProfileService {

    @Autowired
    PersonRepository personRepository;

    public ProfileOutputDTO getFamilyMemberProfile(String email){
        PersonID personID = new PersonID(email);
        Person person = personRepository.getByID(personID);

   //     return PersonToDTO.personToDTO(person);
        return null;
    }

}
