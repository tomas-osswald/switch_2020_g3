# US130 Transfer Money from Family Cash Account To a Personal Cash Account
==========================================================================


# 1. Requirements

*As a family administrator, I want to transfer money from the family cash account to another family's member cash account*


**1** As a family administrator, I want to transfer money from the family cash account to...

- 1.1. The already existing cash account of a family member;

- 1.2. A new cash account of a family member;

We interpreted this requirement as a function for the family administrator to transfer money from the family cash account
to the cash account of any family member. If the family member doesn't have a cash account a new cash account will be created
The money transfer must be a positive value and of the same currency as the family and destination cash account.
The money transfer will only occur if the family has a cash account and if that cash account has enough money for the transaction.

# 2. Analysis



# 3. Design

````puml
@startuml

autonumber

Actor "FamilyAdmin" as Actor
Participant ": TransferCashFromFamilyAccount\nToPersonalAccountController" as controller
Participant ": Application" as App
Participant ": FamilyService" as FamilyService
Participant "aFamily\n : Family" as Family
Participant ": CategoryService" as CategoryService
Participant ": AccountService" as AccountService
Participant "aFamilyMember\n : FamilyMember" as FamilyMember

Actor -> controller : Transfer Money to Family Member
controller -> Actor : ask for required data

Actor -> controller : transferCashFrom\nFamilyToFamilyMember\n(FamilyCashTransferDTO)
activate controller
controller -> App : getFamilyService()
activate App
App --> controller : FamilyService
deactivate App

controller -> FamilyService : getFamily(familyID)
activate FamilyService
FamilyService --> controller : aFamily
deactivate FamilyService

controller -> Family : getFamilyMember(familyMemberCC)
activate Family
Family --> controller : aFamilyMember
deactivate Family



alt categoryID >= 0
controller -> App : getCategoryService()
activate App
App --> controller : CategoryService
deactivate App
controller -> CategoryService : getStandardCategoryByID(categoryID)
activate CategoryService
CategoryService --> controller : aCategory
deactivate CategoryService

else categoryID < 0

controller -> Family : getCustomCategoryByID(categoryID)
activate Family
Family --> controller : aCategory
deactivate Family

end

controller -> AccountService : transferCashFromFamilyToFamilyMember(aFamily, aFamilyMember, category, familyCashTransferDTO)
activate AccountService

AccountService -> Family : getFamilyCashAccount()
activate Family
Family --> AccountService : familyCashAccount
deactivate Family

AccountService -> FamilyMember : getAccount
activate FamilyMember
FamilyMember -> Account : isIDOfThisAccount
activate Account
Account --> FamilyMember
deactivate Account

AccountService -> Account : hasEnoughMoneyForTransaction
activate Account
Account --> AccountService
deactivate Account
AccountService -> Account : checkCurrency
activate Account
Account --> AccountService
deactivate Account

FamilyMember --> AccountService
deactivate FamilyMember
AccountService -> AccountService : generateID
activate AccountService
AccountService --> AccountService
deactivate AccountService
AccountService -> CashAccount : new
activate CashAccount
CashAccount -> CashAccount : validateBalance
activate CashAccount
CashAccount --> CashAccount
deactivate CashAccount
CashAccount -> AccountData : new
activate AccountData
AccountData -> AccountData : validateDesignation
activate AccountData
AccountData -> InvalidAccountDesignationException : new
activate InvalidAccountDesignationException
InvalidAccountDesignationException --> AccountData
deactivate InvalidAccountDesignationException
AccountData --> AccountData
deactivate AccountData
AccountData -> MoneyValue : new
activate MoneyValue
MoneyValue --> AccountData
deactivate MoneyValue
AccountData -> MoneyValue : new
activate MoneyValue
MoneyValue --> AccountData
deactivate MoneyValue
AccountData --> CashAccount
deactivate AccountData
CashAccount -> AccountData : new
activate AccountData
AccountData -> AccountData : validateDesignation
activate AccountData
AccountData -> InvalidAccountDesignationException : new
activate InvalidAccountDesignationException
InvalidAccountDesignationException --> AccountData
deactivate InvalidAccountDesignationException
AccountData --> AccountData
deactivate AccountData
AccountData -> MoneyValue : new
activate MoneyValue
MoneyValue --> AccountData
deactivate MoneyValue
AccountData -> MoneyValue : new
activate MoneyValue
MoneyValue --> AccountData
deactivate MoneyValue
AccountData --> CashAccount
deactivate AccountData
CashAccount --> AccountService
deactivate CashAccount
AccountService -> Account : debit
activate Account
Account --> AccountService
deactivate Account
AccountService -> Account : credit
activate Account
Account --> AccountService
deactivate Account
AccountService -> TransactionService : registerCashTransfer
activate TransactionService
TransactionService -> Account : checkAccountType
activate Account
Account --> TransactionService
deactivate Account
TransactionService -> Account : checkAccountType
activate Account
Account --> TransactionService
deactivate Account
TransactionService -> CashAccount : registerTransaction
activate CashAccount
CashAccount -> AccountData : registerCashTransaction
activate AccountData
AccountData -> CashTransaction : new
activate CashTransaction
CashTransaction --> AccountData
deactivate CashTransaction
AccountData --> CashAccount
deactivate AccountData
CashAccount --> TransactionService
deactivate CashAccount
TransactionService -> CashAccount : registerTransaction
activate CashAccount
CashAccount -> AccountData : registerCashTransaction
activate AccountData
AccountData -> CashTransaction : new
activate CashTransaction
CashTransaction --> AccountData
deactivate CashTransaction
AccountData --> CashAccount
deactivate AccountData
CashAccount --> TransactionService
deactivate CashAccount
TransactionService --> AccountService
deactivate TransactionService
AccountService --> controller
deactivate AccountService
return
@enduml

````