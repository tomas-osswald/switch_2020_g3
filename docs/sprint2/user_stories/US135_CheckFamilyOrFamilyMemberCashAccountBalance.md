# US173 Add a credit card account

# 1. Requirements

## 1.1. Client Notes

As a family administrator, I want to add to a credit card account I have:

**Demonstration 1** As administrator, I want to...

- 1.1. Check Family Cash Account;
- 1.2. Check a Family Member Cash Account.

**Extracted from communications with the Product Owner**

- >*" "*;
- >*" "*;

We interpreted this requirement as the function of a family administrator wants to check Family or a Family Member Cash Account.

## 1.2. System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US135

actor "Family Member" as familyMember
participant ": System" as system

activate familyMember
familyMember-> system : check balance of Family or Family Member Cash Account
activate system
familyMember -> system : chooses Family or Family Member
familyMember -> system : inputs required data
alt failure
system -> familyMember : Inform Failure

else sucess
system -> familyMember : Balance

end

deactivate system

deactivate familyMember
```

## 1.3. Dependencies from other User Stories

This user story is dependent on the following:

- US010_Add Family: to create a family;
- US011_Add Family Administrator: to add an Administrator, that he is allowed to add a Family Member;
- US101_Add Family Members: to add a Cash Account;
- US120_Create Family Cash Account: to create a Family Cash Account;
- US170_Create Personal Cash Account: to create a Personal Cash Account.

# 2. Analysis

For the fulfillment of the raised requirements, we analyze that for the accomplishment of the US we need, at this moment, the input of the family administrator of the following data:

    * For check Family Cash Account:
        - Self ID (Administrator ID);
        - Family ID (User's Family).
        
    * For check Family Member Cash Account:
        - Self ID (Administrator ID);
        - Other ID (Other Family Memeber ID);
        - Account ID (Cash Account ID);
        - Family ID (User's Family).

##2.1. Domain Model Diagram

```puml
hide empty members
hide circle
title Domain Model Diagram US173

class Family {
- Name
- UniqueID
- RegistrationDate

}

class FamilyMember {
- Name
- BirthDate
}

class CashAccount {
- balance
- description
}

Family -down-> FamilyMember : has Family members
FamilyMember -down-> CashAccount  : has
Family -> CashAccount : has
```

# 3. Design


## 3.1. Functionality Use

**checkCashAccountBalance( ).1**
``` puml
autonumber 1
title checkFamilyOrFamilyMemberCashAccountBalance( )
actor "Actor" as actor
participant ": UI" as UI

activate actor
actor -> UI : check Family or Family Member Cash Account
activate UI
UI -> actor : ask: choose Family or Family Member
deactivate UI

ref over actor : Check Family Cash Account \n - checkCashAccountBalance( ).2

ref over actor : Check Family Member Cash Account\n - checkCashAccountBalance( ).3
```
**checkCashAccountBalance( ).2**
```puml
autonumber 1
title checkFamilyCashAccountBalance( )
actor "Actor" as actor
participant ": UI" as UI
participant ": CheckCashAccountBalance\n Controller" as controller
participant ": Application" as app
participant "aAccountService : AccountService" as aserv
participant "aFamilyService : FamilyService" as fserv
participant "aFamily : Family" as family
participant "aCashAccount : CashAccount" as cash

activate actor
actor -> UI : check Family
activate UI
UI -> actor : ask: selfID, familyId
deactivate UI

actor -> UI : inputs required data
activate UI
UI -> controller : checkFamilyCashAccountBalance(selfID, familyID)

activate controller
controller -> app : getFamilyService()
activate app
app -> controller : aFamilyService
deactivate app

controller -> fserv : verifyAdministratorPermission(selfID, familyID)
activate fserv
fserv -> controller : inform success
deactivate fserv

controller -> fserv : getFamily(familyID)
activate fserv
fserv -> controller : aFamily
deactivate fserv

controller -> app : getAccountService()
activate app
controller <- app : aAccountService
deactivate app

controller -> aserv : getFamilyCashAccountBalance(aFamily)
activate aserv

aserv -> family : getFamilyCashAccountBalance( )
activate family

