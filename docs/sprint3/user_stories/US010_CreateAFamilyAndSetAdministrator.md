# US010 Create a Family and set the Family administrator
=======================================

# 1. Requirements

*As a system administrator, I want to create a family and set a family administrator*

```plantuml
@startuml

header SSD
title Create Family and Set Administrator
autonumber
actor "System Manager" as Actor
participant "System" as System
activate Actor
Actor -> System : Create a family and set administrator
activate System
System -> Actor : Request Family Name and Administrator Data (Name, Birthdate, \nemail (ID), Vat Number, Phone Number, Address and CC number)  
Actor -> System : Input Family Name and Administrator Data (Name, Birthdate, \nemail (ID), Vat Number, Phone Number, Address and CC number)
alt failure
System -> Actor : Inform Failure
else success 
System -> Actor : Inform Success
end
deactivate System
deactivate Actor
@enduml
```

# 2. Analysis

## 2.1 Summary



## 2.2. Domain Model Excerpt

```plantuml
@startuml
header Domain Model
hide methods
hide circle
skinparam linetype ortho

class Family {
 - Name
 - Registration Date
}

class Person {
 - Name
 - Vat number
 - Birthdate
 - Address
 }

class EmailAddress {
 - Email
}

class PhoneNumber {
 - Phone Number
}

class Relation {
 - Type
}

Family "1" -> "0..*" Person: has non-administrator members
Family "1" -> "1" Person: has admin 
Person "1" -> "1..*" EmailAddress: has
Person "1" --> "0..*" PhoneNumber: has
Person "2  " --> "1" Relation: have

@enduml
```


# 3. Design

The process to fulfill this requirement requires the actor to select they want to create a new family, 
which would prompt the input of the designation or name for that family.
Given the current absence of an UI layer the String *familyName* will be passed directly into the AddFamilyController. 

````puml
@startuml
autonumber
header Sequence Diagram
title createFamily
actor "System Manager" as systemManager
participant ": Create\nFamilyController" as controller
participant ": Create\nFamilyService" as FamAdminService
participant " anApplication : \nApplication" as app
participant ": FamilyRepository" as frepository
participant "newFamily : Family" as family
participant "newFamilyName : \nFamilyName" as familyName
participant "newRegistrationDate : \nRegistrationDate" as registrationDate
participant ": PersonRepository" as prepository
participant "administrator : \nPerson" as admin
activate systemManager
systemManager -> controller: CreateFamilyController
activate controller
controller -> FamAdminService : getFamilyService()
activate FamAdminService
FamAdminService -> app : getApplication()
activate app
app -> frepository: createAndAddFamily \n(CreateFamilyDTO, addPersonDTO, Application)
activate frepository
frepository -> frepository : generateFamilyID()
frepository -> family** : create(familyID, adminEmail, \nfamilyName, localDate)
activate family
family ->  familyName** : create
family -> registrationDate** : create
family -> frepository : familyID
deactivate family
frepository -> frepository : addToRepository
return familyID
deactivate app
FamAdminService -> prepository : createPerson()
activate prepository
prepository -> admin** : create
activate admin
return email
prepository -> prepository : verifyEmail
alt Success

prepository -> prepository : addToRepository
return adminEMail
FamAdminService -> controller : success
else Fail

FamAdminService -> frepository : removeFamily(FamilyID)
activate frepository
return success
FamAdminService -> controller 
deactivate FamAdminService
end
return success
deactivate systemManager
@enduml
````

## 3.1. Functionality Use
The AddFamilyController will invoke the Application object, which stores a FamilyService object.
The Application will return the FamilyService, which contains a list of all Families.
The FamilyService then creates a new Family Object and adds it to the existing list.


