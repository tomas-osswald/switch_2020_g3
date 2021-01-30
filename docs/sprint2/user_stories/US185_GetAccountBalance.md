# US181 Get Account Balance
=======================================


# 1. Requirements

### 1.1 Client's Sheet

- As a family member, I want to check the balance of one of my accounts.

We interpreted this requirement as the function of a FamilyMember to retrieve the balance from one of his accounts.

The balance is an attribute of all account types, with the exception of the Cash Account, since this is contemplated on US135 (e.g. Savings, Bank, Credit Card accounts).
  

### 1.2 System Sequence Diagram

```` puml

    autonumber
    title US185 - Get Account Balance
    actor "Family Member" as fm
    participant "System" as system

    activate fm
    fm -> system: Get Profile Information
    activate system
    fm -> system: input required data
    system --> fm: return Balance
    deactivate fm
    deactivate system

@endpuml
````


### 1.3 Dependencies

This user story has a dependency with these **1** user stories:

- **[US010](US010_AddFamily.md)** *(As a system manager, I want to create a family)*
  - In order to be added a family member, the system needs to have a family;

- **[US011](US010_AddFamilyAdministrator.md)** *(As a system manager, I want to add a family administrator)*
  - In order to be added a family member, the family needs to have a family administrator;
  
- **[US101](US101_AddFamilyMember.md)** *(As a family Administrator, I want to add a familyMember to a family)*
  - In order to add a bank account, the system needs to have that Family Member.

- **[US171](US170_CreatePersonalCashAccount.md)** *(As a family member, I want to create a personal cash account.)*
  - In order to be get cash account balance, there needs to be a cash account in the family member.
  
- **[US171](US171_AddBankAccount.md)** *(As a family member, I want to add a bank account I have.)*
  - In order to be get bank account balance, there needs to be a bank account.

- **[US172](US172_AddBankSavingsAccount.md)** *(As a family member, I want to add a bank savings account I have.)*
  - In order to be get savings account balance, there needs to be a savings account.

- **[US173](US173_AddCreditCardAccount.md)** *(As a family member, I want to add a credit card account I have.)*
  - In order to be get credit card account balance, there needs to be a credit card account.
  
# 2. Analysis

In order to fulfill this requirement, we need three main data pieces:
- Family ID;
- Family Member ID;
- Bank Account ID;

Since the accounts will be stored inside the Family Members, we need to be able to identify the family member in question. For this we need both the familyID and the familyMemberID.
To identify the account we need the account ID, which is unique in each family member, this approach removes the need to check if the account belongs to the user requesting the balance.

At a later iteration, the family's and family member's IDs would be acquired through the Log In information. For this sprint, the IDs will have to be inputted along with the Bank Account information.

# 3. Design

````puml
@startuml
autonumber
title US171 - GetAccountBalance Sequece Diagram

actor "FamilyMember" as actor
participant ": UI" as UI
participant ": GetAccountBalanceController" as controller
participant ": FFM Application" as app
participant "accServ : AccountService" as accServ
participant "famServ : FamilyService" as famService
participant "aFamily : Family" as family
participant "aFamilyMember : FamilyMember" as person
participant "aAccount: Account" as account

activate actor
actor -> UI: get account balance
activate UI
UI -> actor: ask data
deactivate UI
actor -> UI: inputs required data
activate UI
UI -> controller: getAccountBalance(familyID,familyMemberID, accountID)

activate controller
controller -> app: getFamilyService()
activate app
app -> controller: aFamilyService
deactivate app

controller -> famService: getFamily(familyID)
activate famService
famService -> famService: getFamily(familyID)
famService -> controller: aFamily
deactivate famService
controller -> family: getFamilyMember(familyMemberID)
activate family
family -> family: getFamilyMember(familyMemberID)
family -> controller: aFamilyMember
deactivate family
controller -> accServ: getAccountBalance(FamilyMember, accountID)
activate accServ
accServ -> person: getAccountBalance(accountID)
activate person
person -> person: getAccount(accountID)
person -> account: getAccountBalance()
activate account
account -> account: getBalance()
account -> person: balance
deactivate account
person -> accServ: balance
deactivate person
accServ -> controller: balance
deactivate accServ
controller -> UI: balance
deactivate controller
UI -> actor: Display balance
deactivate UI
deactivate actor

