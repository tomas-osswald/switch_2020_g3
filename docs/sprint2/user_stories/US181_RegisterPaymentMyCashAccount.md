# US181 Add a credit card account

# 1. Requirements

## 1.1. Client Notes

- As a family member, I want to register a payment that I have made using one of my cash accounts.

We interpreted this requirement as the function of a familyMember to register a payment in one of his CashAccounts and generating a transaction.



## 1.2. System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US181

actor "Family Member" as familyMember
participant ": System" as system

activate familyMember
familyMember-> system : register Payment on 1 of my Cash Accounts
activate system
system -> familyMember : asks required data
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

This user story has a dependency with these **3** user stories:

- **[US010](US101_AddFamily.md)** *(As a system manager, I want to create a family.)*
    - In order to have a FamilyMember, the system needs to have that Family.
  
- **[US101](US101_AddFamilyMember.md)** *(As a family Administrator, I want to add a familyMember to a family)*
    - In order to create a Cash account, the system needs to have that Family Member.
  
- **[US170](US170_CreatePersonalCashAccount.md)** *(As a family member, I want to create a personal cash account)*
    - In order to register a payment in a Cash account, the system needs to have a Cash account.

# 2. Analysis

In order to fulfill this requirement, we need 6 main data pieces that need to be inserted by the User:
- accountID
- Amount  
- currency
- categoryID 
- Designation
- transactionDate

While these 2 data pieces are already given by the app.
- familyID
- familyMemberCC


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
- AccountID 
- AccountType
}

class Transaction {
- transactionDate
- ammount
- category
- designation
- remainingBalance
- currency
}

class CashTransaction {
- recipient
}

Family -down-> FamilyMember : has Family Members
FamilyMember -down-> Account  : has List of 
Account -> Transaction : has a List of
CashTransaction -down-> Transaction : is a
```

# 3. Design

````puml
@startuml
autonumber
title US181 - Register Payment In Cash Account Sequece Diagram

actor "FamilyMember" as actor
participant ": UI" as UI
participant ": addBankAccountController" as controller
participant ": FFM Application" as app
participant "famServ : FamilyService" as famService
participant "accServ : AccountService" as accService
participant "tranServ : TransactionService" as tranService
participant "aFamilyMember : FamilyMember" as familyMember
participant "aCashTran : CashTransaction" as cashTrans

activate actor
actor -> UI: registerPaymentInCashAccount(familyID,selfCC,accountID,paymentDate,ammount,categoryID)
activate UI
UI -> controller: registerPaymentInCashAccount(transactionDTO)
activate controller
controller -> app: getCashAccount(familyID,selfCC,accountID)
activate app
app -> famService: getCashAccount(familyID,selfCC,accountID)
activate famService
famService -> familyMember: getCashAccount(familyID,selfCC,accountID)
activate familyMember
familyMember -> famService: ok
deactivate familyMember
famService -> app: ok
deactivate famService
app -> controller: ok
deactivate app

controller -> app : verifyCashAccount(Account)
activate app
app -> accService : verifyCashAccount(Account)
activate accService
accService -> accService : verifyAccountType(Account,CashAccount)
alt Account is not CashAccount - FALSE
  accService -> app : fail
  app -> controller : fail
else Account is a CashAccount - TRUE
  accService -> app : ok
  deactivate accService
  app -> controller : ok
  deactivate app
end

controller -> app: registerPaymentInCashAccount(cashAccount,category,transactionDTO)
activate app
app -> tranService: registerPaymentInCashAccount(cashAccount,category,transactionDTO)
activate tranService
tranService -> tranService: checkIfBalanceIsEnough()
alt Balance is not enough - FALSE
  tranService -> tranService: fail
else Balance is enough - TRUE
  tranService -> cashTrans **: createCashTransaction(cashAccount,category,transactionDTO)
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

## 3.1. Functionality Use

In order to register a payment the user will have to input data in the UI to create a transaction object and store it in the his Account.
With the FamilyID and FamilyMemberID provided by the UI, the User will be able to select one of his CashAccounts for the transaction be stored. 
When the required data is introduced, the App verifies if the CashAccount has enough balance, and the amount is positive to meet the criteria for a transaction be created.
If any data introduced has a wrong format, the App warns about the problem.

The controller will return:
- True, if the payment registration has been successfully created.
- False, if catches on of the following throws ("Not enough balance", "Insert a positive value")


## 3.2. Class Diagram

```puml

title Class Diagram - US181

class RegisterPaymentInCashAccount {
- getFamilyService
- getTransactionService
- registerPaymentMyCashAccount    // ACRESCENTAR accountService
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

