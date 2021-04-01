package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ID;

import java.util.UUID;

public class AccountID implements ID<UUID> {

    private UUID id;

    public AccountID(UUID id) {
        this.id = id;
    }
}
