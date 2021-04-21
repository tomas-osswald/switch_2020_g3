package switchtwentytwenty.project.interfaceadapters.ImplRepositories;


import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.exceptions.*;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonRepository implements IPersonRepository {

    private final List<Person> people;
    private Map<PersonID, Person> peopleMap = new HashMap();

    public PersonRepository() {
        this.people = new ArrayList<>();
    }

    @Deprecated
    public void createAndAdd(Name name, BirthDate birthDate, PersonID personID, VATNumber vat, PhoneNumber phone, Address address, FamilyID familyID) {
        if (!isPersonIDAlreadyRegistered(personID)) {
            Person person = new Person(name, birthDate, personID, vat, phone, address, familyID);
            this.people.add(person);
        } else {
            throw new EmailAlreadyRegisteredException();
        }
    }

    @Override
    public boolean isPersonIDAlreadyRegistered(PersonID personID) {
        boolean emailIsRegistered = false;
        for (Person person : people) {
            if (person.hasID(personID)) {
                emailIsRegistered = true;
            }
        }
        return emailIsRegistered;
    }

    @Override
    public void updatePerson(Person person) {
        this.peopleMap.put(person.id(), person);
    }

    @Override
    public Person getByID(PersonID email) {
        return retrievePersonFromHashMap(email);
    }

    private Person retrievePersonFromHashMap(PersonID id) {
        return this.peopleMap.get(id);
    }

    @Deprecated
    private Person retrievePersonFromList(PersonID email) {
        Person result = null;
        for (Person person : people) {
            if (person.hasID(email)) {
                result = person;
            }
        }
        validatePersonNotNull(result);
        return result;
    }

    private void validatePersonNotNull(Person person) {
        if (person == null) {
            throw new EmailNotRegisteredException();
        }
    }

    @Deprecated
    public void addEmailToPerson(EmailAddress email, PersonID personID) {
        Person loggedUser = getByID(personID);
        loggedUser.addEmail(email);
    }

    @Override
    @Deprecated
    public FamilyID getPersonFamilyID(PersonID personID) {
        Person person = getByID(personID);
        return person.getFamilyID();
    }

    @Override
    public void add(Person person) {
        if (!peopleMap.containsKey(person.id())) {
            this.peopleMap.put(person.id(), person);
        } else {
            throw new PersonAlreadyRegisteredException("Person is already registered in the database");
        }

    }








 /*   private class People implements Iterable<Person>{
        private final List<Person> people;

        private People(){
            this.people = new ArrayList<>();
        }

        public Iterator<Person> iterator(){
            return this.people.iterator();
        }
    }*/
}
