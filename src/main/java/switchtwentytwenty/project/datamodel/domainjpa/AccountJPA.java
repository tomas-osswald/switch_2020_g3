package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountJPA {
    @Id
    @Getter
    private AccountIDJPA id;

    @Getter
    private Long balance;
    @Getter
    private PersonIDJPA ownerID;
    @Getter
    private String designation;
    @Getter
    private String accountType;

    /**
     * Constructor for AccountJPA.
     * @param id AccountIDJPA - it's own class to facilitate foreign key usage
     * @param balance Long - the balance currently in the account
     * @param ownerID PersonIDJPA - is a foreign key to PersonJPA
     * @param designation String - name of the account
     * @param accountType String - Type of account
     */
    public AccountJPA (AccountIDJPA id, Long balance, PersonIDJPA ownerID, String designation, String accountType) {
        this.id = id;
        this.balance = balance;
        this.ownerID = ownerID;
        this.designation = designation;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountJPA accountJPA = (AccountJPA) o;
        return id.equals(accountJPA.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

