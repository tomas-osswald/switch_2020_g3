package switchtwentytwenty.project.dataaccesslayer;

import switchtwentytwenty.project.domain.person.Person;

public class Application {
    private PersonRepository personRepository;
    private CategoryRepository categoryRepository;
    private FamilyRepository familyRepository;
    private Person loggedPerson;

    public Application() {
        this.categoryRepository = new CategoryRepository();
        this.familyRepository = new FamilyRepository();
        this.personRepository = new PersonRepository(this.familyRepository);
    }

    public Person getLoggedPerson() {
        return this.loggedPerson;
    }

    public void setLoggedPerson(Person loggedPerson) {
        this.loggedPerson = loggedPerson;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public FamilyRepository getFamilyRepository() {
        return familyRepository;
    }
}
