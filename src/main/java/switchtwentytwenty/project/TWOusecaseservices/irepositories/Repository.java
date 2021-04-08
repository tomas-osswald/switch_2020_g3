package switchtwentytwenty.project.TWOusecaseservices.irepositories;

import switchtwentytwenty.project.ONEdomain.aggregates.Entity;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

public interface Repository<T extends Entity,K extends ID>{

    /**
     *
     * @param id
     * @return
     */
    public T getByID(K id);


}