family -> cash : getBalance( )
activate cash
cash -> family : balance
deactivate cash

family -> aserv : balance
deactivate family
aserv -> controller : balance
deactivate aserv

controller -> UI : balance
deactivate controller

UI -> actor : balance
deactivate UI
deactivate actor
```
**checkCashAccountBalance( ).3**
```puml
autonumber 1
title checkFamilyMemberCashAccountBalance( )
actor "Actor" as actor
participant ": UI" as UI
participant ": CheckCashAccountBalance\n Controller" as controller
participant ": Application" as app
participant "aAccountService : AccountService" as aserv
participant "aFamilyService : FamilyService" as fserv
participant "aFamily : Family" as family
participant "aFamilyMember : FamilyMember" as familyMember
participant "aCashAccount : CashAccount" as cash

activate actor
actor -> UI : check Family Member
activate UI
UI -> actor : ask: selfID, otherID, familyId
deactivate UI

ref over actor : List of Cash Account of a Family Member\n - checkCashAccountBalance( ).4

actor -> UI : inputs required data
activate UI
UI -> controller : checkFamilyMemberCashAccountBalance(selfID, otherID, accountID, familyID)

activate controller
controller -> app : getFamilyService()
activate app
app -> controller : aFamilyService
deactivate app

controller -> fserv : verifyAdministratorPermission(selfID, familyID)
activate fserv
fserv -> controller : inform success
deactivate fserv

controller -> fserv : getFamily(familyID)
activate fserv
fserv -> controller : aFamily
deactivate fserv

controller -> family : getFamilyMember(otherID)
activate family
family -> controller : aFamilyMember
deactivate family

controller -> app : getAccountService()
activate app
controller <- app : aAccountService
deactivate app

controller -> aserv : getFamilyMemberCashAccountBalance(aFamilyMember, accountID)
activate aserv
aserv -> familyMember : getAccount(accountID)
activate familyMember
familyMember -> aserv : aCashAccount
deactivate familyMember

aserv -> cash : getBalance( )
activate cash
cash -> aserv : balance
deactivate cash

aserv -> controller : balance
deactivate aserv

controller -> UI : balance
deactivate controller

UI -> actor : balance
deactivate UI
deactivate actor
```

**checkCashAccountBalance( ).4**
```puml
autonumber 1
title getListOfCashAccountsOfAFamilyMember( )
actor "Actor" as actor
participant ": UI" as UI
participant ": CheckCashAccountBalance\n Controller" as controller
participant ": Application" as app
participant "aAccountService : AccountService" as aserv
participant "aFamilyService : FamilyService" as fserv
participant "aFamily : Family" as family
participant "aFamilyMember : FamilyMember" as familyMember

activate actor
actor -> UI : inputs required data
activate UI
UI -> controller : getListOfCashAccountsOfAFamilyMember(selfID, otherID, familyID)

activate controller
controller -> app : getFamilyService()
activate app
app -> controller : aFamilyService
deactivate app

controller -> fserv : verifyAdministratorPermission(selfID, familyID)
activate fserv
fserv -> controller : inform success
deactivate fserv

controller -> fserv : getFamily(familyID)
activate fserv
fserv -> controller : aFamily
deactivate fserv

controller -> family : getFamilyMember(otherID)
activate family
family -> controller : aFamilyMember
deactivate family

controller -> app : getAccountService()
activate app
controller <- app : aAccountService
deactivate app

controller -> aserv : getListOfCashAccountsOfAFamilyMember(aFamilyMember)
activate aserv
aserv -> familyMember : getListOfCashAccountsOfAFamilyMember( )

activate familyMember


familyMember -> aserv : listOfCashAccounts
deactivate familyMember
deactivate familyMember
aserv -> controller : listOfCashAccounts
deactivate aserv

controller -> UI : listOfCashAccounts
deactivate controller

UI -> actor : listOfCashAccounts
deactivate UI
deactivate actor
```

## 3.2. Class Diagram


## 3.3. Applied Patterns


## 3.4. Tests


## 4. Implementation


# 5. Integration/Demonstration


# 6. Observations

