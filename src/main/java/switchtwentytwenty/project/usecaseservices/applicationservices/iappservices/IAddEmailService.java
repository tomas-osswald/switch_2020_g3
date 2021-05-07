package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.InternalEmailDTO;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;


public interface IAddEmailService {
    OutputEmailDTO addEmail(InternalEmailDTO internalEmailDTO);
}