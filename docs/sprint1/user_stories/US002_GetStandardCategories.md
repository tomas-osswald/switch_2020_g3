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
service -> category : checkIfIsStandard()
alt true
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
Category Service has the responsibility of managing the categories list.

## 3.2. Class Diagram

The main Classes involved are:

- CategoriesController
- FFMApplication
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

## 3.4. Tests



# 4. Implementation

To get the Standard Categories List we design and implement a method that iterates over the elements of the general list of categories.





*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integration/Demonstration

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as
restantes funcionalidades do sistema.*

# 6. Observations

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por
exemplo, outras alternativas e ou trabalhos futuros relacionados.*




