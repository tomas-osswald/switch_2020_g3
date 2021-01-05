# US002 US002 Get the standard categories tree
==============================================

# 1. Requirements

*As a system manager, I want to get the standard categories tree.*

**Demo1** As a system manager, I want to ...

- Demo1.1. show standard categories tree from new application

- Demo1.2. show standard categories tree from categories list that has new added categories

We interpreted this requirement as the function of the system manager to get the standard categories. The standard
categories tree must show the "built-in" categories of the application.

# 2. Analysis

In order to fulfill this requirement, we need two data pieces:

- categoryID
- parentNumber

For this sprint, the system manager only gets the standard categories from the categories list.

# 3. Design

The main process to fulfill this requirement is to request(infer) in the UI for the standard categories.
This is achieved through the UI, asking the controller to the application for the standard categories.
The application then returns a list object containing the categories identified as standard

````puml
autonumber
title get standard categories list
actor "System Manager" as systemManager
participant ": UI" as ui
participant ": CategoriesController" as controller
participant ":FFMApplication" as app
participant "Categories: \nList<categories>" as list
participant "Category" as category

note left of systemManager:  get the list of \nstandard categories
activate systemManager
systemManager -> ui : request standard categories
activate ui
ui -> controller : getList()
activate controller
controller -> app : getStandardCategories()
activate app
app -> app : createStandardCategoriesList()
loop for each Category in CategoriesList
activate list
activate category

app -> category : getParentNumber()
alt parentNumber == -1
category -> app : addCategoryToStandardList()
deactivate category
end
end
deactivate list
app --> controller : standardCategoriesList
deactivate app
controller --> ui :StandardCategoriesList
deactivate controller
ui --> systemManager : present standard categories list
deactivate ui
deactivate systemManager
@enduml
````

````puml
autonumber
title get standard categories list
actor "System Manager" as systemManager
participant ": UI" as ui
participant ": CategoriesController" as controller
participant ":FFMApplication" as app
participant ": CategoryService" as service
participant ": Categories List" as list
participant "Category" as category

note left of systemManager:  get the list of \nstandard categories
activate systemManager
systemManager -> ui : request standard categories
activate ui
ui -> controller : getList()
activate controller
controller -> app : getStandardCategories()
activate app
app -> service : getCategoryService()
activate service
service -> service : createStandardCategoriesList()
activate category
loop for each Category in Categories List
activate list
list -> category : getParentNumber()
alt parentNumber == -1
deactivate list
category -> service : addCategoryToStandardList()
service -> app : standardCategories
deactivate service
deactivate category
end
end

app --> controller : standardCategoriesList
deactivate app
controller --> ui :StandardCategoriesList
deactivate controller
ui --> systemManager : present standard categories list
deactivate ui
deactivate systemManager
@enduml
````

````puml
autonumber
title get standard categories list - version service 2
actor "System Manager" as systemManager
participant ": UI" as ui
participant ": CategoriesController" as controller
participant ":FFMApplication" as app
participant ": CategoryService" as service

note left of systemManager:  get the list of \nstandard categories
activate systemManager
systemManager -> ui : request standard categories
activate ui
ui -> controller : getStandardCategories()
activate controller
controller -> app : getCategoryService()
activate app
activate service

app -> controller : CategoryListService
deactivate app
controller -> service : getCategoryService()
service -> service : createStandardCategoriesList()
activate category
loop for each Category in Categories List
service -> category : getParentNumber()
alt parentNumber == -1
category -> service : addCategoryToStandardList()
service -> app : standardCategories
deactivate service
deactivate category
end
end

app --> controller : standardCategoriesList
deactivate app
controller --> ui :StandardCategoriesList
deactivate controller
ui --> systemManager : present standard categories list
deactivate ui
deactivate systemManager
@enduml
````


## 3.1. Functionality Use

The CategoriesController will invoke the FFMApplication object, which handles the Category Service Object.
Category Service has the responsability of managing the categories list.

## 3.2. Class Diagram

The main Classes involved are:

- CategoriesController
- FFMApplication
- CategoryService

## 3.3. Applied Patterns

We applied some GRASP principles as Controller and Creator.

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




