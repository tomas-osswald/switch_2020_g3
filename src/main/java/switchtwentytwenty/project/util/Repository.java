package switchtwentytwenty.project.util;

import switchtwentytwenty.project.domain.family.Family;
import switchtwentytwenty.project.domain.person.Person;
import switchtwentytwenty.project.shared.EmailAddress;
import switchtwentytwenty.project.shared.FamilyID;

public interface Repository<T extends Entity,K extends ID>{

    /**
     *
     * @param id
     * @return
     */
    public T getByID(K id);


}
