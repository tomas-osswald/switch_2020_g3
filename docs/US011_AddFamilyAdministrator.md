# US151 Add family administrator
=======================================


# 1. Requirements

## 1.1. Client Notes

As a system manager, I want to add a family administrator:

**Demonstratim 1** As a system manager, I want to add...

- 1.1. A new administrator.

**Extracted from communications with the Product Owner**

- *"A Family Administrator is a Family Member too."*
- *"Is there only one administrator per family"*

The interpretation made of this requirement is that the system administrator can add a new administrator to a family that dont have an assigned administrator.

## 1.2 System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US011

actor "System Manager" as manager
participant ": System" as system

activate manager

activate system
manager -> system : choose family with no administrator
manager -> system : input required data

alt failure
system -> manager : Inform Failure

else sucess
system -> manager : Inform Sucess

end

deactivate system

deactivate manager
```

## 1.3. Dependencies from other User Stories

This user story is dependent on the following:

- US010_Add Family: to create a family without members and administrator.

# 2. Analysis

For the fulfillment of the raised requirements, we analyze that for the accomplishment of the US we need, at this moment, the impute of the system administrator of the following data:

- The Family he wants to add an administrator;
- And the data necessary to create a new administrator (id, name, vatNumber, address, birthDate, phoneNumber and emailAddress).

From analysis done to requirements gathering, a new administrator will be created to a family that has no administrator.

##2.1. Domain Model Diagram



# 3. Design

The main process to fulfill this requirement, would require the actor to choose a family without administrator and input the data needed to create a family administrator.

## 3.1 Functionality Use

**addFamilyAdministrator( ).1**
```puml

autonumber
title addFamilyAdministrator( ).1
actor "System Manager" as systemManager
participant ": UI" as UI
participant ": AddFamilyAdministratorController" as controller

activate systemManager
systemManager -> UI: add a family administrator
activate UI
UI -> controller: getFamiliesWithoutAdministrator()
activate controller

ref over controller
addFamilyAdministrator( ).2
end ref

autonumber 7
controller --> UI: listOfFamilies
deactivate controller
UI --> systemManager: show list of families without an administrator and ask to select one
deactivate UI

systemManager -> UI: select chosen family
activate UI
UI --> systemManager: ask family administrator's data (id, name, vatNumber, address, \nbirthDate, phoneNumber, emailAddress)
deactivate UI

systemManager -> UI: input data
activate UI
UI -> controller: addFamilyAdministrator(id, name, vatNumber, address, \nbirthDate, phoneNumber, emailAddress, familyID)
activate controller

ref over controller : addFamilyAdministrator( ).3

autonumber 26
alt 
controller --> UI: inform failure
UI --> systemManager: inform failure

else 

autonumber 26
controller --> UI: inform sucess
deactivate controller
UI --> systemManager: inform success
deactivate UI

end

```

**addFamilyAdministrator( ).2**
```puml
autonumber 2
title addFamilyAdministrator( ).2

participant ": AddFamilyAdministratorController" as controller
participant ": App" as app
participant "familyService : FamilyService" as familyService

-> controller : getFamiliesWithoutAdministrator
activate controller
controller -> app : getFamilyService( )
activate app
app -> controller : familyService
deactivate app
controller -> familyService: getFamiliesWithoutAdministrator( )
activate familyService
familyService -> controller: listOfFamilies
deactivate familyService
<- controller : ListOfFamilies
deactivate controller 
```

**addFamilyAdministrator( ).3**
```puml
autonumber 12
title addFamilyAdministrator( ).3

participant ": AddFamilyAdministratorController" as controller
participant ": App" as app
participant "familyService : FamilyService" as familyService
participant "aFamily : Family" as family

-> controller : addFamilyAdministrator(id, name, \nvatNumber, address, birthDate, phoneNumber, \nemailAddress, familyID, administrator)
activate controller
controller -> app: getFamilyService()
activate app
app --> controller: FamilyService
deactivate app
controller -> familyService: addFamilyAdministrator(id, name, vatNumber, address, \nbirthDate, phoneNumber, emailAddress, familyID, administrator)
activate familyService

familyService -> familyService: aFamily = getFamily(familyID)

familyService -> family : addFamilyAdministrator(id, name, vatNumber, address, \nbirthDate, phoneNumber, emailAddress, administrator)
activate family

ref over family : addFamilyAdministrator( ).4

autonumber 24
family -> familyService : inform sucess
deactivate family

familyService -> controller : inform sucess
deactivate familyService

<- controller : inform sucess
deactivate controller

```

**addFamilyAdministrator( ).4**
```puml
autonumber 17
title addFamilyAdministrator( ).4

participant "aFamily : Family" as family
participant "familyAdministrator \n: FamilyMember" as administrator
participant "aVATNumber \n: VATNumber" as vatNumber
participant "anAddress \n: Address" as address
participant "aPhoneNumber \n: PhoneNumber" as phoneNumber
participant "anEmail : Email" as email

-> family : addFamilyAdministrator(id, name, \nvatNumber, address, birthDate, phoneNumber, \nemailAddress, administrator)
activate family

activate administrator
family -> administrator**
administrator -> vatNumber**
administrator -> address**
administrator -> phoneNumber**
administrator -> email**
deactivate administrator

family -> family : addFamilyMember\n(familyAdministrator)

<- family : inform sucess
deactivate family

```

## 3.2. Class Diagram

```puml
title Class Diagram

class FFMapp {
- Category list

}

class FamilyService {
- Families List
}

class Family {
- familyID
- registrationDate
- familyID
- relationDesignationsList

}

class FamilyMember {
- personID
- name
- birthDate
- boolean: administrtor

}


FFMapp -down-> FamilyService : has list of 
FamilyService -down-> Family : has list of
Family -down-> FamilyMember : has list of 
```

## 3.3. Applied Patterns

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas*

## 3.4. Tests
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Exemplo com valores nulos.

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

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*