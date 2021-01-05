# US002 US002 Get the standard categories tree
==============================================

# 1. Requirements

### *"As a system manager, I want to get the standard categories tree."*

**Demo1** As a system manager, I want to ...

- Demo1.1. show standard categories tree from new application

- Demo1.2. show standard categories tree from categories list that has new added categories

We interpreted this requirement as the function of the system manager to get the standard categories. The standard categories tree must show the "built-in" categories of the application, i.e. the categories that are original from the first state of the application and therefore the ones that are non-editable.


# 2. Analysis

Client requirements define that each transaction has a category and that transactions may grouped by category or class(group) of categories.
In order to fulfill this requirement, we need to define categories as a data structure called tree.
Properties of a Tree: 
 - A tree can contain no nodes or it can contain one special node called the root with zero or more subtrees.
 - Every edge of the tree is directly or indirectly originated from the root.
 - Every child has only one parent, but one parent can have many children.
This data structure is hierarchical and unlike other linear structures like LinkedList thThe standard categories are located right above root.


- categoryID
- parentNumber

For this sprint, the system manager only gets the standard categories tree i.e. the base categories.


# 3. Design

The main process to fulfill this requirement is to request(infer) in the UI for the standard categories. This is achieved through the UI, asking the controller to the application for the standard categories. The application then returns a list object containing the categories identified as standard

````puml
autonumber
title get standard categories list
actor "System Manager" as systemManager
participant ": UI" as ui
participant ": StandardCategories \nController" as controller
participant ":FFMApplication" as app
participant "Categories: \nList<categories>" as list

note left of systemManager:  get the list of \nstandard categories
activate systemManager
systemManager -> ui : request standard categories
activate ui
ui -> controller : getStandardCategoriesList()
activate controller
controller -> app : getStandardCategoriesList()
loop forEach Category in CategoriesList
app -> app : checkIfIsStandardCategory()
end
activate app

activate list


deactivate list
app --> controller : standardCategoriesList
deactivate app
controller --> ui :send StandardCategoriesList
deactivate controller
ui --> systemManager : present categories list
deactivate ui
deactivate systemManager
@enduml
````

## 3.1. Functionality Use

The CategoriesController will invoke the Application object, which stores the CategoriesList object, and in it are the various
category objects. 

## 3.2. Class Diagram

The main Classes involved are:

- StandardCategoriesController
- FFMApplication
- CategoriesList
- Category

## 3.3. Applied Patterns

We applied the GRASP principles of Creator (CategoriesList creates category instances), Information Expert (CategoriesList has all the onformation needed to crete instances of Category)


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
git 
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

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade
com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração)
relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integration/Demonstration

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as
restantes funcionalidades do sistema.*

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por
exemplo, outras alternativas e ou trabalhos futuros relacionados.*