@enduml
````


## 3.1. Functionality Use
The getAccountBalanceController will invoke the application object, the Family Service object, the Family object, the Family Member object and finally the account object.
In each of these steps it will find the corresponding instance, using either the familyId, familyMemberID or accountID.
Once the correct account is reached, it will get and return the balance of the account back to the controller.


## 3.2. Class Diagram
The main Classes involved are:
- GetAccountBalanceController
- Application
- FamilyService
- Family
- FamilyMember
- Account
- BankAccount
- CreditCardAccount
- SavingsAccount

**AddBankAccount()**
```puml
@startuml

title GetAccountBalance()
hide empty members

class GetAccountBalanceController {
  - Application app
  + getAccountBalance()
}

class Application {
  - FamilyService familyService
  + getFamilyService()
}

class FamilyService {
  - List<Family> families
  + getFamily()
}

class Family {
  - int familyID
  - List<FamilyMember> familyMembers
  + getFamilyMemberByID()  
}

class FamilyMember {
  - List<Account> accounts
  # compareID()
  + getAccount()
  
}

class CCNumber {
  - String ccNumber
  + getCcNumber()
}

class BankAccount {
  - Balance
}
class SavingsAccount {
  - Balance
}
class CreditCardAccount {
  - Balance
}

interface Account{
}

GetAccountBalanceController --> Application
GetAccountBalanceController --> FamilyService
GetAccountBalanceController --> Family
GetAccountBalanceController --> FamilyMember
GetAccountBalanceController --> BankAccount
GetAccountBalanceController --> SavingsAccount
GetAccountBalanceController --> CreditCardAccount
FamilyMember --> CCNumber
BankAccount --|> Account
SavingsAccount --|> Account
CreditCardAccount --|> Account



@enduml
```

## 3.3. Applied Patterns
We applied the principles of Controller, Information Expert, Creator e PureFabrication from the GRASP pattern.
We also used the SOLID SRP principle.

## 3.4. Domain Tests 

###Test 1: Verify that a vatNumber is accepted -> Class VatNumber
- **1.1.** VatNumber is not created, and an error is thrown because **vatNumber** is null

- **1.2.** VatNumber is not created, and an error is thrown because **vatNumber** is incorrect

- **1.3.** VatNumber is created because **vatNumber** is correct
    
###Test 2: Verify that an address is accepted -> Class Address
- **2.1.** Address is not created, and an error is thrown because **street** is null
  
- **2.2.** Address is not created, and an error is thrown because **street** is empty
  
- **2.3.** Address is not created, and an error is thrown because **street** is blank
  
- **2.4.** Address is created because **street** is correct
  
- **2.5.** Address is not created, and an error is thrown because **postalCode** is null
  
- **2.6.** Address is not created, and an error is thrown because **postalCode** is empty
  
- **2.7.** Address is not created, and an error is thrown because **postalCode** is blank
  
- **2.8.** Address is not created, and an error is thrown because **postalCode** is incorrect

- **2.9.** Address is created because **postalCode** is correct

- **2.10.** Address is not created, and an error is thrown because **local** is null

- **2.11.** Address is not created, and an error is thrown because **local** is empty

- **2.12.** Address is not created, and an error is thrown because **local** is blank

- **2.13.** Address is created because **local** is correct

- **2.14.** Address is not created, and an error is thrown because **city** is null

- **2.15.** Address is not created, and an error is thrown because **city** is empty

- **2.16.** Address is not created, and an error is thrown because **city** is blank

- **2.17.** Address is created because **city** is correct

###Test 3: Verify that a phone is accepted -> Class PhoneNumber and FamilyMember
- **3.1.** Phone is not created, and an error is thrown because **phoneNumber** is null
  
