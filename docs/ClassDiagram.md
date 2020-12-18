# Class Diagram
=======================================


```puml
title Class Diagram

class FFMApplication {
  - List<Family> families
  - List<Category> categories
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

class Category {
  - int categoryID
  - int parentCategoryID
  - String designation
}

class CashAccount {
  - int CashAccountID
  - double balance
}

class FamilyMember {
  - int familyMemberID
  - String name
  - VATnumber VATnumber
  - Address adress
  - date birthDate
  - PhoneNumber phoneNumber
  - Email email
  - Relationship relationship
  - getRelationship()
  - getProfilInformation()
  - addEmailAccount()
}

class Address {
  - String streetName
  - String locality
  - String postalCode
  + validatePostalCode()
}

class PhoneNumber {
  - String phoneNumber
}

class Email {
  - String email
  + isSameEmail()
}

class Relationship {
  - String designation
  - int relatedFamilyMemberID
}

Family --> CashAccount
Family --> FamilyMember
FamilyMember --> Address
FamilyMember --> PhoneNumber
FamilyMember --> Email
FFMApplication --> Family
FFMApplication --> Category
FamilyMember --> Relationship
```