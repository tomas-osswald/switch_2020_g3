# US120 Create family cash account.
=======================================


# 1. Requirements

**Demo1** US120 As a family administrator, I want to create a family cash account.

- Demo1.1. The family already has a cash account
  
- Demo1.2. The family does not yet have a cash account

Our interpretation of this requirement was to create the function for a family administrator to be able to create a cash account for the family he administrates. As the family may only have one cash account, we need to check if one exists already.

# 2. Analysis

The concepts Family and Cash Account are closely coupled as a family can have one or no cash accounts.

# 3. Design

The family class will be the creator of the cash account object, because it has the information necessary to create one (the familyID it will be associated with) and will also record its instance.

The Class FFMApplication keeps a list of families where the family with a given ID can be obtained.

```puml
autonumber 1
title createFamilyCashAccount
actor "FamilyAdministrator" as familyAdmin
participant ": UI" as UI
participant ": CreateFamilyCash\nAccountController" as controller
participant ": FFMApplication" as app
participant "aFamily : Family" as family

activate familyAdmin
familyAdmin -> UI: create a Family Cash \n Account (familyID)
activate UI
UI -> controller: createFamilyCash\nAccount(familyID)
activate controller
controller -> app: createFamilyCash\nAccount(familyID)
activate app
app -> app: aFamily = \ngetFamilyByID(FamilyID)

app -> family: createFamily\nCashAccount()
activate family
family -> family: hasCashAccount()

alt failure

family --> app: fail
app --> controller: fail
controller --> UI: fail
UI --> familyAdmin: Failure

else success
ref over family
Success
end ref

family --> app: ok
deactivate family
app --> controller: ok
deactivate app
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

## 3.1. Functionality Use

For this function the actor Family Administrator requests the creation of a cash account for the family he administrates to the UI.
The UI will forward this request to the CreateFamilyCashAccountController, who will in turn call the FFMApplication class to select from a list the family to which a cash account is to be added. After obtaining said family, the request is forwarded to the family object.
The Family object will first check if it already has a cash account, at which point a fail message can be sent back if there is an associated cash account.
If there is no associated cash account, the Family object will first create a new CashAccount object and then record its existence. At this point, a success message will be sent back to the user.

## 3.2. Class Diagram

```puml

title Class Diagram

class UI {
  - createFamilyCashAccount()
}

class CreateFamilyCashAccountController {
  - createFamilyCashAccount()
}

class FFMApplication {
  - List<Family> families
  - List<Category> categories
  - getFamilyByID()
  - createFamilyCashAccount()
}

class Family {
  - int familyID
  - String name
  - date registrationDate
  - List <FamilyMember> familyMembers
  - CashAccount cashAccount
  - hasCashAccount()
  - createFamilyCashAccount()
}

class CashAccount {
  - int CashAccountID
  - double balance
}


UI --> CreateFamilyCashAccountController
CreateFamilyCashAccountController --> FFMApplication
Family --> CashAccount
FFMApplication --> Family

```

## 3.3. Applied Patterns

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas*

## 3.4. Tests 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Test 1:** Verify that the family does not yet have a cash account

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

**Test 2:** Verify that the cash account has been added

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



