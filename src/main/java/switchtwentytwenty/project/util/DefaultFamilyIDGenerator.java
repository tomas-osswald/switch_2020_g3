package switchtwentytwenty.project.util;

import switchtwentytwenty.project.domain.valueobject.FamilyID;

import java.util.UUID;

public class DefaultFamilyIDGenerator implements FamilyIDGenerator {

    public DefaultFamilyIDGenerator(){};

    @Override
    @Deprecated
    public FamilyID generateID() {
        return new FamilyID("UUID.randomUUID()");
    }
}
