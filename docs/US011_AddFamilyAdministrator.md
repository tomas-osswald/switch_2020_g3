# US151 Add family administrator
=======================================


# 1. Requirements

## 1.1. Client Notes

As a system manager, I want to add a family administrator:

**Demonstratim 1** As a system manager, I want to add...

- 1.1. A new administrator.

The interpretation made of this requirement is that the system administrator can add a new administrator to a family.

## 1.2 System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US011

actor "System Manager" as manager
participant ": System" as system

activate manager
manager -> system : add relation to member
activate system
manager -> system : choose family with no administrator
manager -> system : inputs required data

alt failure
system -> manager : Inform Failure

else sucess
system -> manager : Inform Sucess

end

deactivate system

deactivate manager
```

# 2. Analysis

For the fulfillment of the raised requirements, we analyze that for the accomplishment of the US we need, at this moment, the impute of the system administrator of the following data:

- The Family he wants to add an administrator;
- And the data necessary to create a new administrator (id, name, vatNumber, address, birthDate, phoneNumber and emailAddress).

From analysis done to requirements gathering, a new administrator will be created to a family that has no administrator.

# 3. Design

The main process to fulfill this requirement would require the actor to select they want to add an email in the UI, which would then prompt the input of the email adress. In lieu of not having an UI, the Int *FamilyMemberID* and String *emailAdress* will be directly inputed into the AddEmailController. 
````puml
@startuml
autonumber
title createStandardCategory
actor "System Manager" as systemManager
participant ": UI" as UI
participant ": CreateStandardCategoryController" as controller
participant ": FFMApplication" as application
participant ": familyService" as famServ
participant "aFamily : Family" as family
participant "newFamilyMember : FamilyMember" as familyMember
participant "aVATNumber : VATNumber" as vatNumber
participant "anAddress : Address" as address
participant "aPhoneNumber : PhoneNumber" as phoneNumber
participant "anEmail : Email" as email

activate systemManager
systemManager -> UI: add a family administrator
activate UI
UI -> controller: getFamiliesWithoutAdministrator()
activate controller
controller -> application: getFamilyService()
activate application
application --> controller: FamilyService
deactivate application
controller -> famServ: getFamiliesWithoutAdministrator()
activate famServ
famServ --> controller: listOfFamilies
deactivate famServ
controller --> UI: listOfFamilies
deactivate controller
UI --> systemManager: show list of families without an administrator and ask to select one
deactivate UI

systemManager -> UI: select chosen family
activate UI
UI --> systemManager: ask family administrator's data (id, name, vatNumber, address, birthDate, phoneNumber, emailAddress)
deactivate UI

systemManager -> UI: input data
activate UI
UI -> controller: addFamilyAdministrator(id, name, vatNumber, address, birthDate, phoneNumber, emailAddress, familyID)
activate controller
controller -> application: getFamilyService()
activate application
application --> controller: FamilyService
deactivate application
controller -> famServ: addFamilyAdministrator(id, name, vatNumber, address, birthDate, phoneNumber, emailAddress, familyID)
activate famServ

famServ -> famServ: doesEmailAlreadyExist(email)

alt email already exists
famServ --> controller: failed
controller --> UI: failed
UI --> systemManager: inform failure

else else

famServ -> famServ: aFamily = getFamilyByID(familyID)

famServ -> familyMember**: create(id, name, vatNumber, address, birthDate, phoneNumber, emailAddress)
activate familyMember
familyMember -> vat**: create(vatNumber)
familyMember -> address**: create(address)
familyMember -> phoneNumber**: create(phoneNumber)
familyMember -> email**: create(email)
deactivate familyMember

famServ -> family: addFamilyAdministrator(newFamilyMember)
activate family
family --> application: ok
deactivate family
famServ --> controller: ok
deactivate famServ
controller --> UI: ok
deactivate controller
UI --> systemManager: inform success
deactivate UI

end
@enduml