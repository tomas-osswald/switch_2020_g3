package switchtwentytwenty.project.dto.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import switchtwentytwenty.project.domain.valueobject.Movement;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
public class OutputAccountDTO extends RepresentationModel {

    //Criado para não "partir" o getAccountID() do Rest Controller antes de juntar todas as partes.
    private String accountID;
    private String ownerID;
    private String designation;

    public OutputAccountDTO(String accountID, String ownerID, String designation) {
        this.accountID = accountID;
        this.ownerID = ownerID;
        this.designation = designation;
    }
}