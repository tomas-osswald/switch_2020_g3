# US186 Get List of Movements Between Dates
=======================================


# 1. Requirements

## 1.1. Client Notes

As a family member, I want to get the list of movements on one of my accounts between two dates.


The interpretation made of this requirement is that a Family Member can check the list of movements between two given dates in any of his accounts.

## 1.2 System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US011

actor "Family Member" as member
participant "System" as system

activate member
member -> system : choose account
activate system
member -> system : input dates

system --> member : return list

deactivate system
```

# 2. Analysis

Our analysis of this US is as follows:

To create a list of movements between a given date we need to have:

1. The ID of the target Account
2. The ID of the FamilyMember who owns the Account
3. The ID of the Family tho which the FamilyMember belongs
4. The first and last date

In turn, every movement in the list should have a description, a category, date and time, amount of money moved and remaining balance, as per this interaction with the PO:

> Question:  
> Relativamente à US186 (As a family member, I want to get the list of movements on one of my accounts between two dates), gostaríamos de saber se a informação abaixo se enquadra no que o professor quer obter juntamente com a lista de movimentos e se há mais alguma informação que gostaria que incluíssemos.
> - Descrição de cada movimento
> - Categoria de cada movimento
> - Data e hora de cada movimento
> - Quantidade de dinheiro envolvida
> - Saldo da conta após cada movimento
> 
> PO:  
> Parece-me bem.

This functionality will only fail if the Family, FamilyMember or Account do not exist. If the account does exist, a list
should always be returned. If the account does not have any movements registered, an empty list will be returned. If the
account does not have any movements between given dates registered, an empty list will be returned.

# 3. Design

This functionality allows the actor to access a list to see all movements in a given account between two dates.

Since we don't have an existing UI at the moment, all the necessary data will have to be manually inserted by the user.

The actor will need to insert the following data: familyID, familyMemberID, accountID, startDate and endDate

````puml
autonumber

title GetListOfMovementsBetweenDates(getAccount)
actor "Family Member" as FamilyMember
participant "UI" as UI
participant ": GetListOfMovements\nBetweenDatesController" as Controller
participant ": Application" as App
participant ": FamilyService" as FamilyService
participant "aFamily \n: Family" as Family
participant ": AccountService" as AccountService
participant "aFamilyMember \n: FamilyMember" as aFamilyMember

activate FamilyMember
FamilyMember -> UI: I want to add a \nBank Savings Account
activate UI
UI -> Controller : getListOfMovementsBetweenDates\n(familyID, familyMemberID, accountID, \nstartDate, endDate)
activate Controller

Controller -> App : getFamilyService()
activate App
App --> Controller : familyService
deactivate App

Controller -> FamilyService : getFamily(familyID)
activate FamilyService
FamilyService -> FamilyService : getFamily(familyID)
FamilyService --> Controller : Family
deactivate FamilyService

Controller -> Family : getFamilyMember\n(familyMemberID)
Activate Family
Family -> Family : getFamilyMember\n(familyMemberID)
Family --> Controller : aFamilyMember
Deactivate Family

Controller -> AccountService : getAccount(aFamilyMember, accountID)
activate AccountService

AccountService -> aFamilyMember : getAccount(accountID)
activate aFamilyMember
aFamilyMember -> aFamilyMember : getAccount\n(accountID)
aFamilyMember --> AccountService : anAccount
deactivate aFamilyMember

AccountService --> Controller : anAccount
deactivate AccountService

ref over Controller
GetListOfMovements
BetweenDates(getList)

end ref

Controller --> UI : ListOfMovements\nBetweenDates
deactivate Controller
UI --> FamilyMember : Display list
deactivate UI
deactivate FamilyMember
````

````puml
autonumber

title GetListOfMovementsBetweenDates(getList)

participant ": MovementService" as MovementService
participant "anAccount\n: Account" as Account
participant "aMovement\n: Movement" as Movement
participant "aMovementDTO\n: MovementDTO" as MovementDTO

-> MovementService ** : createMovementService()
-> MovementService : createListOfMovementsBetweenDates\n(anAccount, startDate, endDate)
activate MovementService

MovementService -> Account : getListOfMovements()
activate Account
Account --> MovementService : aListOfMovements
deactivate Account

loop for every movement in aListOfMovements
MovementService --> Movement : isMovementBetweenDates\n(aMovement, startDate, endDate)
activate Movement
alt false
Movement --> MovementService : false
else true
Movement --> MovementService : true
deactivate Movement
MovementService --> MovementDTO ** : createMovementDTO(aMovement)
MovementService --> MovementService : addMovementDTOToList\n(aMovementDTO)
end
end

<-- MovementService : ListOfMovementsBetweenDates
deactivate MovementService
````

## 3.1. Functionality Use

The controller will initiate a sequence to acquire the Account with the given accountID. First he will access the
FamilyService, where he will obtain the Family with the given ID. Then he will access the said Family to obtain the
FamilyMember with the givenID. Lastly he will obtain the Account by accessing said FamilyMember.

The next step is going to be the creation of the MovementService. This MovementService will only exist during the
scope of the functionality as it holds no relevant data.

Then, the Controller will invoke the createListOfMovementsBetweenDates method from the MovementService. This method
will first get a ListOfMovements from the Account. For every movement registered in this List, the method will first 
check if they occurred between the given dates, then create a DTO with the movement data and finally add said DTO to 
a list.

This List will be returned to the Controller.

## 3.2. Class Diagram

```puml

