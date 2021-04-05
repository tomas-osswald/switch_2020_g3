package switchtwentytwenty.project.dataaccesslayer;


import switchtwentytwenty.project.shared.Repository;
import switchtwentytwenty.project.domain.person.Person;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.exceptions.EmailNotRegisteredException;
import switchtwentytwenty.project.shared.*;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Repository<Person, EmailAddress> {

    private final List<Person> people;

    public PersonRepository() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public synchronized void createAndAddPerson(Name name, BirthDate birthDate, EmailAddress email, VATNumber vat, PhoneNumber phone, Address address, FamilyID familyID) {
        if (!isEmailAlreadyRegistered(email)) {
            Person person = new Person(name, birthDate, email, vat, phone, address, familyID);
            this.people.add(person);
        } else {
            throw new EmailAlreadyRegisteredException();
        }
    }

    @Override
    public Person getByID(EmailAddress email) {
        return retrievePersonFromList(email);
    }

    private boolean isEmailAlreadyRegistered(EmailAddress email) {
        boolean emailIsRegistered = false;
        for (Person person : people) {
            if (person.hasID(email)) {
                emailIsRegistered = true;
            }
        }
        return emailIsRegistered;
    }

    private Person retrievePersonFromList(EmailAddress email) {
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

    public void addEmailToPerson(EmailAddress email, EmailAddress personID) {
        if (!isEmailAlreadyRegistered(email)) {
            Person loggedUser = getByID(personID);
            loggedUser.addEmail(email);
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