- **3.2.** Phone is not created, and an error is thrown because **phoneNumber** is incorrect
  
- **3.3.** Phone is created because **phoneNumber** is correct
  
- **3.4.** With FamilyMember constructor from **FamilyAdministrator**, the constructor is executed without phone being created when **phone** is null
````
@Test
    void CreateMember_PhoneNull_NoAdmin() {
        Integer phone = null;
        FamilyMember person = new FamilyMember(cc, name, date, phone, email, nif, rua, codPostal, local, city);
        assertFalse(person.validatePhone(phone));
    }
````

###Test 4: Verify that an email is accepted -> Class Email and FamilyMember
- **4.1.** All email tests are in **[US151]**
  
- **4.2.** With FamilyMember constructor from **FamilyAdministrator**, the constructor is executed without email being created when **email** is null
````
@Test
void CreateMember_EmailNull_NoAdmin() {
    String emailx = null;
    FamilyMember person = new FamilyMember(cc, name, date, numero, emailx, nif, rua, codPostal, local, city);
    assertFalse(person.validateEmail(emailx));
}
````

###Test 5: Verify that a birthDate is accepted -> Class FamilyMember
- **5.1.** With FamilyMember constructor from **FamilyAdministrator**, BirthDate is not created, and an error is thrown because **birthDate** is null

- **5.2.** With FamilyMember constructor from **FamilyAdministrator**, BirthDate is created because **birthDate** is correct

###Test 6: Verify that a Name is accepted -> Class FamilyMember
- **6.1.** With FamilyMember constructor from **FamilyAdministrator**, name is not created, and an error is thrown because **name** is null

- **6.2.** With FamilyMember constructor from **FamilyAdministrator**, name is not created, and an error is thrown because **name** is empty

- **6.3.** With FamilyMember constructor from **FamilyAdministrator**, name is not created, and an error is thrown because **name** is blank

- **6.4.** With FamilyMember constructor from **FamilyAdministrator**, name is created because **name** is correct

###Test 7: Verify if the VatNumber already belongs to a familyMember from user's family -> Class Family
- **7.1** FamilyMember is not created and not added to the family, and an error is thrown because the **vatNumber** already exists in this family
````
@Test
void NotAddFamilyMember_VatExists() {
    FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
    String familyName = "Moreira";
    int familyID = 1;
    Family familia = new Family(familyName, familyID);
    familia.addFamilyMember(pessoa1);
    assertThrows(IllegalArgumentException.class, () -> familia.addFamilyMember(cc2, name2, date2, numero2, email2, nif, rua2, codPostal2, local2, city2));
}
````
- **7.2** FamilyMember is created and added to the family because the **vatNumber** does not exists in this family
````
@Test
void AddFamilyMember_VatNotExists() {
    FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
    String familyName = "Moreira";
    int familyID = 1;
    Family familia = new Family(familyName, familyID);
    familia.addFamilyMember(pessoa1);
    assertTrue(familia.addFamilyMember(cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2));
}
````

###Test 8: Verify if the ccNumber already belongs to a familyMember from user's family -> Class Family
- **8.1** FamilyMember is not created and not added to the family, and an error is thrown because the **ccNumber** already exists in this family
````
@Test
void NotAddFamilyMember_CCExists() {
    FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
    String familyName = "Moreira";
    int familyID = 1;
    Family familia = new Family(familyName, familyID);
    familia.addFamilyMember(pessoa1);
    assertThrows(IllegalArgumentException.class, () -> familia.addFamilyMember(cc, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2));
}
````

- **8.2** FamilyMember is created and added to the family because the **ccNumber** does not exists in this family
````
@Test
void AddFamilyMember_CCNotExists() {
    FamilyMember pessoa1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
    String familyName = "Moreira";
    int familyID = 1;
    Family familia = new Family(familyName, familyID);
    familia.addFamilyMember(pessoa1);
    assertTrue(familia.addFamilyMember(cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2));
}
````

