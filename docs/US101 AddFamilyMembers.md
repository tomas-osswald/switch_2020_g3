# US101 Add FamilyMember to a Family
=======================================


# 1. Requirements

*US101 As a family administrator, I want to add family members.*


**Demo1** As a family Administrator, I want to add...

- Demo1.1. A familyMember to a family

We interpreted this requirement as the function of a familyAdmin to add a new Person to his family. This Person's email account must not exist in the Application neither the vatNumber on any familyMember.

# 2. Analysis

In order to fulfill this requirement, we need two main data pieces:
- Family ID of the actor's profile
- All the data required to create a new Person (name, dateBirth, vat, phone, address)

At a later iteration, the family member's ID would be aquired through the Log In information. For this sprint, the ID will have to be inputed along with the Person's info.



# 3. Design

The main process to fulfill this requirement would require the actor to select they want to add an email in the UI, which would then prompt the input of the email adress. In lieu of not having an UI, the Int *FamilyMemberID* and String *emailAdress* will be directly inputed into the AddEmailController. 
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

## 3.4. Tests 

**Test 1:** Verify that a correct email is accepted

	@Test
    public void verifyCorrectEmail() {
            String emailToAdd = "email@domain.com";
            assertDoesNotThrow(Email.validateEmail(emailToAdd));
	}
**Test 2:** Verify that a null email String is not accepted

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
            String emailToAdd = null;
		Email email = new Email(emailToAdd);

	}
**Test 3:** Verify that an email with two @s is not accepted

	@Test(expected = IllegalArgumentException.class)
		public void ensureDoubleAtNotAllowed() {
            String emailToAdd = "member@domain@com";
		Email email = new Email(emailToAdd);

	}
**Test 4:** Verify that an email with no @ is not accepted

	@Test(expected = IllegalArgumentException.class)
		public void ensureNoAtNotAllowed() {
            String emailToAdd = "member.domain.com";
		Email email = new Email(emailToAdd);

	}
**Test 5:** Verify that an email with no dots is not accepted

	@Test(expected = IllegalArgumentException.class)
		public void ensureNoDotNotAllowed() {
            String emailToAdd = "member@domaindotcom";
		Email email = new Email(emailToAdd);

	}
**Test 6:** Verify that an email with illegal characters is not accepted

	@Test(expected = IllegalArgumentException.class)
		public void ensureExclamationNotAllowed() {
            String emailToAdd = "cool!member@domain.com";
		Email email = new Email(emailToAdd);

	}
**Test 7:** Verify that an email with spaces is not accepted

	@Test(expected = IllegalArgumentException.class)
		public void ensureSpaceNotAllowed() {
            String emailToAdd = "new member@domain.com";
		Email email = new Email(emailToAdd);

	}
**Test 8:** Verify that an already inserted email isn't added

	@Test(expected = IllegalArgumentException.class)
		public void checkEmailAlreadyPresent() {
            ArrayList<Email> expected = new ArrayList<>();
            expected.add(Email email = new Email("member@domain.com");
            String emailToAdd = "member@domain.com";
            String emailToAddDuplicate = "member@domain.com";
            FamilyMember member = new FamilyMember();
            FamilyMember.addEmail(emailToAdd);
            FamilyMember.addEmail(emailToAddDuplicate);
            assertArrayEquals(expected, member.getEmailList());

	}

# 4. Implementation

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integration/Demonstration

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



