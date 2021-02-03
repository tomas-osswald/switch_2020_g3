# US130 Transfer Money from Family Cash Account To a Personal Cash Account
==========================================================================


# 1. Requirements

*As a family administrator, I want to transfer money from the family cash account to another family's member cash account*


**1** As a family administrator, I want to transfer money from the family cash account to...

- 1.1. The already existing cash account of a family member;

- 1.2. A new cash account of a family member;

We interpreted this requirement as a function for the family administrator to transfer money from the family cash account
to the cash account of any family member.

## System Sequence Diagram

````puml
autonumber
title System Sequence Diagram - US130

Actor "FamilyAdmin" as Actor
Participant "System" as System

activate Actor
Actor -> System : Transfer Money \nto Family Member
activate System
System --> Actor : ask for required data
Actor -> System : required data
System --> Actor : inform success
deactivate System
````

# 2. Analysis

In order to fulfill this requirement we need information from the family administrator. Those are:

1. FamilyID - the identifier of the current family
2. FamilyMemberCC - the CCNumber used to identify the family member that will receive the transaction
3. AccountID - the identifier of the cash account
4. TransferAmount and its Currency - the amount to be transferred, and the currency type of the transaction
5. CategoryID - the identifier of the category for the transaction
6. TransactionDesignation - a designation for the transaction
7. TransactionDate - the date of the transaction, if the information is not given the current system date will be used

If the family member doesn't have a cash account a new cash account will be created
The money transfer must be a positive value and of the same currency as the family and destination cash account.
The money transfer will only occur if the family has a cash account and if that cash account has enough money for the transaction.

# 3. Design

````puml
@startuml
title US130 - Transfer Money from Family Cash Account To a Personal Cash Account - SequenceDiagram
autonumber

Actor "FamilyAdmin" as Actor
Participant "UI" as UI
Participant ": TransferCashFromFamilyAccount\nToPersonalAccountController" as controller
Participant ": Application" as App
Participant ": FamilyService" as FamilyService
Participant "aFamily\n : Family" as Family
Participant ": CategoryService" as CategoryService
Participant ": AccountService" as AccountService


Actor -> UI : Transfer Money \nto Family Member
activate UI
UI --> Actor : ask for required data
deactivate UI

Actor -> UI : input required data
activate UI
UI -> controller : transferCashFrom\nFamilyToFamilyMember\n(FamilyCashTransferDTO)
activate controller
controller -> App : getFamilyService()
activate App
App --> controller : FamilyService
deactivate App

controller -> FamilyService : getFamily(familyID)
activate FamilyService
FamilyService --> controller : aFamily
deactivate FamilyService

controller -> Family : getFamilyMember(familyMemberCC)
activate Family
Family --> controller : aFamilyMember
deactivate Family

alt StandardCategory
controller -> App : getCategoryService()
activate App
App --> controller : CategoryService
deactivate App
controller -> CategoryService : getStandardCategoryByID(categoryID)
activate CategoryService
CategoryService --> controller : aCategory
deactivate CategoryService

else CustomCategory

controller -> Family : getCustomCategoryByID(categoryID)
activate Family
Family --> controller : aCategory
deactivate Family

end

controller -> App : getAccountService()
activate App
App --> controller : AccountService
deactivate App

controller -> AccountService : transferCashFromFamilyToFamilyMember\n(aFamily, aFamilyMember, familyCashTransferDTO)
activate AccountService

ref over AccountService

Transfer Cash From 
Family To Family Member

end ref

AccountService --> controller : success
deactivate AccountService

controller -> AccountService : getAccount(familyMember,AccountID)
activate AccountService
AccountService --> controller : personalCashAccount
controller -> AccountService : getFamilyCashAccount(family)
AccountService --> controller : familyCashAccount
deactivate AccountService

controller -> App : getTransactionService()
activate App
App --> controller : TransactionService
deactivate App

controller -> TransactionService : registerCashTransfer\n(familyCashAccount, personalCashAccount, familyCashTransferDTO)
activate TransactionService

ref over TransactionService

Register Cash Transfer

end ref

TransactionService --> controller : success
deactivate TransactionService

controller --> UI : success
deactivate controller

UI --> Actor : inform success
deactivate UI

