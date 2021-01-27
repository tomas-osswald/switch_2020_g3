package switch2020.project.controllers;

import switch2020.project.domain.model.Account;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.categories.StandardCategory;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.services.FamilyService;
import switch2020.project.domain.utils.TransferenceDTO;

public class TransferCashBetweenFamilyMembersCashAccountsController {

        private Application ffmApplication;

        public TransferCashBetweenFamilyMembersCashAccountsController(Application ffmApplication) {
            this.ffmApplication = ffmApplication;
        }

        public boolean TransferCashBetweenFamilyMembersCashAccountsController(TransferenceDTO transferCashDTO){
            FamilyService familyService = this.ffmApplication.getFamilyService();
            CategoryService categoryService = this.ffmApplication.getCategoryService();
            int familyID = transferCashDTO.getFamilyID();
            String familyMemberCC = transferCashDTO.getFamilyMemberCC();
            int accountID = transferCashDTO.getAccountID();
            int categoryID = transferCashDTO.getCategoryID();

            Account originAccount = familyService.getFamily(familyID).getFamilyMember(familyMemberCC).getAccount(accountID);
            Account destinationAccount = familyService.getFamily(familyID).getFamilyMember(familyMemberCC).getAccount(accountID);
            StandardCategory category = categoryService.getStandardCategoryByID(categoryID);

            AccountService accountService = new AccountService();
            return accountService.transferCashBetweenFamilyMembersCashAccounts(originAccount, destinationAccount, category, transferCashDTO);

        }

    }

