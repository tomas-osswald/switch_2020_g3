# US173 Add a credit card account

# 1. Requirements

## 1.1. Client Notes

- As a family member, I want to register a payment that I have made using one of my cash accounts

We interpreted ...

**Extracted from communications with the Product Owner**

- >*" "*
- >*" "*

## 1.2. System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US181

actor "Family Member" as familyMember
participant ": System" as system

activate familyMember
familyMember-> system : register Payment on 1 of my Cash Accounts
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

This user story has a dependency with these **2** user stories:

- **[US010](US101_AddFamily.md)** *(As a system manager, I want to create a family.)*
    - In order to have a FamilyMember, the system needs to have that Family.
- **[US101](US101_AddFamilyMember.md)** *(As a family Administrator, I want to add a familyMember to a family)*
    - In order to create a Cash account, the system needs to have that Family Member.
- **[US170](US170_CreatePersonalCashAccount.md)** *(As a family member, I want to create a personal cash account)*
    - In order to register a payment in a Cash account, the system needs to have a Cash account.

# 2. Analysis

In order to fulfill this requirement, we need three main data pieces:
- Family Member ID;
- Cash Account Name;
- ... ;

##2.1. Domain Model Diagram

```puml
hide empty members
hide circle
title Domain Model Diagram US173

class Family {
- FamilyID
}

class FamilyMember {
- selfCC
}

class Account {

}

class Transaction {
- date
- ammount
- category
}

class CashTransaction {
- payer
- recipient
}

Family -down-> FamilyMember : has Family Members
FamilyMember -down-> Account  : has List of 
Account -> Transaction : has a List of
CashTransaction -down-> Transaction : is a
```

# 3. Design

The process to fulfill the requirement we need the input of data from a UI to create a CreditCardAccount object and add it to a specific FamilyMember(familyMemberID) in a given Family(familyID).
To create a valid CreditCardAccount object the constructor must acept an id, that is generated in AccountService.
A default Card Description is generated if has been inputed a invalid Card Description (null, empty or blank).

The controller will return:
- True, if a CreditCardAccount as been successfull created and assign.
- False, if catches on of the following throws ("Family don't exist", "Family Member don't exist") 

## 3.1. Functionality Use

````puml
@startuml
autonumber
title US181 - Register Payment In Cash Account Sequece Diagram

actor "FamilyMember" as actor
participant ": UI" as UI
participant ": addBankAccountController" as controller
participant ": FFM Application" as app
participant "famServ : FamilyService" as famService
participant "tranServ : TransactionService" as tranService
participant "aFamily : Family" as family
participant "aCashTran : CashTransaction" as cashTrans

activate actor
actor -> UI: registerPaymentInCashAccount(selfCC,accountID,paymentDate,ammount,category)
activate UI
UI -> controller: registerPaymentInCashAccount(selfCC,accountID,paymentDate,ammount,category)
activate controller
controller -> app: getCashAccount(selfCC,accountID)
activate app
app -> famService: getCashAccount(selfCC,accountID)
activate famService
famService -> family: getCashAccount(selfCC,accountID)
activate family
family -> famService: ok
deactivate family
famService -> app: ok
deactivate famService
app -> controller: ok
deactivate app
controller -> app: registerPaymentInCashAccount(selfCC,accountID,paymentDate,ammount,category)
activate app
app -> tranService: registerPaymentInCashAccount(selfCC,accountID,paymentDate,ammount,category)
activate tranService
tranService -> tranService: checkIfBalanceIsEnough()
alt Balance is not enough - FALSE
  tranService -> tranService: fail
else Balance is enough - TRUE
  tranService -> cashTrans **: createCashTransaction(selfCC,accountID,paymentDate,ammount,category)
  tranService -> tranService: addTransaction(aCashTransaction)
end
tranService -> app: ok
deactivate tranService
app -> controller: ok
deactivate app
controller -> UI: ok
deactivate controller
UI -> actor: succeed
deactivate UI
deactivate actor

@enduml
````

## 3.2. Class Diagram

```puml

title Class Diagram - US181

class RegisterPaymentInCashAccount {
}

class Application {
}

class TransactionService {
checkIfBalanceIsEnough()
}

class FamilyService {
}
   
class FamilyMember {
}

class Account{
setBalance()
}

class Transaction {
}

class CashTransaction {
}

RegisterPaymentInCashAccount  -> Application
RegisterPaymentInCashAccount  -down-> FamilyService
RegisterPaymentInCashAccount  -down-> TransactionService
TransactionService -down-> CashTransaction : create a
FamilyService --> FamilyMember : has List<FamilyMember>
FamilyMember --> Account : has List<Account>
Account -left-> Transaction : has List<Transaction>
CashTransaction -down-> Transaction : is a
```

## 3.3. Applied Patterns
We applied the principles of Controller, Information Expert, Creator e PureFabrication from the GRASP pattern.
We also used the SOLID SRP principle.

## 3.4. Tests


# 4. Implementation


# 5. Integration/Demonstration


# 6. Observations

