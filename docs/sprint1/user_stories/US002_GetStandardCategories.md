# US002 US002 Get the standard categories tree
==============================================

# 1. Requirements

*As a system manager, I want to get the standard categories tree.*

**Demo1** As a system manager, I want to get

- Demo1.1. The standard categories tree from new application

- Demo1.2. The standard categories tree from categories list that has new added categories

We interpreted this requirement as the function of the system manager to get the standard categories tree. The standard
categories tree must show the "built-in" categories of the application.
The standard categories tree must present the standard categories in a tree view, i. e., present standard categories in a branch-leave representation.

### System Sequence Diagram

```` puml
    
    autonumber
    title getStandardCategoriesTree SSD
    actor "System Manager" as systemManager
    participant "System" as system
    
    activate systemManager
    systemManager -> system: get the Standard Categories Tree
    activate system
    system --> systemManager: present Tree
    deactivate system
    deactivate systemManager
    
 @endpuml
````

# 2. Analysis

In order to fulfill this requirement, we need one data piece:

- StandardCategory

For this sprint, the system manager only gets the standard categories tree from the application.

# 3. Design
In order to fullfill this requirement, the actor requests the system for a Tree view of the standard categories.
The application has in its construction several standard categories, that can have also branches and leaves. That is the "factory" state of the application will have categories that cannot be deleted or edited.
Outside the UI layer our actor requests a tree view of the standard categories and  

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
systemManager -> ui : request standard categories tree
activate ui
ui -> controller : getStandardCategoriesTree()
activate controller
controller -> app : getCategoryService()
activate app
activate service
app -> controller : CategoryService
deactivate app
controller -> service : getStandardCategories()
service -> service : createStandardCategoriesList()
activate category
loop for each Category in Categories List
service -> category : getStandardCategories()
alt true
category -> service : List<StandardCategory>
service -> app : standardCategoriesTree
deactivate service
deactivate category
end
end

app --> controller : standardCategoriesList
deactivate app
controller --> ui :StandardCategoriesTree
deactivate controller
ui --> systemManager : present standard categories tree
deactivate ui
deactivate systemManager
@enduml
````

## 3.1. Functionality Use

The GetStandardCatergoriesTreeController invokes the Application object, that has a Category Service object.
The Application returns the CategoryService that has all the Standard Categories.
The CategoryService creates a CategoryMap object. (....)

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
  + getStandardCategories()
  }

class CategoryService {
  - List<Category> categories
}

class Categories {
 +createStandardCategoriesList()
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

From a request the Category Service class creates a new CategoryMap object that holds each Category object parent category name (if exists) and its own category name.
With the above object it is possible to obtain a tree view representation of the categories in branch-leave style.

# 5. Integration/Demonstration

The design and development of this user story is important for the application transactions because client requirements want to have the possibility to analyse
monthly and annual spending per category and/or class of categories.
[US110](US110_GetCategoryTree.md) use an implementation of this user story.

# 6. Observations

In future User Stories we need to change something in order to group transactions per category and/or class(group) of categories.
Also the client requirements state "class of categories" as a group or a specific class and that may be only clarified by the product owner in future sprint reviews.





