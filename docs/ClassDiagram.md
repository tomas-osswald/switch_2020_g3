# Class Diagram
=======================================

```puml
title Class Diagram

class Application {
  - CategoryService categoryService
  - FamilyService familyService
  + getFamilyService()
  + getCategoryService()
  + addEmail(String emailToAdd, int familyMemberID)
  - checkIfEmailPresent(String emailToCheck)
}

class CategoryService {
  - List<Category> categories
  + createStandardCategoriesList()
  + checkIfIsStandard()
  + addCategoryToStandardList
}

class Category {
  - int ID
  - int parentID
  - String categoryName
  - boolean standard
  - int categoryLevel
}

class FamilyService {
  - List<Family> families
  - getFamilyByID()
  + createFamilyCashAccount(int familyID)
  + getDTOList(int familyID)
  + findFamily(int familyID)
  + getMemberProfile(int familyMemberID)
}

class FamilyMemberRelationDTO {
  - String name
  - String relationDesignation
  + getName()
  + getRelation()
}

class Family {
  - int familyID
  - String name
  - date registrationDate
  - List <FamilyMember> familyMembers
  - CashAccount cashAccount
  + addFamilyMember(FamilyMember member)
  + addEmail(String emailToAdd, int familyMemberID)
  - findFamilyMemberIndexByID(int familyMemberID)
  + getFamilyID()
  + hasCashAccount()
  + createFamilyCashAccount()
  + isAdmin(int familyMemberID)
  + hasDesignation(String relationDesignation)
  + addToRelationDesignationList(String relation)
  + addRelationToFamilyMember(int familyMemberID, Relation relation)
  + getFamilyMember(int familyMemberID)
  + addFamilyMember(FamilyMember familyMember)
  - addFamilyMemberArray(ArrayList<FamilyMember> familyMembers)
  - numberOfFamilyMembers()
  - numberOfRelationDesignations()
  + getMemberProfile()
}

class CashAccount {
  - int CashAccountID
  - double balance
  + getID()
}

class FamilyMember {
  - int familyMemberID
  - String name
  - VATnumber VATnumber
  - Address adress
  - date birthDate
  - PhoneNumber phoneNumber
  - Email email
  - Relation relationDesignation
  - boolean administrator
  - getRelation()
  - getProfilInformation()
  + makeAdministrator()
  - isAdmin
  + getFamilyMemberID
  + createProfile()  
}

class MemberProfile {
  
}

class Address {
  - String streetName
  - String locality
  - String postalCode
  - validatePostalCode()
}

class PhoneNumber {
  - String phoneNumber
  - validate()
}

class Email {
  - String email
  + getEmail()
  - validate()
  - checkFormat()
}

class Relation {
  - String relationDesignation
  - int relatedFamilyMemberID
  - getRelationDesignation()
  - isEmpty(String relationDesignation)
}

Family --> CashAccount
Family --> FamilyMember
FamilyMember --> Address
FamilyMember --> PhoneNumber
FamilyMember --> Email
Application --> FamilyService
FamilyService --> FamilyMemberRelationDTO
FamilyService --> Family
Application --> CategoryService
CategoryService --> Category
FamilyMember --> Relation
FamilyMember --> MemberProfile
```