# US000 Check balance
=======================================

# 1. Requirements

## 1.1 Client Notes


## 1.2 Dependencies

### 1.2.1 Pre-conditions

### 1.2.2 Other User Stories

## 1.3 Acceptance Criteria

### 1.3.1 Success Cases

### 1.3.2 Failure Cases

## 1.4 SSD

# 2. Analysis

## 2.1 Summary

### Information Needed

| **_Name_**         | **_Business Rules_**                                                                   |
| :-------------------------- | :------------------------------------------------------------------------------------- |
| **AccountID**                | Required, long            |


## 2.2. Domain Model Excerpt


# 3. Design

## 3.1. Design decisions

To check the balance of an account, we will need the account's AccountID. This will be provided in the request's URI. Check balance will only allow GET requests as follows:

```
GET/ "*/accounts/{accountID}"
```

Only accounts the user has permission to check should be available from the client. Authentication and authorization will be made with a token provided by a request. An options request to an account will return the permissions a user has for this account, including whether he can check its balance.

With an AccountID, an Account can be retrieved from persistence and its balance returned to the client.

## 3.2. Class Diagram


## 3.3. Functionality Use


## 3.4. Sequence Diagram

```puml
autonumber 1
title Create Account

participant ": IAccountRESTController" as controller
participant ": ICheckBalanceService" as service
participant "account : Account" as account
participant ": IAccountRepository" as repository
participant ": IAccountRepositoryJPA" as repositoryJPA


-> controller : checkBalance(long accountID)
activate controller

ref over controller
Long AccountID to InputAccountIDDTO

inputAccountIDDTO = accountIDDTOAssembler.toInputDTO(long accountID)
end

controller -> service : checkBalance(inputAccountIDDTO)
activate service

service -> service : accountID = new AccountID\n(inputAccountIDDTO.unpackAccountID)

service -> repository : getByID(accountID)
activate repository

repository -> repository : accountIDJPA = new \nAccountIDJPA(accountID)

repository -> repositoryJPA : findByID(accountIDJPA)
activate repositoryJPA
return accountJPA

ref over repository
AccountJPA to Account

account = accountDataDomainAssembler.toDomain(accountJPA)
end

return account

service -> account : getBalance()
activate account
return balance

ref over service
Balance to OutputBalanceDTO

outputBalanceDTO = balanceDTODomainAssembler.toDTO(balance)
end

return outputAccountDTO

ref over controller
Add Links to account to OutputBalanceDTO
end

return responseEntity

```


```puml
autonumber
title AccountJPA to Account

participant ": AccountDataDomainAssembler" as assembler
participant "accountID : AccountID" as id
participant "ownerID : OwnerID" as owner
participant "balance : Balance" as balance
participant "description : Description" as description
participant "accountType: AccountType" as type

-> assembler : toDomain(accountJPA)
activate assembler

assembler -> id** : create(accountJPA.getId()) 

assembler -> owner ** : create(accountJPA.getOwner())

assembler -> balance ** : create(accountJPA.getBalance())

assembler -> description ** : create(accountJPA.getDescription)

assembler -> type : valueOf(accountJPA.accountType)
activate type
return accountType

ref over assembler
Account Factory 2.

account = accountFactory.getAccout(ownerID, balance, description, accountType, accountID)
end

return account

```

```puml
autonumber
title Account Factory 2.

participant ": AccountFactory" as factory
participant "cashAccount : Account" as cashAccount
participant "bankAccount : Account" as bankAccount
participant "bankSavingsAccount : Account" as bankSavingsAccount
participant "creditCardAccount : Account" as creditCardAccount

-> factory : getAccount(ownerID, balance, description, accountType, accountID)
activate factory

alt if(accountType = "CASH_ACCOUNT")
factory -> cashAccount ** : create(ownerID, balance, description, accountID)

else if(accountType = "BANK_ACCOUNT")
factory -> bankAccount ** : create(ownerID, balance, description, accountID)

else if(accountType = "BANK_SAVINGS_ACCOUNT")
factory -> bankSavingsAccount ** : create(ownerID, balance, description, accountID)

else if(accountType = "CREDIT_CARD_ACCOUNT")
factory -> creditCardAccount ** : create(ownerID, balance, description, accountID)

end

return account

```


## 3.5 Tests

### Controller Tests

### Service Tests


### Assembler Tests


### Repository Tests


### Account Tests


### Testes de Value Objects, JPAs e DTOs
  
    