## 3.2. Class Diagram
```puml
@startuml

title US010 Create a Family and set the Family administrator

'skinparam linetype ortho
'skinparam linetype polyline
hide empty members

class Application {
  + getPersonRepository()
+ getFamilyRepository()
}

class AddFamilyController {
  + createFamilyAndAdmin()
}

class CreateFamilyService {
+ createFamilyAndAddAdmin()
}

class CreateFamilyDTO {
}

class AddPersonDTO {
}

class FamilyID <<ValueObject>> <<ID>> {
}

class Email <<ValueObject>> <<ID>> {
}

class FamilyRepository <<Repository>> {
+ generateAndGetFamilyID()
+ createAndAddFamily()
+ removeFamily()
}

class PersonRepository <<Repository>> {
+ createAndAddPerson()
  
}

class Person <<Entity>> <<Root>> {
}

class Address <<ValueObject>> {
}

class BirthDate <<ValueObject>> {
}

class PhoneNumber <<ValueObject>> {
}

class Name <<ValueObject>> {
}

class VATNumber <<ValueObject>> {
}

class Family <<Entity>> <<Root>> { 
}

class RegistrationDate <<ValueObject>> {
}


AddFamilyController -left--> Application : application
AddFamilyController ---> CreateFamilyDTO
AddFamilyController --> AddPersonDTO
AddFamilyController --.> CreateFamilyService 
CreateFamilyService -right--> Application : application
CreateFamilyService -right--> CreateFamilyDTO : createFamilyDTO
CreateFamilyService -l--> AddPersonDTO : addPersonDTO
CreateFamilyService -up--.> FamilyRepository
CreateFamilyService -d-.> PersonRepository
CreateFamilyService -d-.> FamilyID
CreateFamilyService -down-.> Email
CreateFamilyService -down-.> Address
CreateFamilyService -left-.> BirthDate
CreateFamilyService -l-.> PhoneNumber
CreateFamilyService -d-.> Name
CreateFamilyService -d-.> VATNumber
CreateFamilyService -d-.> RegistrationDate
FamilyRepository *-down- "0..*" Family
PersonRepository *--down-- "0..*" Person
Family -down-> "1" Email : admin
Family -down-> "1" RegistrationDate : registrationDate
Family ---down--> "1" FamilyID : id
Person -up-> "1" FamilyID : id
Person -up-> "1" Email : id
Person -up-> "1" Address : address
Person -up-> "1" BirthDate : birthDate
Person -up-> "0..1" PhoneNumber : phoneNumber
Person -up-> "1" Name : name
Person -up-> "1" VATNumber : vatNumber

@enduml
```

## 3.3. Applied Patterns
We applied the principles of Controller, Information Expert, Creator and PureFabrication from the GRASP pattern.
We also used the SOLID Single Responsibility Principle.

## 3.4. Tests 
    
Several cases where analyzed in order to test the creation of a new Family    

**Test 1:** Test that it is possible to create a new instance of Family with a valid Admin

**Test 2:** Test that it is not possible to create a new instance of Family if admin email is already registered

**Test 3:** Test that it is not possible to create a new instance of Family receiving a **familyName** that is null

**Test 4:** Test that it is not possible to create a new instance of Family receiving a **familyName** that is empty

**Test 5:** Test that it is not possible to create a new instance of Family receiving a **familyName** that is blank

**Additional Tests** Test that its not possible to create a new instance of Family if any attribure is empty, blank or null
The whole user story was tested for the case of success and for failure

**Test 5:** Success
```` 
@DisplayName("Test if a family can be successfully created")  
@Test
 void shouldBeTrueCreateFamily() {
        Application application = new Application();
        Create Family Controller controller = new Create Family Controller(application);
        CreateFamilyDTO createFamilyDTO = new CreateFamilyDTO("tonyze@hotmail.com", "Silva", "Tony", "12/12/1990", 999999999, 919999999, "Rua das Flores", "Porto", 69, "4400-000", "139861572ZW2");
        
        assertTrue(controller.createFamilyAndAdmin(createFamilyDTO));    
    }
````
  
**Test 6:** Failure
````
@DisplayName ("Test if a family isnt created if the admin email is already registered in the app")  
@Test
    void shouldBeFalseCreateFamilyEmailAlreadyregistered() {
        Application application = new Application();
        Create Family Controller controller = new Create Family Controller(application);
        CreateFamilyDTO createFamilyDTO1 = new CreateFamilyDTO("tonyze@hotmail.com", "Silva", "Tony", "12/12/1990", 999999999, 919999999, "Rua das Flores", "Porto", 69, "4400-000", "139861572ZW2");
        CreateFamilyDTO createFamilyDTO2 = new CreateFamilyDTO("tonyze@hotmail.com", "Pereira", "Rita", "12/12/1990", 999999999, 919999999, "Rua das Flores", "Porto", 69, "4400-000", "139861572ZW2");
        controller.createFamilyAndAdmin(createFamilyDTO1);
        assertFalse(controller.createFamilyAndAdmin(createFamilyDTO2));    
    }
    }
````

# 4. Implementation

After providing a family name the FamilyService class creates a new Family object.

# 5. Integration
 
The development of this user story was the basis for the family structure where the FamilyMembers are stored and was thus crucial for the development of the other User Stories

#6. Observations

As with the Standard Category the family ID will probably need to be reworked in a future sprint to allow for more complex ID information if needed (probably using a UUID)