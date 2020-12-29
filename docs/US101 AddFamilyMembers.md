# US101 Add FamilyMember to a Family
=======================================


# 1. Requirements

### 1.1 Client's Sheet

- As a family Administrator, I want to add a familyMember to a family.

We interpreted this requirement as the function of a familyAdmin to add a new Person to his family. This Person's email account must not exist in the Application neither the vatNumber on any familyMember.

- A familyMember needs to have:
    - ID (unique);
    - Name;
    - VatNumber;
    - Address;
    - Birth date;
    - Phone (one or more);
    - Email (one or more).

### 1.2 US101 Sequence Diagram

````puml
@startuml
autonumber
title addFamilyMember

actor "FamilyAdmin" as actor
participant ": UI" as UI
participant ": addFamilyMemberController" as controller
participant ": FFM Application" as app
participant "aFamily : Family" as family
participant "aFamilyMember : FamilyMember" as person
participant "aVat : VAT" as vat
participant "aAddress : address" as address
participant "aPhone : Phone" as phone

activate actor
actor -> UI: get Family by ID
activate UI
UI -> controller: getFamilyById(familyID)
activate controller
controller -> app: getFamilyById(familyID)
activate app
app -> controller: ok
deactivate app
controller -> UI: ok
deactivate controller
UI -> actor: informs success
deactivate UI

actor -> UI: add Family Member data
activate UI
UI -> actor: ask data
deactivate UI

actor -> UI: inputs required data
activate UI
UI -> controller: addFamilyMember(name,dateBirth,vat,phone,address)
activate controller
controller -> app: addFamilyMember(name,dateBirth,vat,phone,address)
activate app
alt email exists - TRUE
  app -> app: doesEmailExist()
  app -> controller: fail
  controller -> UI: fail
  UI -> actor: failure
else email does not exists - FALSE
end
app -> family: addFamilyMember(name,dateBirth,vat,phone,address)

activate family
alt vat exists - TRUE
  family -> family: doesVatExist()
  family -> app: fail
  app -> controller: fail
  controller -> UI: fail
  UI -> actor: failure
else email does not exists - FALSE
end

family -> person **: create(name,dateBirth,vat,phone,address)
activate person
person -> vat **: create(vat)
person -> address **: create(address)
person -> phone **: create(phone)
deactivate person
family -> family: addMember(aPerson)
family -> app: ok
deactivate family
app -> controller: ok
deactivate app
controller -> UI: ok
deactivate controller
UI -> actor: informs success
deactivate UI
deactivate actor
@enduml
````

### 1.3 Dependencies

This user story has a dependency with these **2** user stories:
- **US010** *(As a system manager, I want to create a family)*
    - In order to be added a family member, the system needs to have a family;
    
- **US011** *(As a system manager, I want to add a family administrator)*
   - In order to be added a family member, the family needs to have a family administrator;
   
# 2. Analysis

In order to fulfill this requirement, we need two main data pieces:
- Family ID of the actor's profile
- All the data required to create a new Person (name, dateBirth, vat, phone, address)

At a later iteration, the family member's ID would be aquired through the Log In information. For this sprint, the ID will have to be inputed along with the Person's info.



# 3. Design

````puml
@startuml
autonumber
title addFamilyMember

actor "FamilyAdmin" as actor
participant ": UI" as UI
participant ": addFamilyMemberController" as controller
participant ": FFM Application" as app
participant "aFamily : Family" as family
participant "aFamilyMember : FamilyMember" as person
participant "aVat : VAT" as vat
participant "aAddress : address" as address
participant "aPhone : Phone" as phone

activate actor
actor -> UI: get Family by ID
activate UI
UI -> controller: getFamilyById(familyID)
activate controller
controller -> app: getFamilyById(familyID)
activate app
app -> controller: ok
deactivate app
controller -> UI: ok
deactivate controller
UI -> actor: informs success
deactivate UI

actor -> UI: add Family Member data
activate UI
UI -> actor: ask data
deactivate UI

actor -> UI: inputs required data
activate UI
UI -> controller: addFamilyMember(name,dateBirth,vat,phone,address)
activate controller
controller -> app: addFamilyMember(name,dateBirth,vat,phone,address)
activate app
alt email exists - TRUE
  app -> app: doesEmailExist()
  app -> controller: fail
  controller -> UI: fail
  UI -> actor: failure
else email does not exists - FALSE
end
app -> family: addFamilyMember(name,dateBirth,vat,phone,address)

activate family
alt vat exists - TRUE
  family -> family: doesVatExist()
  family -> app: fail
  app -> controller: fail
  controller -> UI: fail
  UI -> actor: failure
else email does not exists - FALSE
end

family -> person **: create(name,dateBirth,vat,phone,address)
activate person
person -> vat **: create(vat)
person -> address **: create(address)
person -> phone **: create(phone)
deactivate person
family -> family: addMember(aPerson)
family -> app: ok
deactivate family
app -> controller: ok
deactivate app
controller -> UI: ok
deactivate controller
UI -> actor: informs success
deactivate UI
deactivate actor
@enduml
````

## 3.1. Functionality Use
The AddFamilyMemberController will invoke the Application object, which stores the Family object.
The App will return the FamilyID from the FamilyAdmin and will invoke the addFamilyMember method. First, there will be an email validation inside the Application to ensure that is unique, then the same will be done to the vatNumber inside the Family object because we are assuming that the same Person can be part of different Families. If any of those validations turn to be true the method fails, otherwise the method is executed by calling the FamilyMember constructor, creating a new Person and storing it inside the Family object. 
To finish this process, the Application return a confirmation message to the controller that will inform the UI, and therefore the user, that the method succeeded. 



## 3.2. Class Diagram
The main Classes involved are:
- AddFamilyMemberController
- Application
- Family
- FamilyMember
- Email
- Vat
- Phone

![Class Diagram](https://imgur.com/86GIpDB.png)

## 3.3. Applied Patterns
We applied the principles of Controller, Information Expert, Creator e PureFabrication from the GRASP pattern.
We also used the SOLID SRP principle.

## 3.4. Domain Tests 

#####Test 1: Verify that a vatNumber is accepted
- **1.1.** Verify if the value is not null
- **1.2.** Throw an error if the amount of numbers is incorrect
- **1.3.** Throw an error if there are letters
    
#####Test 2: Verify that an address is accepted
- **2.1.** Verify if the street is not null
- **2.2.** Verify if the postalCode is not null
- **2.3.** Throw an error if the amount of numbers from postalCode is incorrect
- **2.4.** Throw an error if the postalCode has letters
- **2.5.** Verify if the local is not null
- **2.6.** Throw an error if the local has numbers
- **2.7.** Verify if the city is not null
- **2.8.** Throw an error if the city has numbers

#####Test 3: Verify that a birthDate is accepted
- **3.1.** Verify if the birthDate is not null

#####Test 4: Verify that a phone is accepted
- **4.1.** Verify if the phoneNumber is not null
- **4.2.** Throw an error if the amount of numbers is incorrect

#####Test 5: Verify that an email is accepted 
- **5.1.** All email tests are in **US151**

#####Test 6: Verify if the email already exists in the system
- **6.1** Throw an error if the email already exists

#####Test 7: Verify if the VatNumber already belongs to a familyMember inside this family 
- **6.1** Throw an error if the vatNumber already exists in the family

## 3.5. Integration Tests

To assure that the system works correctly with all integrated parts, it's necessary to define a group of Integration Tests that simulate real system actions. The tests are the following:


# 4. Implementation

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integration/Demonstration

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