@enduml

````

````puml
title Transfer Cash From Family To Family Member
autonumber

Participant ": AccountService" as AccountService
Participant "aFamily\n : Family" as Family
Participant "transferAmount\n : MoneyValue" as transferMoneyValue
Participant "familyCashAccount\n : CashAccount" as familyCashAccount
Participant "aFamilyMember\n : FamilyMember" as FamilyMember
Participant "personalCashAccount\n : CashAccount" as personalCashAccount


-> AccountService : transferCashFromFamilyToFamilyMember\n(aFamily, aFamilyMember,\n familyCashTransferDTO)
activate AccountService

AccountService -> Family : getFamilyCashAccount()
activate Family
Family --> AccountService : familyCashAccount
deactivate Family

AccountService -> transferMoneyValue ** : create(transferValue, currency)

AccountService -> familyCashAccount : hasEnoughMoneyForTransaction(transferAmount)
activate familyCashAccount

opt not enough money for transaction
familyCashAccount --> AccountService : false
<-- AccountService : failure

else enough money for transaction
familyCashAccount --> AccountService : true
deactivate familyCashAccount
end

AccountService -> familyCashAccount : checkCurrency(currency)
activate familyCashAccount

opt different currency
familyCashAccount --> AccountService : false
<-- AccountService : failure

else same currency
familyCashAccount --> AccountService : true
deactivate familyCashAccount
end opt

AccountService -> FamilyMember : getAccount(personalAccountID)
activate FamilyMember
FamilyMember --> AccountService : personalCashAccount
deactivate FamilyMember

opt if (personalCashAccount == null)
AccountService -> personalCashAccount ** : create
end

AccountService -> personalCashAccount : checkCurrency(currency)
activate personalCashAccount

opt different currency
personalCashAccount --> AccountService : false
<-- AccountService : failure
deactivate personalCashAccount
end


AccountService -> familyCashAccount : debit(transferAmount)

AccountService -> personalCashAccount : credit(transferAmount)
<-- AccountService : success
deactivate AccountService

````

````puml
autonumber
title Register Cash Transfer

Participant ": TransactionService" as TransactionService
Participant "familyCashAccount\n : CashAccount" as familyCashAccount
Participant "personalCashAccount\n : CashAccount" as personalCashAccount

-> TransactionService : registerCashTransfer\n(familyCashAccount, personalCashAccount, familyCashTransferDTO)
activate TransactionService

TransactionService -> familyCashAccount : getMoneyBalance()
activate familyCashAccount
familyCashAccount --> TransactionService : remainingBalanceOrigin
deactivate familyCashAccount

TransactionService -> familyCashAccount : registerTransaction(personalCashAccount, category,\n isCredit, remainingBalanceOrigin, familyCashTransferDTO)
activate familyCashAccount
familyCashAccount --> TransactionService : true
deactivate familyCashAccount

TransactionService -> personalCashAccount : getMoneyBalance()
activate personalCashAccount
personalCashAccount --> TransactionService : remainingBalanceDestination
deactivate personalCashAccount

TransactionService -> personalCashAccount : registerTransaction(familyCashAccount, category, isCredit,\n remainingBalanceDestination, familyCashTransferDTO)
activate personalCashAccount
personalCashAccount --> TransactionService : true
deactivate personalCashAccount

<-- TransactionService : success
deactivate TransactionService

````


# 4. Implementation

In order to implement this user story we had several steps that required some extra attention in particular the large number of verifications that had to be performed before the transfer was allowed.
This requirement was verified by creating unitary tests for the conditions where the transfer should not occur. The data involved in the transfer was also recorded in the form of a Transaction allowing other US to interact with that data.

# 5. Integration
 
This user story depends on the US170 - CreatePersonalCashAccount as it uses the Cash Account class created during that user story. It also interacts with elements developed in the US185 - GetAccountBalance and with US186 - GetListOfMovementsBetweenTwoDates.
It also relates to the US001, US010, US101 and US120 from previous sprints.

#6. Observations

Although this user story had an increased complexity in regard to its interaction with other parts of the system we believe we achieved a working solution.
The challenges presented, also allowed us to check the integrity of the other parts of our system and to try to improve upon them.