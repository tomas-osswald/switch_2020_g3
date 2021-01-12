# Class Diagram
=======================================

```puml

title Class Diagram

class AddEmailController {
  - Application ffmApp
  + boolean addEmail(String emailToAdd, int familyID, int familyMemberID)
}

class AddFamilyController {
  - Application ffmApp
  + boolean addFamily(String familyName)
}

class AddFamilyAdministratorController {
 - Application ffmApp
 + familiesWithoutAdministrator ()
 + addFamilyAdministrator(familyMemberID, name, birthDate, phone, email, vat, street, codPostal, local, city, familyID)
}

class AddFamilyMemberController {
  - Application FFMapp;
  - boolean addFamilyMember(String name, String birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relation relationship, int familyID)
}

class AddRelationController {
  - Application app
  + boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID)
}

class AddStandardCategoryController {
  - Application FFMapp;
  + boolean addStandardCategory(String categoryName)
}

class CategoriesController{
  - Application FFMApplication
}

class CreateFamilyCashAccountController{
  - Application ffmApp
  - boolean createFamilyCashAccount(familyID)
}

class GetFamilyMemberProfileController {
  - Application FFMapp
}

class GetFamilyMembersListController {
  - Application FFMapp
  + List<FamilyMemberRelationDTO> getFamilyMemberAndRelation(int familyID)
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
  + List<FamilyMember> getFamilyMembers(int familyID)
  - Family getFamily(int familyID)
  + List<FamilyMemberRelationDTO> getDTOList(int familyID)
}

class CategoryService {
  - List<Category> categories
  + boolean addStandardCategory(String categoryName)
  - boolean isCategoryAlreadyPresent(String categoryName)
  + List<Category> getCategories()
  + List<Category> getStandardCategories()
}

class Category {
  - String categoryName
  - int categoryLevel
  - int parentNumber
  - boolean standardCategory
  - boolean isNameValid(String categoryName)
  + String getName()
  + boolean isStandardCategory()
}

class FamilyService {
  - List<Family> families
  + boolean addEmail(String emailToAdd, int familyID, int familyMemberID)
  - int findFamilyIndexByID(int familyID)
  - boolean checkIfEmailPresent(String emailToCheck)
  + void addFamily(Family family)
  + boolean addFamily(String familyName)
  + boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID)
  + Family getFamily(int familyID)
  - boolean checkIfFamilyExists(int familyID)
  + boolean addFamilyMember(String name, String birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relation relationship, int familyID)
  + boolean createFamilyCashAccount(int familyID)
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
  - int findFamilyMemberIndexByID(int familyMemberID)
  + boolean isAdmin(int familyMemberID)
  + boolean hasDesignation(String relationDesignation)
  + boolean checkIfVatExists(int vat)
  + boolean addToRelationDesignationList(String relation)
  + boolean addRelationToFamilyMember(int familyMemberID, Relation relation)
  - FamilyMember getFamilyMember(int familyMemberID)
  + void addFamilyMember(FamilyMember familyMember)
  + void addFamilyMemberArray(ArrayList<FamilyMember> familyMembers)
  + int numberOfFamilyMembers()
  + int numberOfRelationDesignations()
  + boolean addEmail(String emailToAdd, int familyMemberID)
  + boolean addFamilyMember(String name, String birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city, Relation relationship)
  + boolean createFamilyCashAccount()
  - boolean hasCashAccount()
}

class CashAccount {
  - int CashAccountID
  - double balance
  + int getCashAccountID()
  + double getBalance()
  + void changeBalance(double value)
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
  + boolean addEmail(String emailToAdd)
  # void addRelation(Relation relation)
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
  - boolean validateEmpty(String x)
}

class PhoneNumber {
  - int phoneNumber
  - boolean validate(int phoneNumber)
}

class EmailAddress {
  - String email
  + String getEmail()
  - boolean validate(String email)
  - boolean checkFormat(String email)
}

class Relation {
  - String relationDesignation
  - void isEmpty(String relationDesignation)
  + String getRelationDesignation()
}

class VatNumber {
  - int vatNumber
  - boolean validate(int vatNumber)
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