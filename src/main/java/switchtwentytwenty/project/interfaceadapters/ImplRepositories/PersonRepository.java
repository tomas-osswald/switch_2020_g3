package switchtwentytwenty.project.interfaceadapters.ImplRepositories;


import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.exceptions.EmailNotRegisteredException;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class PersonRepository implements IPersonRepository {

    private final List<Person> people;

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
    public Person getByID(PersonID email) {
        return retrievePersonFromList(email);
    }

    private boolean isPersonIDAlreadyRegistered(PersonID personID) {
        boolean emailIsRegistered = false;
        for (Person person : people) {
            if (person.hasID(personID)) {
                emailIsRegistered = true;
            }
        }
        return emailIsRegistered;
    }

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
    public FamilyID getPersonFamilyID(PersonID personID) {
        Person person = getByID(personID);
        return person.getFamilyID();
    }

    @Override
    public void save(Person person) {
        if (!isPersonIDAlreadyRegistered(person.id())) {
            this.people.add(person);
        } else {
            throw new EmailAlreadyRegisteredException();
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
