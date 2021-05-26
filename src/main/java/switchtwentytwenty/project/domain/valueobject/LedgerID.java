package switchtwentytwenty.project.domain.valueobject;

import java.util.UUID;

public class LedgerID implements ID<UUID> {

    private final UUID id;

    public LedgerID(UUID id) {
        this.id = id;
    }

}
