# 3. Design


```` puml

   autonumber
   title Transfer Money From Family Cash Account To a Personal Cash Account
   actor "Family Administrator" as famAdmin
   participant ": UI" as UI
   participant ": TransferToPersonalCashAccountController" as controller
   participant ": FFMApplication" as application
   
   
   participant ": AccountService" as accServ
   participant ": FamilyService" as famServ
   participant "aFamily : Family" as fam
   participant "aFamilyMember : FamilyMember" as famMemb
   


   participant "newCashAccount : Account" as cashacc
   participant "newAccountData : AccountData" as data
    
   
   activate member
   member -> UI: create a Personal Cash Account
   activate UI
   UI --> member: ask for Account name
   deactivate UI
   member -> UI: input Account name
   activate UI
   UI -> controller: createPersonalCashAccount(name,familyID, familyMemberCC,initialBalance)
   activate controller
   controller -> application: getAccountService()
   activate application
   application --> controller: AccountService
   controller -> application: getFamilyService()
   application --> controller: FamilyService
   deactivate application
   controller -> famServ:getFamilyMember(familyID, familyMemberCC)
   activate famServ
   famServ-> fam: getFamilyMember(familyMemberCC)
   activate fam
   fam --> famServ: FamilyMember
   deactivate fam
   famServ --> controller: FamilyMember
   deactivate famServ 
   controller -> accServ: createPersonalCashAccount(FamilyMember, name, initialBalance)
   activate accServ
   accServ -> accServ: generateAccountID()
   accServ -> cashacc**: newCashAccount(name, initialBalance, accountID)
   activate cashacc
   cashacc -> cashacc: validateName(name)
   cashacc->cashacc: validateBalance(balance)
   cashacc->data**: createAccountData(name, initialBalance, accountID)
   activate data
   data-->cashacc: becomes CashAccount.AccountData
   deactivate data
   cashacc-->accServ: Success
   deactivate cashacc
   accServ->fammemb: addAccount(newCashAccount)
   activate fammemb
   fammemb-->accServ: Success
   deactivate fammemb
   accServ-->controller: Success
   deactivate accServ
   controller --> UI: Success
   deactivate controller
   UI --> member: Inform Success
   deactivate UI
   deactivate member

@endpuml
````

````puml
@startuml

autonumber

Actor "FamilyAdmin" as Actor
Participant "TransferCashFromFamilyAccount\nToPersonalAccountController" as TransferCashFromFamilyAccountToPersonalAccountController
Participant "Application" as App
Participant "FamilyService" as FamilyService
Participant "aFamily\n : Family" as Family
Participant "aFamilyMember\n : FamilyMember" as FamilyMember


Actor -> TransferCashFromFamilyAccountToPersonalAccountController : transferCashFrom\nFamilyToFamilyMember\n(FamilyCashTransferDTO)
activate TransferCashFromFamilyAccountToPersonalAccountController
TransferCashFromFamilyAccountToPersonalAccountController -> App : getFamilyService()
activate App
App --> TransferCashFromFamilyAccountToPersonalAccountController : FamilyService
deactivate App

TransferCashFromFamilyAccountToPersonalAccountController -> FamilyService : getFamily(familyID)
activate FamilyService
FamilyService --> TransferCashFromFamilyAccountToPersonalAccountController : aFamily
deactivate FamilyService

TransferCashFromFamilyAccountToPersonalAccountController -> Family : getFamilyMember(familyMemberCC)
activate Family
Family --> TransferCashFromFamilyAccountToPersonalAccountController : aFamilyMember
deactivate Family

TransferCashFromFamilyAccountToPersonalAccountController -> App : getCategoryService()
activate App
App --> TransferCashFromFamilyAccountToPersonalAccountController : CategoryService
deactivate App

alt categoryID >= 0

TransferCashFromFamilyAccountToPersonalAccountController -> CategoryService : getStandardCategoryByID(categoryID)
activate CategoryService
CategoryService --> TransferCashFromFamilyAccountToPersonalAccountController : category
deactivate CategoryService

else categoryID < 0

TransferCashFromFamilyAccountToPersonalAccountController -> Family : getCustomCategoryByID(categoryID)
activate Family
Family --> TransferCashFromFamilyAccountToPersonalAccountController : category
deactivate Family

end

TransferCashFromFamilyAccountToPersonalAccountController -> AccountService : transferCashFromFamilyToFamilyMember(aFamily, aFamilyMember, category, familyCashTransferDTO)
activate AccountService

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
AccountService --> TransferCashFromFamilyAccountToPersonalAccountController
deactivate AccountService
return
@enduml

````