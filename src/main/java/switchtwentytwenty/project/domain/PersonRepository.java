package switchtwentytwenty.project.domain;


import switchtwentytwenty.project.domain.person.Person;
import switchtwentytwenty.project.exceptions.EmailNotRegisteredException;
import switchtwentytwenty.project.shared.EmailAddress;
import switchtwentytwenty.project.Repository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Repository {

    private final List<Person> people;


    public PersonRepository() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }


    public void createPerson() {
        //DTO unpacked aqui ou antes?
    }

    public Person getPersonByEmail(EmailAddress email) {
        return retrievePersonFromList(email);
    }

    private void checkIfEmailIsRegistered(EmailAddress email) {
        boolean emailIsRegistered = false;
        for (Person person : people) {
            if(person.isSameEmail(email)){
                emailIsRegistered = true;
            }
        }
        if(!emailIsRegistered){
            throw new EmailNotRegisteredException();
        }
    }

    private Person retrievePersonFromList(EmailAddress email) {
        checkIfEmailIsRegistered(email);
        Person result = null;
        for (Person person : people) {
            if(person.isSameEmail(email)){
               result = person;
            }
        }
        return result;
    }


 /*   private class People implements Iterable<People>{
        private final List<Person> people;

        private People(){
            this.people = new ArrayList<>();
        }

        public Iterator iterator(){
            return this.people.iterator();
        }
    }*/
}
