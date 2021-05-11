package switchtwentytwenty.project.dto.accounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class InputAccountDTO {

    private String designation;
    private Integer initialAmount;
    private String currency;
    private String ownerID;
    private String accountType;

    public InputAccountDTO(String designation, Integer initialAmount, String currency, String ownerID, String accountType) {
        this.designation = designation;
        this.initialAmount = initialAmount;
        this.currency = currency;
        this.ownerID = ownerID;
        this.accountType = accountType;
    }

    }