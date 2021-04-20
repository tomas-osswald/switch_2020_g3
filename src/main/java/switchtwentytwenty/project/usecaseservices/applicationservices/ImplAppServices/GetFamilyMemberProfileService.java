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

    public PersonProfileDTO getFamilyMemberProfile(String familyMemberID){
        PersonID personID = new PersonID(familyMemberID);
        Person person = personRepository.getByID(personID);
        PersonToDTO personToDTO = new PersonToDTO();

        return personToDTO.createPersonProfileDTO(person);

    }

}
