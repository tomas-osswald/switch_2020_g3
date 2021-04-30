package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.AddEmailDTO;


public interface IAddEmailService {
    void addEmail(AddEmailDTO addEmailDTO);
}