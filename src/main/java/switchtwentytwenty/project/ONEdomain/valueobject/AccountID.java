package switchtwentytwenty.project.ONEdomain.valueobject;

import java.util.UUID;

public class AccountID implements ID<UUID> {

    private UUID id;

    public AccountID(UUID id) {
        this.id = id;
    }
}
