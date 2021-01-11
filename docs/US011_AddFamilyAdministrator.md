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

activate system
manager -> system : choose family with no administrator
manager -> system : input required data

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

## 3.1 Functionality Use

**addFamilyAdministrator( ).1**
```puml

autonumber
title addFamilyAdministrator( ).1
actor "System Manager" as systemManager
participant ": UI" as UI
participant ": AddFamilyAdministratorController" as controller

activate systemManager
systemManager -> UI: add a family administrator
activate UI
UI -> controller: getFamiliesWithoutAdministrator()
activate controller

ref over controller
addFamilyAdministrator( ).2
end ref

autonumber 7
controller --> UI: listOfFamilies
deactivate controller
UI --> systemManager: show list of families without an administrator and ask to select one
deactivate UI

systemManager -> UI: select chosen family
activate UI
UI --> systemManager: ask family administrator's data (id, name, vatNumber, address, \nbirthDate, phoneNumber, emailAddress)
deactivate UI

systemManager -> UI: input data
activate UI
UI -> controller: addFamilyAdministrator(id, name, vatNumber, address, \nbirthDate, phoneNumber, emailAddress, familyID)
activate controller

ref over controller : addFamilyAdministrator( ).3

autonumber 26
alt 
controller --> UI: inform failure
UI --> systemManager: inform failure

else 

autonumber 26
controller --> UI: inform sucess
deactivate controller
UI --> systemManager: inform success
deactivate UI

end

```

**addFamilyAdministrator( ).2**
```puml
autonumber 2
title addFamilyAdministrator( ).2

participant ": AddFamilyAdministratorController" as controller
participant ": App" as app
participant "familyService : FamilyService" as familyService

-> controller : getFamiliesWithoutAdministrator
activate controller
controller -> app : getFamilyService( )
activate app
app -> controller : familyService
deactivate app
controller -> familyService: getFamiliesWithoutAdministrator( )
activate familyService
familyService -> controller: listOfFamilies
deactivate familyService
<- controller : ListOfFamilies
deactivate controller 
```

**addFamilyAdministrator( ).3**
```puml
autonumber 12
title addFamilyAdministrator( ).3

participant ": AddFamilyAdministratorController" as controller
participant ": App" as app
participant "familyService : FamilyService" as familyService
participant "aFamily : Family" as family

-> controller : addFamilyAdministrator(id, name, \nvatNumber, address, birthDate, phoneNumber, \nemailAddress, familyID, administrator)
activate controller
controller -> app: getFamilyService()
activate app
app --> controller: FamilyService
deactivate app
controller -> familyService: addFamilyAdministrator(id, name, vatNumber, address, \nbirthDate, phoneNumber, emailAddress, familyID, administrator)
activate familyService

familyService -> familyService: aFamily = getFamily(familyID)

familyService -> family : addFamilyAdministrator(id, name, vatNumber, address, \nbirthDate, phoneNumber, emailAddress, administrator)
activate family

ref over family : addFamilyAdministrator( ).4

autonumber 24
family -> familyService : inform sucess
deactivate family

familyService -> controller : inform sucess
deactivate familyService

<- controller : inform sucess
deactivate controller

```

**addFamilyAdministrator( ).4**
```puml
autonumber 17
title addFamilyAdministrator( ).4

participant "aFamily : Family" as family
participant "familyAdministrator \n: FamilyMember" as administrator
participant "aVATNumber \n: VATNumber" as vatNumber
participant "anAddress \n: Address" as address
participant "aPhoneNumber \n: PhoneNumber" as phoneNumber
participant "anEmail : Email" as email

-> family : addFamilyAdministrator(id, name, \nvatNumber, address, birthDate, phoneNumber, \nemailAddress, administrator)
activate family

activate administrator
family -> administrator**
administrator -> vatNumber**
administrator -> address**
administrator -> phoneNumber**
administrator -> email**
deactivate administrator

family -> family : addFamilyMember\n(familyAdministrator)

<- family : inform sucess
deactivate family

```