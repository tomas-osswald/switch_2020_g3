# US104 Get List of Family Members and Relationship
=======================================


# 1. Requirements

*As a family administrator, I want to get the list of family members and their relationship*


**Demo1** As a family administrator, I want to get... 

- Demo1.1. The list of family members of the Ferreira family and their relationship towards me.

We interpreted this requirement as the function of obtaining the list of all the family members from the family administrator's family
and the family members' relationship towards him.   

# 2. Analysis

In order to fulfill this requirement, we need one data piece:
- *familyID* of the Family Administrator's family

At a later iteration, the family's ID would be aquired through the Log In information of the Family Administrator.
For this sprint, the *familyID* will have to be inputed as a parameter.


# 3. Design

The main process to achieve this requirement would require the actor to select they want to see
the list of family members and the relationships they have towards him. Since we don't have an
UI at the moment, the *familyID* will have to be manually inserted.
````puml
@startuml

' startuml é syntax para iniciar esquema em PlantUML

' autonumber é auto-explicativo
' actor é syntax de ator. participant é syntax de uma Lifeline
' "as" define alias que queremos dar ao participant ou actor

autonumber
title "Obtain list of Family Members and their relationship"
actor "Family Administrator" as actor
participant " : UI" as UI
participant " : getFamilyMembersListController" as controller
participant " : FFMApplication" as application
participant " aFamily : Family" as family
participant " oneFamilyMemberRelationship : FamilyMemberRelationship" as DTO
participant " FMRlist : List <FamilyMemberRelationship> " as DTOlist

/' Comentário: activate é a syntax para ativar lifeline "preenchida" (Não tracejada). 
    Activate só deve ser inserido no momento em que se quer ativar a lifeline preenchida
'/

activate actor



actor -> UI : I want to see the list of family members and their relationship
activate UI
UI -> controller : getFamilyMembersAndRelationship(familyId)
activate controller
controller -> application : getFamilyMembersAndRelationship(familyId)
activate application
application -> family :  getFamilyMembersAndRelationship(familyId)
activate family
family -> family : getFamilyMembers()
family --> application : return List<familyMember>
application -> family : convertToFMR
loop for each Family Member in List<FamilyMember>
    family -> DTOlist ** : create
     family -> DTO ** : create(name, Relationship)
    DTO -> DTOlist : add()
     end
note over family : The list is only stored inside the method scope
family --> application : FMRlist
application -> controller : FMRlist
controller -> UI : FMRlist
UI -> actor : show list of family members and their relationship

@enduml
````



## 3.1. Functionality Use
EDIT EDIT EDIT EDIT

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



