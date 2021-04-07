package switchtwentytwenty.project;

import switchtwentytwenty.project.ONEdomain.aggregates.person.Person;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.CategoryRepository;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.FamilyRepository;
import switchtwentytwenty.project.THREEinterfaceadapters.repositories.PersonRepository;
import switchtwentytwenty.project.ONEdomain.valueobject.EmailAddress;
import switchtwentytwenty.project.ONEdomain.valueobject.FamilyID;

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

    @Deprecated
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
        this.loggedPerson = personRepository.getByID(familyRepository.getFirstAdminEmail());
    }

    @Deprecated
    public void logInAsNotAdmin() {
        this.loggedPerson = null;
    }

    public EmailAddress getLoggedPersonID() {
        return this.loggedPerson.id();
    }

    public FamilyID getLoggedPersonFamilyID() {
        return this.loggedPerson.getFamilyID();
    }


}
