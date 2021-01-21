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

