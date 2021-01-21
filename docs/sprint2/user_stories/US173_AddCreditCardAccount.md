# US173 Add a credit card account

# 1. Requirements

As a family member, I want to add a credit card account I have

## 1.1. Client Notes

We interpreted this requirement as the function of a family member to add a new credit card account to his account portfolio. It must have a cash account associated to it.

## 1.2. System Sequence Diagram


## 1.3. Dependencies from other User Stories


# 2. Analysis


##2.1. Domain Model Diagram



# 3. Design


## 3.1. Functionality Use

### Sequence diagram

``` puml
autonumber 1
title addCreditCardAccount
actor "Actor" as actor
participant ": UI" as UI
participant ": AddCreditCardAccount\n Controller" as controller
participant ": Application" as app
participant ": AccountService : AccountService" as aserv
participant ": FamilyService : FamilyService" as fserv
participant "aFamily : Family" as family
participant "aFamilyMember : FamilyMember" as familyMember
participant "aCreditCardAccount : CreditCard Account" as credit
actor -> UI
UI -> controller
controller -> app
app -> controller
controller -> app
app -> controller
controller -> aserv
aserv -> fserv : getFamilyMemberByIDAndFamilyID()
fserv -> aserv : aFamilyMember
aserv -> familyMember : addCreditCardAccount()
familyMember -> familyMember : getBankAccountByID()
familyMember -> credit** : 
credit -> IBAN**
familyMember -> familyMember : addAccountToList(aCreditCardAccount)
familyMember -> aserv : Ok
aserv -> controller : OK
controller -> UI : OK
UI -> actor : OK
```


## 3.2. Class Diagram
```puml

title Class Diagram - US173

class Application {
  - AccountService accountService
  + getAccountService()
}

class AccountService {
   + addCreditCardAccount()
}

class FamilyService {
   }
   
class FamilyMember {
    + AddCreditCardAccount()
}

class Account {
}

class CreditCardAccount {
}

Application --> AccountService : has
AccountService --> FamilyService : has
FamilyService --> FamilyMember : has
FamilyMember --> Account : has List<Account>
Account  <-- CreditCardAccount : Is a
```


## 3.3. Applied Patterns


## 3.4. Tests


# 5. Integration/Demonstration


# 6. Observations

