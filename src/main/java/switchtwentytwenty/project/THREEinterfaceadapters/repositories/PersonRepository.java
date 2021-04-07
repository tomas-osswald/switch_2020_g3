package switchtwentytwenty.project.THREEinterfaceadapters.repositories;


import switchtwentytwenty.project.ONEdomain.aggregates.person.Person;
import switchtwentytwenty.project.ONEdomain.valueobject.*;
import switchtwentytwenty.project.TWOusecaseservices.irepositories.IPersonRepository;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.exceptions.EmailNotRegisteredException;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class PersonRepository implements IPersonRepository {

    private final List<Person> people;

    public PersonRepository() {
        this.people = new ArrayList<>();
    }


    public synchronized void createAndAddPerson(Name name, BirthDate birthDate, PersonID idEmail, VATNumber vat, PhoneNumber phone, Address address, FamilyID familyID) {
        if (!isPersonIDAlreadyregistered(idEmail)) {
            Person person = new Person(name, birthDate, idEmail, vat, phone, address, familyID);
            this.people.add(person);
        } else {
            throw new EmailAlreadyRegisteredException();
        }
    }

    @Override
    public Person getByID(PersonID email) {
        return retrievePersonFromList(email);
    }

    private boolean isPersonIDAlreadyregistered(PersonID personID) {
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

    public void addEmailToPerson(EmailAddress email, PersonID personID) {
        if(!isPersonIDAlreadyregistered(email.toPersonID())){
        Person loggedUser = getByID(personID);
        loggedUser.addEmail(email);
        }else{
            throw new EmailAlreadyRegisteredException();
        }


    }

    @Override
    public FamilyID getPersonFamilyID(PersonID personID) {
        Person person = getByID(personID);
        return person.getFamilyID();
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
