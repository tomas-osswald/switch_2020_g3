package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ID;

import java.util.UUID;

public class FutureTransactionID implements ID<UUID> {

    private UUID id;

    public FutureTransactionID(UUID id) {
        this.id = id;
    }
}
