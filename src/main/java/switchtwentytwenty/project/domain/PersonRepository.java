package switchtwentytwenty.project.domain;

import switchtwentytwenty.project.Person.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private final List<Person> people;


    public PersonRepository(){
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person){
        this.people.add(person);
    }


    public void createPerson(){
        //DTO unpacked aqui ou antes?
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
