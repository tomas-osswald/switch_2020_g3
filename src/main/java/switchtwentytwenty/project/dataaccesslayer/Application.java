package switchtwentytwenty.project.dataaccesslayer;

import switchtwentytwenty.project.domain.person.Person;

public class Application {
    private PersonRepository personRepository;
    private FamilyRepository familyRepository;
    private CategoryRepository categoryRepository;
    private Person loggedPerson;

    public Application() {
        this.personRepository = new PersonRepository();
        this.familyRepository = new FamilyRepository();
        this.categoryRepository = new CategoryRepository();
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

    @Deprecated
    public void logInAsAdmin() {
        this.loggedPerson = personRepository.getPersonByEmail(familyRepository.getFirstAdminEmail());
    }

    @Deprecated
    public void logInAsNotAdmin() {
        this.loggedPerson = null;
    }
}
