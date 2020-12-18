# US151 Add email to profile
=======================================


# 1. Requirements

*As a family member, I want to add an email account to my profile*


**Demo1** As a family member, I want to add...

- Demo1.1. The new email familymember@gmail.com

- Demo1.2. The already existing email familymember@gmail.com

We interpreted this requirment as the function of a user to add an email account to his profile information. The email account must not previously exist on his profile, and it must be a valid email format.

# 2. Analysis

In order to fulfill this requirement, we need two main data pieces:
- e-mail address to add
- Family Member ID of the actor's profile

At a later iteration, the family member's ID would be aquired through the Log In information. For this sprint, the ID will have to be inputed along with the e-mail.



# 3. Design

The main process to fulfill this requirement would require the actor to select they want to add an email in the UI, which would then prompt the input of the email adress. In lieu of not having an UI, the Int *FamilyMemberID* and String *emailAdress* will be directly inputed into the AddEmailController. 
````puml
@startuml
autonumber
title addEmail
actor "Family Member" as actor
participant ": UI" as UI
participant ": addEmailController" as controller
participant ": FFMApplication" as application
participant ": Family" as family
participant "ID : FamilyMember" as familym
participant "anEmail: Email" as email

activate actor
actor -> UI: Add Email
activate UI
UI -> actor: Request Necessary Data
deactivate UI
actor -> UI: Input Data(ID, email)
activate UI
UI -> controller: addEmail(ID,email)
activate controller
controller -> application: addEmail(ID,email)
activate application
application -> family: addEmail(ID,email)
activate family
loop find family member
    family -> family: findFamilyMember(ID)
    end
family -> familym: addEmail(email)
activate familym

alt check if email already present TRUE

    familym -> familym: email already registered

else check if email already present FALSE
    familym -> email: createEmail(email)
    activate email
    end

email -> email: validate(email)

alt email valid
    
    familym -> familym: storeEmail(anEmail)
    deactivate email
    familym -> family: Ok
    family -> application: Ok
    application -> controller: Ok
    controller -> UI: Ok
    UI -> actor: Success

else email invalid
    
    familym -> family: Fail
    deactivate familym
    family -> application: Fail
    deactivate family
    application -> controller: Fail
    deactivate application
    controller -> UI: Fail
    deactivate controller
    UI -> actor: Failure
    deactivate UI
    deactivate actor
    end
@enduml
````




## 3.1. Functionality Use
The AddEmailController will invoke the Application object, which stores the Family object, which in turns stores the FamilyMember objects.
Upon finding the corresponding FamilyMember object to the *FamilyMemberID*, it will call its addEmail method. This will involve running the checkIfEmailPresent method. If false, it will then create an Email object after passing a validation of the String *emailAdress* in the Email constructor. This Email object will be stored on the FamilyMember object, and a confirmation will return to the Controller (and at a later stage, the UI). 



## 3.2. Class Diagram
The main Classes involved are:
- AddEmailController
- Application
- Family
- FamilyMember
- Email

![Class Diagram](https://i.imgur.com/aIvHqZg.png)

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



