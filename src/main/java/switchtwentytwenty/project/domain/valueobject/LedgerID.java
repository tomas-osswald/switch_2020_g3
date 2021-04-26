package switchtwentytwenty.project.domain.valueobject;

import java.util.UUID;

public class LedgerID implements ID<UUID> {

    private UUID id;

    public LedgerID(UUID id) {
        this.id = id;
    }

}
