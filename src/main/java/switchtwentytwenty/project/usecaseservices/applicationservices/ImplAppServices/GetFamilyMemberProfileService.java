package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.PersonToDTO;
import switchtwentytwenty.project.dto.PersonProfileDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class GetFamilyMemberProfileService implements IGetFamilyMemberProfileService {

    @Autowired
    IPersonRepository personRepository;

    @Autowired
    PersonToDTO personToDTO;

    public PersonProfileDTO getFamilyMemberProfile(String familyMemberID){
        PersonID personID = new PersonID(familyMemberID);
        Person person = personRepository.getByID(personID);

        return personToDTO.createPersonProfileDTO(person);

    }

}
