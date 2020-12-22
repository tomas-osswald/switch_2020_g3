# US105 Create a relation between two family members
=======================================


# 1. Requirements

## 1.1. Client Notes

As administrator, I want to create a relation between two family members:

**Demonstration 1** As administrator, I want to...

- 1.1. Create a new relation and set that relation to a given member.

**Extracted from communications with the Product Owner**

- *"All relations use the level of the main user of the family as a reference. Be aware that SWS wants its application to be as inclusive as possible, in order to wider its market base"*;
- *"When creating relationships, they are relative to the "main user level", not at all restricted to the main user"*.

The interpretation made of this requirement is that the family administrator can create relationships between family members and him, and these relationships are not restricted to normal family relationships.

## 1.2 System Sequence Diagram

```puml
autonumber
title System Sequence Diagram - US105

actor "Family Administrator" as familyAdministrator
participant ": System" as system

activate familyAdministrator
familyAdministrator -> system : add relation to member
activate system
system -> familyAdministrator : sk:selfID, otherID, relationDesignation, familyID
deactivate system 
familyAdministrator -> system : imputs required data
activate system

alt failure
system -> familyAdministrator : Inform Failure

else sucess
system -> familyAdministrator : Inform Sucess

end

deactivate system

deactivate familyAdministrator
```


## 1.3 Dependencies from other User Stories


# 2. Analysis

For the fulfillment of the raised requirements, we analyze that for the accomplishment of the US we need, at this moment, the impute of the family administrator of the following data:

- Self ID (User that tries to add relation to other Family Member);
- Other ID (ID from the Family Member to whom will be added a relationship);
- Relation Designation (Relationship name);
- Family ID (User's family ID).

From analysis done to requirements gathering, if the user is the family administrator, he/she will be able to add a relationship to the family member in question, regardless of whether the relationship designation exists or does not exist in the list of designations present in the app.

*"o artefacto principal a usar é o Modelo de Domínio (MD). É sempre elaborado numa perspetiva de negócio e não numa perspetiva técnica"*

##2.1 Domain Model Diagram

*Neste secção a equipa deve relatar o estudo/análise/comparação que fez com o intuito de tomar as melhores opções de design para a funcionalidade bem como aplicar diagramas/artefactos de análise adequados.*

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

activate familyAdministrator
familyAdministrator -> ui : add realation to member
activate ui
ui -> familyAdministrator : ask:selfID, otherID, relationDesignation, familyID
deactivate ui 
familyAdministrator -> ui : imputs required data
activate ui
ui -> controler : createRelation(sefID, otherID, relationDesignation, familyID)
activate controler
controler -> app : createRelation(sefID, otherID, relationDesignation, familyID)
activate app

alt failure: Actor is not Admin

app -> controler : failure
controler -> ui : failure
ui -> familyAdministrator : Inform Failure

ref over app

createRelation( ).2 

end ref

else sucess

app -> controler : ok

deactivate app
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

participant ": App" as app
participant "fam : Family" as fam
participant "person : Person" as person

activate app
-> app : createRelation(sefID, otherID, relationDesignation, familyID)
app -> app : fam =  1. getFamily(familyID)

app -> fam : isAdmin(selfID)
activate fam

alt !isDdmin
fam -> app : !isAdmin()
<- app : failure

else isAdmin

fam -> app: isAdmin()
deactivate fam
app -> app : hasDesignation(relationDesignation)

alt !hasDesignation()

app -> "relation : Relation"** : createRelation(relationDesignation)
app -> app : addToRelationList(relation)

else hasDesignation()

app -> app : relation = relation(relationDesignation)

end

app -> fam : addRelation(otherID, relation)
activate fam
fam -> fam : person = getPerson(otherID)
fam -> person : addRelation(relation)
activate person
person -> person : addRelation(relation)
person -> fam : ok
deactivate person
fam -> app : ok
deactivate fam
<- app : ok

end

deactivate app

```

## 3.2. Class Diagram

```puml
title Class Diagram

class FFMapp {
- Category list

}

class Family {
- familyID
- registrationDate
- familyID

}

class Person {
- personID
- name
- birthDate

}

class Relation {
- designation

}

FFMapp -> Family : has list of 
Family -> Person : has list of 
Person -> Relation : has 
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

