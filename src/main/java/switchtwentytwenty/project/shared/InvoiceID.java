package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.util.ID;

import java.util.UUID;

public class InvoiceID implements ID<UUID> {

    private UUID id;

    public InvoiceID(UUID id) {
        this.id = id;
    }
}
