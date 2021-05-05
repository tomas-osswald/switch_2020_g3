package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.InternalEmailDTO;
import switchtwentytwenty.project.dto.OutputEmailDTO;
import switchtwentytwenty.project.dto.person.AddEmailDTO;


public interface IAddEmailService {
    OutputEmailDTO addEmail(InternalEmailDTO internalEmailDTO);
}