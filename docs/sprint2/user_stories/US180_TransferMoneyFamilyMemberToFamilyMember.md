# US180 transfer money from my cash account to another family member’s cash account

# 1. Requirements

## 1.1. Client Notes

As a family member, I want to add to transfer money from my cash account to another family member’s cash account:

**Demonstration 1** As a family member, I want to...

- 1.1. transfer money from my cash account to another family member’s cash account:
 
**Extracted from communications with the Product Owner**

- >*"lorem ipsum"*;
- >*" "*;

We interpreted this requirement as the function of a family member to transfer money from his cash account to another family member’s cash account.

## 1.2. System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US180

actor "Family Member" as familyMember
participant ": System" as system

activate familyMember
familyMember-> system : transfer money
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
- US101_Add Family Members: to add a Personal Cash Account
- US170_Create Family Member Cash Account: to create a cash account from where money will be transferred or received.  
- US120_Create Family Cash Account: to create a cash account to transfer money to family members in the first time. Only family cash account can transfer money to the family members after the creation of the family member´s personal cash account.

# 2. Analysis

For the fulfillment of the raised requirements, we analyze that for the accomplishment of the US we need, at this moment, the input of the family administrator of the following data:

- Other ID (User who will receive the money to his cash account);
- Family ID (User's Family);
- Card description (Card Description);
- Withdrawal limit (Card usage limit).

##2.1. Domain Model Diagram

```puml

title Class Diagram
hide empty members

class TransferMoneyFromCashAccountController {
+ transferMoneyFromCashAccount()
}

class CashAccount {
}

class Application {
+ getFamilyService()
}

class FamilyService {
+ getFamily()
}

class Family {
+ getFamilyMember()
}

class AccountService {
+ changeBalance()
}

class AccountData {
- double balance
- String description
- int accountID
- List<Transaction> transactions
}

interface Account {}

TransferMoneyFromCashAccountController --> Application : has
Application --> FamilyService : has
FamilyService --> Family : has list
Family --> FamilyMember : has list
TransferMoneyFromCashAccountController --> AccountService : has
AccountService --> CashAccount : change
CashAccount --|> Account : implements
CashAccount -* AccountData : contains
CashAccount <-- FamilyMember : has

```

# 3. Design

The process to fulfill the requirement we need the input of data from a UI to determine origin and destination accounts inside family members and the ammout to be transfered.
To execute the transfer

The controller will return:
- True, 
- False, 

## 3.1. Functionality Use

````puml

autonumber
title Transfer Money From Personal Cash Account To another Personal Cash Account
actor "Family Member" as actor
participant ": UI" as UI
participant ": TransferCashBetweenFamilyMembers \n CashAccountsController" as controller
participant ": FFMApplication" as application
participant ": AccountService" as aServ
participant ": FamilyService" as fServ
participant "aFamily : Family" as fam
participant "aFamilyMember : FamilyMember" as fMember
participant "aList<CashAccounts> : FamilyMemberAccounts" as cashAccounts
participant "oneCashTransferDTO : CashtransferDTO" as DTO

activate actor
actor -> UI: input destination data
activate UI
UI -> controller : transferCash(FamilyID, OriginFamilyMemberID, \n DestinationFamilyMemberID, ammount, category)
activate controller

controller -> application: getAccountService()
activate application
application --> controller: AccountService
controller -> application: getFamilyService()
application --> controller: FamilyService
deactivate application
controller -> fServ : getFamily(familyID)
activate fServ
fServ -> controller : Family
deactivate fServ

controller -> fServ:getFamilyMember(familyID, familyMemberCC)

activate fServ
fServ-> fam: getOriginFamilyMember(originFamilyMemberCC)
activate fam
fam --> fServ: OriginFamilyMember
fServ-> fam: getDestinationFamilyMember(destinationFamilyMemberCC)
fam -> fServ : DestinationFamilyMember
deactivate fam
fServ -> controller : sucess
deactivate fServ
controller -> aServ : getFamilyMemberCashAccount(FamilyID,FamilyMemberID, AccountID)
activate aServ
aServ ->fMember : getOriginFamilyMemberCashAccount(FamilyMemberID, AccountID)
activate fMember
fMember -> cashAccounts : getFamilyMemberCashAccount(AccountID)
activate cashAccounts
cashAccounts -> fMember : CashAccount
deactivate cashAccounts
fMember -> aServ : sucess
deactivate fMember
aServ ->fMember : getDestinationFamilyMemberCashAccount(FamilyMemberID, AccountID)
activate fMember
fMember -> cashAccounts : getFamilyMemberCashAccount(AccountID)
activate cashAccounts
cashAccounts -> fMember : CashAccount
deactivate cashAccounts
fMember -> aServ : sucess
deactivate fMember
controller --> UI: Success
deactivate controller
UI --> fMember: Inform Success
deactivate UI
deactivate fMember

@endpuml

# 3. Design



## 3.2. Class Diagram


## 3.3. Applied Patterns


## 3.4. Tests


## 4. Implementation


# 5. Integration/Demonstration


# 6. Observations

