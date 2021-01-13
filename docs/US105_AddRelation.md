# US105 Create a relation between two family members

# 1. Requirements

## 1.1. Client Notes

As administrator, I want to create a relation between two family members:

**Demonstration 1** As administrator, I want to...

- 1.1. Create a new relation and set that relation to a given member.

**Extracted from communications with the Product Owner**

- *"All relations use the level of the main user of the family as a reference. Be aware that SWS wants its application to be as inclusive as possible, in order to wider its market base"*;
- *"When creating relationships, they are relative to the "main user level", not at all restricted to the main user"*.
- *"Relationships are created by the Family Administrator. Eventually he can make some mistakes, but it is not expected that this will have a major impact on the operation of the application. If this is relevant in the future then this problem is addressed."*

The interpretation made of this requirement is that the family administrator can create relationships between family members and him, and these relationships are not restricted to normal family relationships.

## 1.2. System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US105

actor "Family Administrator" as familyAdministrator
participant ": System" as system

activate familyAdministrator
familyAdministrator -> system : add relation to member
activate system
familyAdministrator -> system : inputs required data

alt failure
system -> familyAdministrator : Inform Failure

else sucess
system -> familyAdministrator : Inform Sucess

end

deactivate system

deactivate familyAdministrator
```

## 1.3. Dependencies from other User Stories

This user story is dependent on the following:

- US010_Add Family: to create a family;
- US011_Add Family Administrator: to add an Administrator, that he is allowed to add a Relation;
- US101_Add Family Members: to add a Relation.

# 2. Analysis

For the fulfillment of the raised requirements, we analyze that for the accomplishment of the US we need, at this moment, the input of the family administrator of the following data:

- Self ID (User that tries to add relation to other Family Member);
- Other ID (ID from the Family Member to whom will be added a relationship);
- Relation Designation (Relationship name);
- Family ID (User's family ID).

From analysis done to requirements gathering, if the user is the family administrator, he/she will be able to add a relationship to the family member in question, regardless of whether the relationship designation exists or does not exist in the list of designations present in the app. 

As we did not get an answer to the question about the previous existence of a Relation attributed to a Family Member, it was assumed that an error is thrown (caught and returns false), with no changes in the existing Relation.

*"o artefacto principal a usar é o Modelo de Domínio (MD). É sempre elaborado numa perspetiva de negócio e não numa perspetiva técnica"*

##2.1. Domain Model Diagram

```puml
hide empty members
hide circle
title Domain Model Diagram US105

class Family {
- Name
- UniqueID
- RegistrationDate

}

class FamilyMember {
- Name
- BirthDate

}

class Relation {
- Designation

}

Family -down-> FamilyMember : has administrator
Family -down-> FamilyMember : \n has members
FamilyMember -down-> Relation : has relation
FamilyMember -- FamilyMember : administrator can add relation to family members
(FamilyMember, FamilyMember) <.. Relation 

```

# 3. Design

*Nesta secção a equipa deve descrever o design adotado para satisfazer a funcionalidade. Entre outros, a equipa deve apresentar diagrama(s) de realização da funcionalidade, diagrama(s) de classes, identificação de padrões aplicados e quais foram os principais testes especificados para validar a funcionalidade.*

*Para além das secções sugeridas, podem ser incluídas outras.*

* os principais artefactos são o Diagrama de Sequência (SD) e o Diagrama de classes (CD). Os padrões aplicados servem para suportar/justificar as opções/decisões tomadas e refletidas nos artefactos. Os conceitos de negócio (MD) inspiram a existência de classes de software*


## 3.1. Functionality Use

**createRelation( ).1**
```puml
autonumber

title createRelation( ).1

actor "Family Administrator" as familyAdministrator
participant ": UI" as ui
participant ": ControllerAddRelation" as controler
participant ": App" as app
participant "familyService : FamilyService" as service


activate familyAdministrator
familyAdministrator -> ui : add realation to member
activate ui
ui -> familyAdministrator : ask:selfID, otherID, relationDesignation, familyID
deactivate ui 
familyAdministrator -> ui : imputs required data
activate ui
ui -> controler : createRelation(sefID, otherID, relationDesignation, familyID)
activate controler

controler -> app : getFamilyService()
activate app
app -> controler : familyService
deactivate app

controler -> service : createRelation(sefID, otherID, relationDesignation, familyID)
activate service

alt failure: Actor is not Admin or a exception was thrown

service -> controler : failure
controler -> ui : failure
ui -> familyAdministrator : Inform Failure

ref over service

createRelation( ).2 

end ref

else sucess

service -> controler : ok

deactivate service
controler -> ui : ok
deactivate controler
ui -> familyAdministrator : Sucess
deactivate ui
deactivate familyAdministrator

end

```
**createRelation( ).2**
```puml
autonumber
title createRelation( ).2

participant ": FamilyService" as service
participant "fam : Family" as fam
participant "person : Person" as person

activate service
-> service : createRelation(sefID, otherID, relationDesignation, familyID)
service -> service : fam =  1. getFamily(familyID)

service -> fam : isAdmin(selfID)
activate fam

alt !isDdmin
fam -> service : !isAdmin()
<- service : failure

else isAdmin

fam -> service: isAdmin()
deactivate fam
service -> fam : hasDesignation(relationDesignation)
activate fam

alt !hasDesignation()
fam -> service : !hasDesignation()


service -> "relation : Relation"** : createRelation(relationDesignation)
service -> fam : addToRelationDesignationList(relationDesignation)

else hasDesignation()

fam -> service : hasDesignation
deactivate fam
service -> "relation : Relation"** : createRelation(relationDesignation)

end

service -> fam : addRelation(otherID, relation)
activate fam
fam -> fam : person = getPerson(otherID)
fam -> person : addRelation(relation)
activate person
person -> person : addRelation(relation)
person -> fam : ok
deactivate person
fam -> service : ok
deactivate fam
<- service : ok

end

deactivate service

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

}

class Relation {
- designation

}

FFMapp -down-> FamilyService : has list of 
FamilyService -down-> Family : has list of
Family -down-> FamilyMember : has list of 
FamilyMember -down-> Relation : has 
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

