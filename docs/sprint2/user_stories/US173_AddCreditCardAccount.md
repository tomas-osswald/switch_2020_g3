# US173 Add a credit card account

# 1. Requirements

## 1.1. Client Notes

As a family member, I want to add to a credit card account I have:

**Demonstration 1** As administrator, I want to...

- 1.1. Add a credit card account I have.

**Extracted from communications with the Product Owner**

- >*"A card does not have to be associated with a bank account."*;
- >*" "*;

We interpreted this requirement as the function of a family member to add a new credit card account to his account portfolio.

## 1.2. System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US173

actor "Family Member" as familyMember
participant ": System" as system

activate familyMember
familyMember-> system : add Credit Card Account
activate system
familyMember -> system : inputs required data

alt failure
system -> familyMember : Inform Failure

else sucess
system -> familyMember : Inform Sucess

end

deactivate system

deactivate familyMember
```

## 1.3. Dependencies from other User Stories

This user story is dependent on the following:

- US010_Add Family: to create a family;
- US011_Add Family Administrator: to add an Administrator, that he is allowed to add a Family Member;
- US101_Add Family Members: to add a Credit Card Account.

# 2. Analysis

For the fulfillment of the raised requirements, we analyze that for the accomplishment of the US we need, at this moment, the input of the family administrator of the following data:

- Self ID (User who wants to add a credit card account);
- Family ID (User's Family);
- Card description (Card Description);
- Withdrawal limit (Card usage limit).

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

class Account {

}

class CreditCardAccount{
- ID
- IBAN
- Limit
- Balance
- AssociatedBankAccount
}

Family -down-> FamilyMember : has Family members
FamilyMember -down-> Account  : has List of Accounts
CreditCardAccount -> Account : Is a
```

# 3. Design


## 3.1. Functionality Use

``` puml
autonumber 1
title addCreditCardAccount
actor "Actor" as actor
participant ": UI" as UI
participant ": AddCreditCardAccount\n Controller" as controller
participant ": Application" as app
participant "aAccountService : AccountService" as aserv
participant "aFamilyService : FamilyService" as fserv
participant "aFamily : Family" as family
participant "aCreditCardAccount : CreditCard Account" as credit
participant "aFamilyMember : FamilyMember" as familyMember

activate actor
actor -> UI
activate UI
UI -> controller

activate controller
controller -> app : getFamilyService()
activate app
app -> controller : aFamilyService
deactivate app

controller -> fserv : getFamily(familyID)
activate fserv
fserv -> controller : aFamily
deactivate fserv

controller -> family : getFamilyMember(familyMemberID)
activate family
family -> controller : aFamilyMember
deactivate family

app -> controller : getAccountService()
activate app
controller -> app : aAccountService
deactivate app

controller -> aserv : addCreditCardAccount(aFamilyMember)
activate aserv

aserv -> credit** : createCreditCardAccount(withdrawalLimit)

aserv -> familyMember : addAccountToList(aCreditCardAccount)
activate familyMember 
familyMember -> aserv : inform sucess
deactivate familyMember
aserv -> controller : inform sucess
deactivate aserv

controller -> UI : inform sucess
deactivate controller

UI -> actor : inform sucess
deactivate UI
deactivate actor
```

## 3.2. Class Diagram

```puml

title Class Diagram - US173

class AddCreditCardAcccountController {
}

class Application {
}

class AccountService {
+ addCreditCardAccount()
}

class FamilyService {
   }
   
class FamilyMember {
    + addAccount()
}

class Account {
}

class CreditCardAccount {
}

AddCreditCardAcccountController  -> Application
AddCreditCardAcccountController  -down-> AccountService
(AccountService, FamilyMember) -> CreditCardAccount : add credit card account to member
Application --> FamilyService : has
FamilyService --> FamilyMember : has
FamilyMember --> Account : has List<Account>
Account  <-- CreditCardAccount : Is a
```

## 3.3. Applied Patterns


## 3.4. Tests


## 4. Implementation


# 5. Integration/Demonstration


# 6. Observations

