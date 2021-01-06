# Class Diagram
=======================================

```puml
title Class Diagram

class Application {
  - CategoryService categoryService
  - FamilyService familyService
  + getFamilyService()
  + getCategoryService()
}

class CategoryService {
  - List<Category> categories
  + createStandardCategoriesList()
  + checkIfIsStandard()
  + addCategoryToStandardList
  + doesCategoryAlreadyExist(String name)
  + create(String name)
  + addCategory(Category newCategory)
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
  + addEmail(String emailToAdd, int familyMemberID)
  - checkIfEmailPresent(String emailToCheck)
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
  + getFamilyID()
  + createFamilyMember(name,dateBirth,vat,phone,address)
  + addFamilyMember(FamilyMember familyMember)
  - findFamilyMemberIndexByID(int familyMemberID)
  + getFamilyMember(int familyMemberID)
  - addFamilyMemberArray(ArrayList<FamilyMember> familyMembers)
  - numberOfFamilyMembers()
  + getMemberProfile()
  + checkIfVatExists()
  + addEmail(String emailToAdd, int familyMemberID)
  + hasCashAccount()
  + createFamilyCashAccount()
  + isAdmin(int familyMemberID)
  + hasDesignation(String relationDesignation)
  + addToRelationDesignationList(String relation)
  + addRelationToFamilyMember(int familyMemberID, Relation relation)
  - numberOfRelationDesignations()
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
  - isAdmin()
  + getFamilyMemberID()
  + createProfile()
  + createVat(vat)
  + createAddress(Address)
  + createPhoneNumber(phoneNumber)
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