title Class Diagram
hide empty members

class GetListOfMovements\nBetweenDatesController {
+ getListOfMovementsBetweenDates()
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

class FamilyMember {
+ getAccount()
}

class MovementService {
+ createListOfMovementsBetweenDates()
}

class MovementDTO {
}

interface Account {}

GetListOfMovements\nBetweenDatesController --> Application : has
Application --> FamilyService : has
GetListOfMovements\nBetweenDatesController --> MovementService : creates
FamilyService --> Family : has list
Family --> FamilyMember : has list
FamilyMember --> Account : has list
MovementService --> MovementDTO : creates list


```

## 3.3. Applied Patterns

We applied the principles of Controller, Information Expert and PureFabrication from the GRASP pattern. We also
used the SOLID SRP principle.

The Information Expert and the Creator patterns would make all Account type classes responsible for creating and
handling Movement operations, as the instances of these classes hold all cash movement data. To avoid what we felt
was a more complicated solution that would promote high coupling and low cohesion we decided to apply the Pure
Fabrication Principle and created a MovementService Class.

This Class is responsible for all operations regarding Movements, thus providing low Coupling and high
Cohesion, keeping one Class as the Information Expert and applying the Single Responsibility Principle.

## 3.4. Tests

**Test 1:** Controller: If any exception is thrown (Family, FamilyMember or Account with given IDs do not exist), a null
list will be returned.


**Test 2:** MovementService: if the account holds no movements, an empty list will be returned.


**Test 3:** MovementService: if the account holds no movements that occurred between the given dates, an empty list 
will be returned.

package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.accounts.BankAccount;
import switchtwentytwenty.project.domain.model.accounts.BankSavingsAccount;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.accounts.CreditCardAccount;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementServiceTest {

    int accountID = 1;
    String designation = "Account";
    Double balance = null;
    CashAccount aCashAccount = new CashAccount(designation, balance, accountID);
    
    MovementService movementService = new MovementService();

    @Test
    void createListOfMovementsBetweenDates_ResultEmptyListNoMovements() {
        // arrange
        Date startDate = null;
        Date endDate = null;
        List<Movement> expected = new List<Movement>();

        // act
        List <Movement> result = movementService.createListOfMovementsBetweenDates(aCashAccount, startDate, endDate);

        // assert
        assertEquals(expected, result);
    }

    @Test
    void createListOfMovementsBetweenDates_ResultEmptyListNoMovementsBetweenDates() {

    }

    @Test
    void createListOfMovementsBetweenDates_ResultOneMovementList() {

    }

    @Test
    void createListOfMovementsBetweenDates_ResultManyMovementsList() {

    }
}

# 4. Implementation

### Check if movement happened between two given dates


### Create Movement DTO


### Create Movement DTO list


# 5. Integration

EDIT EDIT EDIT EDIT EDIT EDIT EDIT


# 6. Observations
