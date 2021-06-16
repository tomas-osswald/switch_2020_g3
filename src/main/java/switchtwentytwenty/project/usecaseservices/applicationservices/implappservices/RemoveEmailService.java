package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.person.InputRemoveEmailDTO;
import switchtwentytwenty.project.dto.person.OutputRemoveEmailDTO;
import switchtwentytwenty.project.interfaceadapters.implrepositories.PersonRepository;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IRemoveEmailService;

@Service
public class RemoveEmailService implements IRemoveEmailService {

    private PersonRepository personRepository;
    private PersonDTODomainAssembler personDTODomainAssembler;

    public RemoveEmailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public OutputRemoveEmailDTO removeEmail(InputRemoveEmailDTO inputRemoveEmailDTO){

        return null;
    }


}
