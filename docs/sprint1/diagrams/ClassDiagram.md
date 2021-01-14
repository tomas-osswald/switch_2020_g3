# Class Diagram

```puml
left to right direction
title Class Diagram

class AddEmailController {
  - Application ffmApp
  + boolean addEmail()
}

class AddFamilyController {
  - Application ffmApp
  + boolean addFamily(String familyName)
}

class AddFamilyAdministratorController {
 - Application ffmApp
 + familiesWithoutAdministrator ()
 + addFamilyAdministrator()
}

class AddFamilyMemberController {
  - Application FFMapp;
  - boolean addFamilyMember()
}

class AddRelationController {
  - Application app
  + boolean createRelation()
}

class AddStandardCategoryController {
  - Application FFMapp;
  + boolean addStandardCategory()
}

class CategoriesController{
  - Application FFMApplication
}

class CreateFamilyCashAccountController{
  - Application ffmApp
  - boolean createFamilyCashAccount()
}

class GetFamilyMemberProfileController {
  - Application FFMapp
}

class GetFamilyMembersListController {
  - Application FFMapp
  + List<FamilyMemberRelationDTO> getFamilyMemberAndRelation()
}

class GetStandardCategoriesTreeController {
  - Application app
}

class Application {
  - ArrayList<Category> categories
  - ArrayList<Family> families
  - CategoryService categoryService
  - FamilyService familyService
  + FamilyService getFamilyService()
  + List<FamilyMember> getFamilyMembers()
  - Family getFamily()
  + List<FamilyMemberRelationDTO> getDTOList()
}

class CategoryService {
  - List<Category> categories
  + boolean addStandardCategory()
  - boolean isCategoryAlreadyPresent()
  + List<Category> getCategories()
  + List<Category> getStandardCategories()
}

class Category {
  - String categoryName
  - int categoryLevel
  - int parentNumber
  - boolean standardCategory
  - boolean isNameValid()
  + String getName()
  + boolean isStandardCategory()
}

class FamilyService {
  - List<Family> families
  + boolean addEmail()
  - int findFamilyIndexByID()
  - boolean checkIfEmailPresent()
  + void addFamily()
  + boolean addFamily()
  + boolean createRelation()
  + Family getFamily()
  - boolean checkIfFamilyExists()
  + boolean addFamilyMember()
  + boolean createFamilyCashAccount()
}

class FamilyMemberRelationDTO {
  - String name
  - String relation
  + String getName()
  + String getRelation()
}

class Family {
  - String familyName
  - Date registrationDate
  - int familyID
  - List <FamilyMember> familyMembers
  - List<String> relationDesignations
  - CashAccount familyCashAccount
  + List<FamilyMember> getFamily()
  + int getFamilyID()
  - int findFamilyMemberIndexByID()
  + boolean isAdmin()
  + boolean hasDesignation()
  + boolean checkIfVatExists()
  + boolean addToRelationDesignationList()
  + boolean addRelationToFamilyMember()
  - FamilyMember getFamilyMember()
  + void addFamilyMember()
  + void addFamilyMemberArray()
  + int numberOfFamilyMembers()
  + int numberOfRelationDesignations()
  + boolean addEmail()
  + boolean addFamilyMember()
  + boolean createFamilyCashAccount()
  - boolean hasCashAccount()
}

class CashAccount {
  - int CashAccountID
  - double balance
  + int getCashAccountID()
  + double getBalance()
  + void changeBalance()
}

class FamilyMember {
  - int familyMemberID
  - String name
  - String birthDate
  - List<PhoneNumber> phoneNumbers
  - List<EmailAddress> emails
  - VatNumber vatNumber
  - Address adress
  - Relation relation
  - boolean administrator
  + List<EmailAddress> getEmails()
  + int getVatNumber()
  + int getID()
  + String getRelation()
  + String getName()
  + void makeAdmin()
  + boolean isAdmin()
  # int getFamilyMemberID()
  + boolean addEmail()
  # void addRelation()
}

class MemberProfile {
  - String email
  - String name
  - String birthDate
  - int phone
  - int vatNumber
}

class Address {
  - String street
  - String postalCode
  - String local
  - String city
  - boolean validateEmpty()
}

class PhoneNumber {
  - int phoneNumber
  - boolean validate()
}

class EmailAddress {
  - String email
  + String getEmail()
  - boolean validate()
  - boolean checkFormat()
}

class Relation {
  - String relationDesignation
  - void isEmpty()
  + String getRelationDesignation()
}

class VatNumber {
  - int vatNumber
  - boolean validate()
  + int getVatNumber()
}

AddEmailController --> Application
AddFamilyController --> Application
AddFamilyAdministratorController --> Application
AddFamilyMemberController --> Application
AddRelationController --> Application
AddStandardCategoryController --> Application
CategoriesController --> Application
CreateFamilyCashAccountController --> Application
GetFamilyMemberProfileController --> Application
GetFamilyMembersListController --> Application
GetStandardCategoriesTreeController --> Application
Application --> FamilyService
Application --> CategoryService
CategoryService -> Category
FamilyService -left-> FamilyMemberRelationDTO
FamilyService --> Family
Family -> CashAccount
Family --> FamilyMember
FamilyMember --> Address
FamilyMember --> PhoneNumber
FamilyMember --> Relation
FamilyMember --> MemberProfile
FamilyMember --> EmailAddress
FamilyMember --> VatNumber
```

```puml

title Class Diagram

class AddEmailController {}

class AddFamilyController {}

class AddFamilyAdministratorController {}

class AddFamilyMemberController {}

class AddRelationController {}

class AddStandardCategoryController {}

class CategoriesController{}

class CreateFamilyCashAccountController{}

class GetFamilyMemberProfileController {}

class GetFamilyMembersListController {}

class GetStandardCategoriesTreeController {}

class Application {}

class CategoryService {}

class Category {}

class FamilyService {}

class FamilyMemberRelationDTO {}

class Family {}

class CashAccount {}

class FamilyMember {}

class MemberProfile {}

class Address {}

class PhoneNumber {}

class EmailAddress {}

class Relation {}

class VatNumber {}

AddEmailController --> Application
AddFamilyController --> Application
AddFamilyAdministratorController --> Application
AddFamilyMemberController --> Application
AddRelationController --> Application
AddStandardCategoryController --> Application
CategoriesController --> Application
CreateFamilyCashAccountController --> Application
GetFamilyMemberProfileController --> Application
GetFamilyMembersListController --> Application
GetStandardCategoriesTreeController --> Application
Application --> FamilyService
Application --> CategoryService
CategoryService --> Category
FamilyService -left-> FamilyMemberRelationDTO
FamilyService --> Family
Family --> CashAccount
Family --> FamilyMember
FamilyMember --> Address
FamilyMember --> PhoneNumber
FamilyMember --> Relation
FamilyMember --> MemberProfile
FamilyMember --> EmailAddress
FamilyMember --> VatNumber
```