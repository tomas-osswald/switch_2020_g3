```puml

hide empty members
hide circles
left to right direction
skinparam linetype ortho
title Domain Model Diagram - SP01

class Family {
UniqueID
Name
RegistrationDate
}

class FamilyMember {
Name
BirthDate
}


class Address {
Street
Postal Code
Local
City
}

class CashAccount {
UniqueID
Balance
}

class Relation {
Designation
}

class Category {
UniqueID
Name
}

Family "*" -- "*" Category : \n\nhas standard >
Family "1" -- "0..*" Category : \n\nhas custom >
Family "1" -- "1" CashAccount : has >
Family "1" -- "1" FamilyMember : has administrator >
Family "1" -- "1..*" FamilyMember : has members >


```