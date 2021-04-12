package switchtwentytwenty.project.ONEdomain.aggregates;

import switchtwentytwenty.project.ONEdomain.valueobject.ID;

public interface AggregateRoot<K extends ID> extends Entity<K> {
    //tirar K extends ID porque o AggregateRoot extende o Entity...?????

}
