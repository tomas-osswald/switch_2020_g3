package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateAccountService;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

@Service
public class CreateAccountService implements ICreateAccountService {

    private final IAccountRepository accountRepository;
    private final IAccountDTODomainAssembler accountDTODomainAssembler;

    @Autowired
    public CreateAccountService(IAccountRepository accountRepository, IAccountDTODomainAssembler accountDTODomainAssembler) {
        this.accountRepository = accountRepository;
        this.accountDTODomainAssembler = accountDTODomainAssembler;
    }


    public OutputAccountDTO createAccount(InputAccountDTO inputAccountDTO){

        return null;
    }



 }