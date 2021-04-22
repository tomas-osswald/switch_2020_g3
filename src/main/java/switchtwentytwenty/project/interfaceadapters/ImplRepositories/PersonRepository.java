package switchtwentytwenty.project.interfaceadapters.ImplRepositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.PersonJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.PersonDataDomainAssembler;
import switchtwentytwenty.project.datamodel.assemblerjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IPersonRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.exceptions.*;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import java.util.*;

@Repository
public class PersonRepository implements IPersonRepository {

    private final List<Person> people;
    private Map<PersonID, Person> peopleMap = new HashMap();

    @Autowired
    private IPersonRepositoryJPA personRepositoryJPA;
    @Autowired
    private PersonDataDomainAssembler personAssembler;

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

    /**
     * Optional says yes or no when you ask something. In this case it says if there is something in the personRepositoryJPA.
     * After you can obtain that something with optional.get().
     * @param personID
     * @return
     */
    @Override
    public boolean isPersonIDAlreadyRegistered(PersonID personID) {
        boolean emailIsRegistered = false;
        Optional<PersonJPA> optional = personRepositoryJPA.findById(new PersonIDJPA(personID.toString()));
        if (optional.isPresent()) {
            emailIsRegistered = true;
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
        if (!isPersonIDAlreadyRegistered(person.id())) {
            PersonJPA personJPA = personAssembler.toData(person);
            personRepositoryJPA.save(personJPA);
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
