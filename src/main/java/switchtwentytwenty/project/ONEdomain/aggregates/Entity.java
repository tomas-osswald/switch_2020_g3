package switchtwentytwenty.project.ONEdomain.aggregates;

import switchtwentytwenty.project.ONEdomain.valueobject.ID;

public interface Entity <K extends ID> {
    public K id();

    public boolean hasID(ID id);

}
