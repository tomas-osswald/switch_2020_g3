# Sprint 3

# This document keeps track of the different Class Diagrams throughout the sprint

    22 março 2021

    Log:

## 1. Retirada 2ª hipótese representação de agregado Category.

## 2. Hipóteses de ligação da Family às Categories:

### a. TreeTop ligado ao FamilyID (Uma treetop tem um familyID)

### b. Agregado Category tem uma Categoria Raíz.

Existe apenas Interface Category no Agregado Category (remover o TreeTop) implementada por Standard e Custom Category.  
Family tem ligação de 1 para 1 com um CategoryID (Value object) que corresponde a uma Standard Category.  
Esta Standard Category implementa a Interface Category (Root).

### PERGUNTA: Uma Root Entity de um agregado pode ser uma Interface?

### c. Três subtipos de Category que implementam a Interface Category.
A TreeTop será uma Category que não tem ParentID e possivelmente a Designação envolverá o nome da família.
NOTA: Pode-se eventualmente definir o parentID da TreeTop como um número "default" (exemplo -1)  
Este número quereria dizer que não há Categoria pai e o ciclo parava de iterar em busca de um parent.
##### Boa prática? Número mágico


## 3. Representação de ligação entre pessoas e famílias


### Versão 1
Family Members conhecem a sua família.  
Family não conhece os seus family Members  
FamilyMember tem um atributo ID (Email) e tem um outro atributo familyID (email do admin)


### Versão 2
Family conhece os seus members.   
Members não conhecem a família a que pertencem
Family tem uma lista de Family Members (emails)
Family Member tem um ID (email)


Hipotése C das Categories + Versão inicial de Family e Family Members (Antes da aula de LABPROJ II)

![img.png](img.png)

---

Hipótese B das Categories + versão 1 Family e Family Members
![img_3.png](img_3.png)


---  

Hipótese B das Categories + Versão 2 Family e Family Members
![img_4.png](img_4.png)


---
---
---
---

# Sprint 4



05/04/2021

Dúvida enviada à Prof Isabel em 09/04/2021

Opção Um:
```puml
hide empty members
skinparam linetype ortho

interface Account {
}

interface NonCashAccount{
}

class CashAccount {
}

class BankAccount {
}

class CreditCardAccount{}

class DebitCardAccount{}

class AccountData{}

CashAccount .--|> Account
NonCashAccount .-|> Account

BankAccount .-|> NonCashAccount
CreditCardAccount .-|> NonCashAccount
DebitCardAccount .-|> NonCashAccount

AccountData --* CashAccount
AccountData --* BankAccount
AccountData --* CreditCardAccount
AccountData --* DebitCardAccount

'note "Data dentro da AccountData. Cons: Codigo desnecessário (fowards em todas as contas) Pros: Private class data pattern;" as note

Note as N1
    - Data dentro da AccountData
    Cons:
    - Codigo desnecessário (forwards em todas as contas);
    - Acoplamento entre as implementações de Account e AccountData
    Pros:
    - Baixo custo de refactoring (feito no semestre passado)
    - Fácil acrescentar novos atributos
end Note

@enduml
```
Opção dois:
````puml
@startuml

hide empty members
'skinparam linetype ortho

interface Account{
}

abstract class AbstractAccount {}

abstract class NonCashAccount{
}

class CashAccount{
}

class BankAccount{
}

class BankSavingsAccount{
}

class CreditCardAccount{
}

AbstractAccount .-|> Account

CashAccount --|> AbstractAccount
NonCashAccount --|> AbstractAccount

BankAccount --|> NonCashAccount
BankSavingsAccount --|> NonCashAccount
CreditCardAccount --|> NonCashAccount

'note "Data dentro da AbstractAccount. Cons: herança; Pros:" as note

Note as N1
    - Data dentro da AccountData
    Cons:
    - Herança;
    - Acoplamento entre as implementações concretas de Account e AbstractAccount
    Pros:
    - Abstração da implementação;
    - Redução de codigo repetido 
    (evitar forwards para a classe que contém a data);
end Note

@enduml
````


---
---


## Discussão Possibilidades Domain Model (09/04/2021) :


###1. Atualmente implementada (09/04/2021):

   Accounts não conhecem os seus "owners". Person e Family é que conhecem as suas Accounts (através de um AccountID).  


   **Vantagens**:
   Permite iterar apenas dentro do Agregado pretendido.
   Isto é, as Accounts estão só na Person ou na Family e como tal não
   é necessário iterar por todas as Accounts existentes no Universo.

   **Desvantagens**:
   Necessidade de escrever em dois Agregados em simultâneo (Person + Account ou Family + Account).
   Assim, como a Account não conhece o seu OwnerID tem de se guardar a Account no AccountRepository e no Person ou FamilyRepository.



###2. Account conhece o Family Member a que pertence. Account conhece PersonID.
   Account também conhece a Family a que pertence (No caso da Family Cash Account)  
   

   **Vantagens**:
   Ao adicionar uma Account não necessitamos de escrever em dois repositórios (Family + Account ou Person + Account).
   Neste caso como temos o ID da Person ou Family, apenas é necessário guardar no Repository das Accounts, visto que já conhecem o seu Owner (Não tem de se escrever também
   no Repository de Person ou de Family).

   **Desvantagens**:
   Mais uma Interface que tem de ser criada (ownerID) que implementa a Interface ID e que servirá de atributo da Account
   (Assim, este atributo é o mais genérico possível podendo ser um identificativo
   de Person, Family, ou outra coisa que possa surgir).

   **NOTA: Inverso do que está atualmente implementado (09/04/2021)**

12.04.2021
---------------

Reunião com: todos

- Accounts:

   - Discussão entre as 2 hipoteses sugeridas antes. Verificação de vantagens e desvantagens entre cada solução.
   
   A class **PersonID** ou **FamilyID** é uma implementação de **OwnerID**, e cada conta teria como atributo um **OwnerId** em vez de ter um **PersonId** ou um **FamilyId**

   **A decisão de qual das alternativas a adoptar está dependente da resposta da prof Isabel ???**

- Next steps:


   

   Team1 :  US101, US150, US151
   
   Team2 : US170, US171, US172, US173, US120

   - Vamos avançar para qual ?
```US101 As a family administrator, I want to add family members.```
     
```US150 As a family member, I want to get my profile’s information.```

```US151 As a family member, I want to add an email account to my profile.```

- US101






------------------------------