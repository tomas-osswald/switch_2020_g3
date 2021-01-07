# US001 Create a Standard Category
=======================================


# 1. Requirements

*As a system manager, I want to create a new Standard Category*





**Demo1** As a family member, I want to add...

- Demo1.1. The new email familymember@gmail.com

- Demo1.2. The already existing email familymember@gmail.com

We interpreted this requirement as the function of a user to add an email account to his profile information. 
The email account must not previously exist on his profile, and it must be a valid email format.

# 2. Analysis

# 3. Design
```` puml

   autonumber
   title createStandardCategory
   actor "System Manager" as systemManager
   participant ": UI" as UI
   participant ": CreateStandardCategoryController" as controller
   participant ": FFMApplication" as application
   participant "categoryService : CategoryService" as catServ
   participant "newCategory : Category" as category
   
   activate systemManager
   systemManager -> UI: create a Standard Category
   activate UI
   UI --> systemManager: ask new category name
   deactivate UI
   systemManager -> UI: input category name
   activate UI
   UI -> controller: createStandardCategory(name)
   activate controller
   controller -> application: getCategoryService()
   activate application
   application --> controller: categoryService
   deactivate application
   controller -> catServ: createStandardCategory(name)
   activate catServ
   catServ -> catServ: doesCategoryAlreadyExist(name)
   
   alt category already present
   catServ --> controller: failed
   controller --> UI: failed
   UI --> systemManager: inform failure
   
   else category not present
   catServ -> category **: create(name)
   catServ -> application: addCategory(newCategory)
   catServ --> controller: ok
   deactivate catServ
   controller --> UI: ok
   deactivate controller
   UI --> systemManager: inform success
   deactivate UI
   
   end

@endpuml
´´´´