


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
    - Private class data pattern 
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
    - Data dentro da AbstractAccount
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