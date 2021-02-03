# 3. Design


```` puml
@startuml
participant Actor
Actor -> TransferCashFromFamilyAccountToPersonalAccountController : transferCashFromFamilyToFamilyMember
activate TransferCashFromFamilyAccountToPersonalAccountController
TransferCashFromFamilyAccountToPersonalAccountController -> FamilyService : getFamily
activate FamilyService
FamilyService -> FamilyService : checkIfFamilyExists
activate FamilyService
FamilyService --> FamilyService
deactivate FamilyService
FamilyService --> TransferCashFromFamilyAccountToPersonalAccountController
deactivate FamilyService
TransferCashFromFamilyAccountToPersonalAccountController -> FamilyService : getFamily
activate FamilyService
FamilyService -> FamilyService : checkIfFamilyExists
activate FamilyService
FamilyService --> FamilyService
deactivate FamilyService
FamilyService --> TransferCashFromFamilyAccountToPersonalAccountController
deactivate FamilyService
TransferCashFromFamilyAccountToPersonalAccountController -> Family : getFamilyMember
activate Family
Family -> FamilyMember : compareID
activate FamilyMember
FamilyMember --> Family
deactivate FamilyMember
Family --> TransferCashFromFamilyAccountToPersonalAccountController
deactivate Family
TransferCashFromFamilyAccountToPersonalAccountController -> CategoryService : getStandardCategoryByID
activate CategoryService
CategoryService --> TransferCashFromFamilyAccountToPersonalAccountController
deactivate CategoryService
TransferCashFromFamilyAccountToPersonalAccountController -> Family : getCustomCategoryByID
activate Family
Family --> TransferCashFromFamilyAccountToPersonalAccountController
deactivate Family
TransferCashFromFamilyAccountToPersonalAccountController -> AccountService : transferCashFromFamilyToFamilyMember
activate AccountService
AccountService -> MoneyValue : new
activate MoneyValue
MoneyValue --> AccountService
deactivate MoneyValue
AccountService -> Account : hasEnoughMoneyForTransaction
activate Account
Account --> AccountService
deactivate Account
AccountService -> Account : checkCurrency
activate Account
Account --> AccountService
deactivate Account
AccountService -> FamilyMember : getAccount
activate FamilyMember
FamilyMember -> Account : isIDOfThisAccount
activate Account
Account --> FamilyMember
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
AccountService --> TransferCashFromFamilyAccountToPersonalAccountController
deactivate AccountService
return
@enduml
````