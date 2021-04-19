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

![img.png](../../assets/img.png)

---

Hipótese B das Categories + versão 1 Family e Family Members
![img_3.png](../../assets/img_3.png)


---  

Hipótese B das Categories + Versão 2 Family e Family Members
![img_4.png](../../assets/img_4.png)


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

## Dúvidas para Prof Nuno Silva - 13/04/2021

REF: SD US010/US101

**1. No SD representam-se os nomes das instâncias?** 

Refere-se que são Interfaces ou Implementações?

Referência - aula NB  

**Prof referiu que instanciação de Value Objects poderia (deveria??) ser feita na camada que faz fronteira com o Domínio.**

Dúvida: Se se entender que o Controller é essa "fronteira" e que criaria os Value Objects, de onde virão os DTO's (Que supostamente transitam do Controller
para o Service).

**2.** Onde instanciar os DTO?, controller?! AppService?

**3.** Explicação do SD do Prof Nuno Silva


Mapeamento automático, no controller, para DTO, qual a anotação?
Classe from data to DTO (Assembler)
Transferir dados entre camadas (Interface to AppServ e vice)
Classes de domínio dependentes de VO 
Criar VO na camada AppServices

por estereotipo no SD, interface 


-------------------------------------------------------------



## Dúvidas - 14/04/2021

**1. Qual é a terceira opção, a elegante? (Professora Isabel)**


-----------------------------------------------------




**2. O que faz sentido nos domain services?**

R: 


P.e. as transferencias têm que manipular dois ledgers, obrigando a ter lógica de negócio na sua manipulação

No caso de create Family and set Admin, como os domain services não têm contacto com a camada de repositórios, não podem fazer as validações necessárias...

**3. Como representar os Builders nos SDs?**

R: respondido e alterado.




Ver documentação da US150

## Decisões a 13/04/2021

AccountData para aglomerar os atributos gerais das Accounts
As Accounts conhecem os seus owners através do OwnerID
Repositorios recebem objetos de domain
Só representamos service para a frente nos SD e "abstraimos" do funcionamento dos repositórios
Mapper para fazer DTOs de saída (exemplo: ProfileInfoDTO)
ID SEMPRE EM CAPS
add no repo para adicionar e save para alterar

14.04.2021 12:01
---------------

Após a aula do PBS alterou-se o SD da US150 na parte do BuilderDTO

Definir o workflow:

- Aplicar o **SpringBoot** nas US010,US101,US101,US151,US001 (esta se conseguissemos fazer era mesmo TOP)

- Aprender a usar o **Mockito** correctamente

- Foi decidido a US010 - Create a  Family and Set Administrator para aplicar SpringBoot + Mockito
    Por esta US a funcionar desde o principio ao fim !!!!

- Testes de integração : abordamos qualquer coisa no final


16.04.2021 17:05
--------------

- Testes AddFamilyMemberServiceTest: getFamilyID

```

if (!personRepository.isPersonIDAlreadyRegistered(personID)) {
    Person admin = personRepository.getByID(loggedUserID);
    FamilyID familyID = admin.getFamilyID();

    Person person = new Person(name, birthDate, personID, vat, phone, address, familyID);
    personRepository.save(person);
}
        
 ``` 

1. A partir da implementação sabemos que este método não falha (visto que a Person na linha anterior foi instanciada num estado válido , com sucesso), sendo impossível não haver retorno deste ID.

2. Segundo a informação que temos sobre _Mock Tests_ estes não devem ser vocacionados para a implementação, e como tal a dúvida é se devemos testar/simular todas as condições inseridas dentro do método.


-----------------------------------------------

Discussão Controller/Service - 16/04/2021

Entre o AddFamilyMemberService e o CreateFamilyService e respetivos controllers, não havia congruência.

No CreateFamilyService o método do Service era boolean e no AddFamilyMember era Void. Ambos usavam a verificação de isPersonAlreadyRegistered que não lança exceção.

Assim, no AddFamilyMemberService se o isPersonAlreadyRegistered fosse true, o método não ia adicionar o Member mas não lannçava exceção para o Controller. Ou seja, o Controller assumia como True a adição da Person sem ela acontecer.

Criou-se uma PersonAlreadyRegisteredException para ambos os Services e converteu-se os métodos para Void pela lógica de poderem falhar por vários motivos (Ao contrário de um boolean que apenas diz true ou false, "sem se saber porquê").

-----

Aula Labproj II - Prof NB

**1** Nos testes do AddFamilyMemberService podemos optar por testar apenas o DTO com um dos Value Objects inválidos e verificar se o método parte por aí.
Ou seja, não é necessário testar todos os value objects e todas as exceções.

Podemos, no entanto, fazê-lo caso um dos objetivos seja verificar que ele parte pelas diversas exceções criadas (Esses testes podem ser feitos nas classes específicas dos Value Objects).

**2** No AddFamilyMemberService estava a haver uma validação para verificar se já existia um user na Aplicação com aquele ID e só depois de verificar é que era instanciado e depois guardado. Como o método do Repository é um Save, pode-se dar esta responsabilidade ao Repository. Ou seja, a pessoa é sempre criada desde que os Value Objects sejam válidos e de seguida é o Repository com a sua magia negra que quando recebe o objeto verifica se já existe algum com aquele ID.

Onde é que isto pode correr mal? perguntou nenhum de vocês...

Se quisermos ter alguma adição ao objeto temos de ponderar uma forma de _update_ em detrimento de um _save_ (Neste momento não é um requisito)

--- 

**Discussão** - 19/04/2021

Nos Repositories ter dois métodos distintos - add e update (Em vez do save() que é ambíguo)

Assim os _adds_ seriam sempre de acréscimo de algo inexistente e o _update_ um overwrite de algum objeto já existente.

Dúvidas para Prof Nuno Silva - 20/04/2021

Repositories CRUD ou JPA? Qual vai ser utilizado

Em função disso, usarmos a nomenclatura adequada.
