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