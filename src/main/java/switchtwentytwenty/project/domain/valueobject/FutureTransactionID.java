package switchtwentytwenty.project.domain.valueobject;

import java.util.UUID;

public class FutureTransactionID implements ID<UUID> {

    private UUID id;

    public FutureTransactionID(UUID id) {
        this.id = id;
    }
}
