# US010 Add a Family
=======================================


# 1. Requirements

*As a family member, I want to add an email account to my profile*


**Demo1** As a family member, I want to add...

- Demo1.1. The new email familymember@gmail.com

- Demo1.2. The already existing email familymember@gmail.com

We interpreted this requirment as the function of a user to add an email account to his profile information. The email account must not previously exist on his profile, and it must be a valid email format.

# 2. Analysis

# 3. Design

````puml
@startuml
autonumber
title createFamily
actor "System Manager" as systemManager
participant ": UI" as UI
participant ": CreateFamilyController" as controller
participant ": FFMApplication" as application
participant ": FamilyService" as famServ
participant "newFamily : Family" as family

activate systemManager
systemManager -> UI: create a new Family
activate UI
UI --> systemManager: ask new family name
deactivate UI
systemManager -> UI: input family name
activate UI
UI -> controller: createFamily(name)
activate controller
controller -> application: getFamilyService()
activate application
application --> controller: familyService
deactivate application
controller -> famServ: createFamily(name)
activate famServ
famServ -> famServ: doesFamilyAlreadyExist(name)

alt family already present
famServ --> controller: failed
controller --> UI: failed
UI --> systemManager: inform failure

else family not present
famServ -> family**: create(name)
famServ -> famServ: addFamily(newFamily)
famServ --> controller: ok
deactivate famServ
controller --> UI: ok
deactivate controller
UI --> systemManager: inform success
deactivate UI

end
@enduml
````