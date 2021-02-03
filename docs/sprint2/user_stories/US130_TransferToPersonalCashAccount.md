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

controller -> AccountService : transferCashFromFamilyToFamilyMember\n(aFamily, aFamilyMember, category, familyCashTransferDTO)
activate AccountService

ref over AccountService

Transfer Cash From 
Family To Family Member

end ref

AccountService --> controller : success
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


-> AccountService : transferCashFromFamilyToFamilyMember\n(aFamily, aFamilyMember, category,\n familyCashTransferDTO)
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
personalCashAccount --> TransactionService : remainingBalanceDestination
deactivate personalCashAccount

<-- TransactionService : success
deactivate TransactionService

````