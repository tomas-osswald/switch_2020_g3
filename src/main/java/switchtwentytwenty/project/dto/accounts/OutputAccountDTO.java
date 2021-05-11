package switchtwentytwenty.project.dto.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
public class OutputAccountDTO extends RepresentationModel {

    //Criado para não "partir" o getAccountID() do Rest Controller antes de juntar todas as partes.
    private String accountID;


}
