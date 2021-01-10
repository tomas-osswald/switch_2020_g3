# US120 Create family cash account.
=======================================

# 1. Requirements

**Demo1** US120 As a family administrator, I want to create a family cash account.

- Demo1.1. The family already has a cash account
  
- Demo1.2. The family does not yet have a cash account

Our interpretation of this requirement was to create the function for a family administrator to be able to create a cash account for the family he administrates. As the family may only have one cash account, we need to check if one exists already.

# 2. Analysis

The concepts Family and Cash Account are closely coupled as a family can have one or no cash accounts.

In the future, it is expected that the Family Members will also have their own cash accounts, at which point the relation between all involved classes has to be analyzed.

A cash account will have a cash balance as well as an unique ID number.

# 3. Design

The family class will be the creator of the cash account object, because it has the information necessary to create one (the familyID it will be associated with) and will also record its instance.

The Class FFMApplication keeps a list of families where the family with a given ID can be obtained.

## 3.1. Functionality Use

```puml
autonumber 1
title createFamilyCashAccount
actor "FamilyAdministrator" as familyAdmin
participant ": UI" as UI
participant ": CreateFamilyCash\nAccountController" as controller
participant ": FFMApplication" as app
participant ": familyService : FamilyService" as famSer
participant "aFamily : Family" as family

activate familyAdmin
familyAdmin -> UI: create a Family Cash \n Account (familyID)
activate UI
UI -> controller: createFamilyCash\nAccount(familyID)
activate controller
controller -> app: getFamilyService()
activate app
app -> controller: FamilyService
deactivate app
controller -> famSer: createFamilyCash\nAccount(familyID)
activate famSer
famSer -> famSer: aFamily = \ngetFamilyByID(FamilyID)

famSer -> family: createFamily\nCashAccount()
activate family
family -> family: hasCashAccount()

alt failure

family --> famSer: fail
famSer --> controller: fail
controller --> UI: fail
UI --> familyAdmin: Failure

else success
ref over family
Success
end ref

family --> famSer: ok
deactivate family
famSer --> controller: ok
deactivate famSer
controller --> UI: ok
deactivate controller
UI --> familyAdmin: ok
deactivate UI

end
deactivate familyAdmin
```

```puml
autonumber
title createFamilyCashAccountSuccess

participant "aFamily : Family" as family
participant "newFamilyCashAccount\n : CashAccount" as cashAccount

-> family: createFamilyCashAccount()
activate family
family -> family: hasCashAccount()

family -> cashAccount **: createFamilyCashAccount()
family -> family: addFamilyCashAccount\n(newFamilyCashAccount)

[<-- family: ok
deactivate family
```

For this function the actor Family Administrator requests the creation of a cash account for the family he administrates to the UI.
The UI will forward this request to the CreateFamilyCashAccountController, who will in turn call the FFMApplication class to select from a list the family to which a cash account is to be added. After obtaining said family, the request is forwarded to the family object.
The Family object will first check if it already has a cash account, at which point a fail message can be sent back if there is an associated cash account.
If there is no associated cash account, the Family object will first create a new CashAccount object and then record its existence. At this point, a success message will be sent back to the user.

## 3.2. Class Diagram

```puml

title Class Diagram

class CreateFamilyCashAccountController {
  - Application app
  + createFamilyCashAccount()
}

class Application {
  - FamilyService familyService
  + getFamilyService()
}

class FamilyService {
  - List<Family> families
  - getFamilyByID()
  + createFamilyCashAccount()
}

class Family {
  - int familyID
  - CashAccount cashAccount
  - hasCashAccount()
  + createFamilyCashAccount()
}

class CashAccount {
  - int CashAccountID
  - double balance
  + getBalance()
  + changeBalance(double value)
}

CreateFamilyCashAccountController --> Application
Application --> FamilyService
Family --> CashAccount
FamilyService --> Family
```

## 3.3. Applied Patterns

For this user story the main GRASP principles used were the Creator, in this case the Family class that records instances of CashAccount, and the Controller, a class created to deal with all system events related.

## 3.4. Tests 

The creation of a cash account faces one main conditions that must be true for its success:

The given family does not yet have a cash account.

**Test 1:** Verify that the family does not yet have a cash account

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

**Test 2:** Verify that the family already has a cash account

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

**Test 3:** Verify that the cash account has been added

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

# 4. Implementation

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integration/Demonstration

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observations

Later in this project cash accounts will be associated with either families or family members. Right now the class cash account is closely related only to the family class, as the family member does not yet have the ability to create or own a cash account. Can high coupling be avoided between the three classes?


