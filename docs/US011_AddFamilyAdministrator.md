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