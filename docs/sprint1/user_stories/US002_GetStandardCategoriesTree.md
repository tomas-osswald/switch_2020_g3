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

- categoryName

For this sprint, the system manager only gets the standard categories from the categories list.

# 3. Design

The main process to fulfill this requirement is to request(infer) in the UI for the standard categories.
This is achieved through the UI, asking the controller to the application for the standard categories.
The application then returns a list object containing the categories identified as standard

### Sequence diagram
````puml
autonumber
title get standard categories list - sequence diagram
actor "System Manager" as systemManager
participant ": UI" as ui
participant ": GetStandardCategoriesController" as controller
participant ":Application" as app
participant ": CategoryService" as service
participant ": Categories" as list
note left of systemManager:  get the list of \nstandard categories
activate systemManager
systemManager -> ui : request standard categories
activate ui
ui -> controller : getStandardCategories()
activate controller
controller -> app : getCategoryService()
activate app
activate service
app -> controller : CategoryService
deactivate app
controller -> service : getCategories()
service -> service : createStandardCategoriesList()
activate category
loop for each Category in Categories List
service -> category : getStandardCategories()
alt true
category -> service : List<StandardCategory>
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

The GetStandardCatergoriesTreeController invokes the Application object, that has a Category Service object.
The Application returns the CategoryService that has all the Standard Categories.
The CategoryService creates a List object that all the standard categories and all their childs.

## 3.2. Class Diagram

The main Classes involved are:

- CategoriesController
- Application
- CategoryService

```puml
title Class Diagram

class Application {
  - CategoryService categoryService
  + getCategoryService()
  + getStandardCategoriesTree()
  }

class CategoryService {
  + getStandardCategories()
  + getParents()
  + getChilds()
  + createStdTree()
}

class Categories {
  - List<StandardCategory> categories
 }
 
class Category {
  - String categoryName
  - boolean standard
  - int categoryLevel
  + checkIfIsStandard()
  + addCategoryToStandardList()
}

Application --> CategoryService
CategoryService --> Categories
Categories "1"  --> "*" Category  : has >
```

## 3.3. Applied Patterns

We applied some GRASP principles as Controller, Creator and Information Expert.
We also applied the SOLID SRP (Single Responsabity Principle) in each of the classes.

## 3.4. Tests



# 4. Implementation

From a request the Category Service class creates a new List<StandardCategoryDTO> object that holds each StandardCategoryDTO object that has its own List<StandardCategory> of childs object.
Then after is created a Tree representation that is a List object of the above.

# 5. Integration/Demonstration

The design and development of this user story is important for the application transactions because client requirements want to have the possibility to analyse
monthly and annual spending per category and/or class of categories.
[US110](US110_GetCategoryTree.md) use an implementation of this user story.

# 6. Observations

In future User Stories we need to change something in order to group transactions per category and/or class(group) of categories.
Also the client requirements state "class of categories" as a group or a specific class and that may be only clarified by the product owner in future sprint reviews.





