package switchtwentytwenty.project.shared;

public interface Repository<T extends Entity,K extends ID>{

    /**
     *
     * @param id
     * @return
     */
    public T getByID(K id);


}