###Test 9: Verify if the email already exists in the system -> Class FamilyService
- **9.1** FamilyMember is not created and not added to the family, and an error is thrown because the **email** already exists in the Application
````
@Test
void NotAddFamilyMember_EmailPresent() {

    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
    int familyID = 1;
    String familyName = "Ribeiro";
    Family ribeiro = new Family(familyName, familyID);
    ribeiro.addFamilyMember(diogo);
    FamilyService familias = new FamilyService(ribeiro);
    assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(cc, cc2, name2, date2, numero2, "abc@gmail.com", nif2, rua2, codPostal2, local2, city2, 1));
}
````
- **9.2** FamilyMember is created and added to the family because the **email** does not exists in the Application
````
@Test
void AddFamilyMember_EmailNotPresent() {
  FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
  int familyID = 1;
  String familyName = "Ribeiro";
  Family ribeiro = new Family(familyName, familyID);
  ribeiro.addFamilyMember(diogo);
  FamilyService familias = new FamilyService(ribeiro);
  assertTrue(familias.addFamilyMember(cc, cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, 1));
}
````
###Test 10: Verify if the Family exists in the system -> Class FamilyService
- **10.1** FamilyMember is not created and not added to the family, and an error is thrown because the **Family** does not exists in the Application
````
@Test
void NotAddFamilyMember_FamilyNotExists() {
    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
    int familyID = 1;
    String familyName = "Ribeiro";
    Family ribeiro = new Family(familyName, familyID);
    FamilyService familias = new FamilyService(ribeiro);
    assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(cc, cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, 2));
}
````
- **10.2** FamilyMember is created and added to the family because the **Family** exists in the Application
````
@Test
void AddFamilyMember_FamilyExists() {
    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
    int familyID = 1;
    String familyName = "Ribeiro";
    Family ribeiro = new Family(familyName, familyID);
    ribeiro.addFamilyMember(diogo);
    FamilyService familias = new FamilyService(ribeiro);
    assertTrue(familias.addFamilyMember(cc, cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, 1));
}
````
###Test 11: Verify if the User is Admin -> Class FamilyService
- **11.1** FamilyMember is not created and not added to the family, and an error is thrown because the user is not **admin**
````
@Test
void NotAddFamilyMember_NotAdmin() {
    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
    int familyID = 1;
    String familyName = "Ribeiro";
    Family ribeiro = new Family(familyName, familyID);
    ribeiro.addFamilyMember(diogo);
    FamilyService familias = new FamilyService(ribeiro);
    assertThrows(IllegalArgumentException.class, () -> familias.addFamilyMember(cc, cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, 1));
}
````
- **11.2** FamilyMember is created and added to the family because the user is **admin**
````
@Test
void AddFamilyMember_isAdmin() {
    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, true);
    int familyID = 1;
    String familyName = "Ribeiro";
    Family ribeiro = new Family(familyName, familyID);
    ribeiro.addFamilyMember(diogo);
    FamilyService familias = new FamilyService(ribeiro);
    assertTrue(familias.addFamilyMember(cc, cc2, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, 1));
}
````

# 4. Implementation

During this feature implementation extra code was added to avoid the UI limitation. These scenarios were the following:

- ####Verify if the user is a FamilyAdmin

With the UI and login layer implemented, this info is already defined and the controller doesn't need to ask the Family his selfCCNumber to assure the user is Admin.

- ####Get the FamilyID 

With the UI and login layer implemented, it is not necessary to ask which family this user belongs to.

# 5. Integration/Demonstration

As it was said before, this UserStory dependes on both **[US010 - Add Family]** and **[US011 - Add Family Administrator]**.

# 6. Observations

In the future, both issues presented in implementation section will be solved when the UI, and login layer are set up.
With the login layer, the user ID will be already available before the UserStory gets executed, avoiding the method *getFamily(familyID)* execution. 
A similar scenario will happen with *selfCCNumber*, because the UI will already know which user is executing this UserStory and therefore don't need confirm if he has permissions to do it.


