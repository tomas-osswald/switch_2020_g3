package switchtwentytwenty.project.dataaccesslayer;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService() {
        this.personRepository = new PersonRepository();
    }
}
