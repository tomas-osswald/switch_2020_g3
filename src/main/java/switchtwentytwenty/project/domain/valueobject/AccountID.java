package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class AccountID implements ID<UUID> {

    private final UUID accountID;

    public AccountID(UUID accountID) {
        this.accountID = accountID;
        validateID();
    }

    /**
     * Method that validates a familyID, throws an exception if the ID isn't valid
     */
    private void validateID() {
        if (!isIDValid()) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    /**
     * Method to determine if an ID is valid, i.e. not null
     *
     * @return boolean, true if ID is valid, false otherwise
     */
    private boolean isIDValid() {
        return this.accountID != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountID)) return false;
        AccountID accountID1 = (AccountID) o;
        return accountID.equals(accountID1.accountID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }
}