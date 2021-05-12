package switchtwentytwenty.project.dto.accounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.hateoas.RepresentationModel;
import switchtwentytwenty.project.domain.valueobject.OwnerID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OutputAccountDTO extends RepresentationModel {

    //Criado para não "partir" o getAccountID() do Rest Controller antes de juntar todas as partes.
    private String accountID;
    private String ownerID;
    private String designation;

}